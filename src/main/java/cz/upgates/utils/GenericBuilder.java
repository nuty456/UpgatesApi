package cz.upgates.utils;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.*;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * The GenericBuilder class provides a way to construct an instance of a generic class with specified property values
 * and generate a JSON representation of the instance.
 *
 * @param <T> The type of the class to build
 */
@Slf4j
public class GenericBuilder<T> {

  private final Class<T> clazz;
  private final Map<String, Object> propertyValues;
  private final Map<String, String> propertyJsonNames;

  /**
   * Constructs a new GenericBuilder
   *
   * @param <T>   The type of the class to build
   * @param clazz The class to build
   */
  public GenericBuilder(Class<T> clazz) {
    this.clazz = clazz;
    this.propertyValues = new HashMap<>();
    this.propertyJsonNames = new HashMap<>();
  }

  /**
   * Adds a property value to the builder.
   *
   * @param fieldName The name of the field to set the value for
   * @param value     The value to set for the field
   * @return The updated GenericBuilder instance
   */
  public GenericBuilder<T> with(String fieldName, Object value) {
    propertyValues.put(fieldName, value);
    propertyJsonNames.put(fieldName, getJsonPropertyName(fieldName));
    return this;
  }

  /**
   * Builds an instance of a class with specified property values.
   *
   * @return The built instance of the class
   * @throws Exception if an error occurs during the build process
   */
  public T build() throws Exception {
    T instance = clazz.getDeclaredConstructor().newInstance();
    for (Map.Entry<String, Object> entry : propertyValues.entrySet()) {
      Field field = clazz.getDeclaredField(entry.getKey());
      field.setAccessible(true);
      field.set(instance, entry.getValue());
    }
    return instance;
  }

  /**
   * Builds a JSON representation of the built instance.
   *
   * @return The JSON representation of the built instance
   * @throws Exception if an error occurs during the JSON serialization process
   */
  public String buildJson() throws Exception {
    T instance = build();
    ObjectMapper objectMapper = new ObjectMapper();
    Set<String> jsonNames = new HashSet<>(propertyJsonNames.values()); // Create a Set of jsonNames
    FilterProvider filters = new SimpleFilterProvider()
        .addFilter("filter properties by name",
            SimpleBeanPropertyFilter.filterOutAllExcept(jsonNames));
    objectMapper.setFilterProvider(filters);

    // To use filter, add mix-in annotation to the target class
    objectMapper.addMixIn(instance.getClass(), PropertyFilterMixIn.class);

    return objectMapper.writeValueAsString(instance);
  }


  /**
   * Returns the value of the JsonProperty annotation for the given field name.
   *
   * @param fieldName The name of the field
   * @return The value of the JsonProperty annotation for the field, or null if the field does not have the annotation
   */
  private String getJsonPropertyName(String fieldName) {
    try {
      Field field = clazz.getDeclaredField(fieldName);
      JsonProperty jsonProperty = field.getAnnotation(JsonProperty.class);
      if (jsonProperty != null) {
        return jsonProperty.value();
      }
    } catch (NoSuchFieldException e) {
      log.error("Exception: %s".formatted(e.getMessage()), e);
    }
    return null;
  }

  @JsonFilter("filter properties by name")
  static
  class PropertyFilterMixIn {
  }
}