package cz.upgates.models.xmlExports;

import cz.upgates.models.products.SimpleProduct;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an XML export of products.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlRootElement(name = "PRODUCTS")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso(ArrayList.class)
public class XmlProductsExport {
  @XmlAttribute
  private String version = "2.0";
  @XmlElement(name = "PRODUCT")
  private List<SimpleProduct> products = new ArrayList<>();
}
