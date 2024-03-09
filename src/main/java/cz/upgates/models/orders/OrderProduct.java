package cz.upgates.models.orders;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Represents a product: Produkty.
 */
@Data
public class OrderProduct {
  /**
   * ID produktu z databáze (pouze orientačně, pro párování produktů slouží `code`)
   */
  @JsonProperty("product_id")
  private Integer productId;

  /**
   * ID varianty z databáze (pouze orientačně, pro párování produktů slouží `code`). Bude vyplněno pouze tehdy, pokud je položka varianta produktu
   */
  @JsonProperty("option_set_id")
  private Integer optionSetId;

  /**
   * Product code: Kód produktu.
   */
  @JsonProperty("code")
  private String code;

  /**
   * Supplier code: Kód dodavatele.
   */
  @JsonProperty("code_supplier")
  private String codeSupplier;

  /**
   * Product EAN: EAN produktu.
   */
  @JsonProperty("ean")
  private String ean;

  /**
   * Product title: Název produktu.
   */
  @JsonProperty("title")
  private String title;

  /**
   * Product quantity: Počet kusů.
   */
  @JsonProperty("quantity")
  private Float quantity;

  /**
   * Product unit: Jednotka.
   */
  @JsonProperty("unit")
  private String unit;

  /**
   * Price per unit: Cena za jednu jednotku produktu.
   */
  @JsonProperty("price_per_unit")
  private Float pricePerUnit;

  /**
   * VAT: Hodnota DPH v %.
   */
  @JsonProperty("vat")
  private Float vat;

  /**
   * Buy price: Nákupní cena.
   */
  @JsonProperty("buy_price")
  private Float buyPrice;

  /**
   * Recycling fee: Recyklační poplatek.
   */
  @JsonProperty("recycling_fee")
  private Float recyclingFee;

  /**
   * Weight: Váha jedné jednotky produktu v gramech.
   */
  @JsonProperty("weight")
  private Integer weight;

  /**
   * Invoice info: Poznámka k produktu která se propisuje do faktury.
   */
  @JsonProperty("invoice_info")
  private String invoiceInfo;

  /**
   * Parameters: Pole objektů s parametry produktu.
   */
  @JsonProperty("parameters")
  private List<Parameter> parameters;

  /**
   * Parameters: Pole objektů s konfiguracemi produktu
   */
  @JsonProperty("configurations")
  private List<Configuration> configurations;

  /**
   * pole objektů s kategoriemi, do kterých byl produkt zařazen v době vytvoření objednávky
   */
  @JsonProperty("categories")
  private List<Category> categories;

  /**
   * URL obrázku, hlavní obrázek z produktu.
   */
  @JsonProperty("image_url")
  private String imageUrl;

  /**
   * dodavatel
   */
  @JsonProperty("supplier")
  private String supplier;

  /**
   * příznak  pouze pro dospělé
   */
  @JsonProperty("adult_yn")
  private Boolean adultYn;

  /**
   * množství
   */
  @JsonProperty("length")
  private String length;

  /**
   * jednotka množství
   */
  @JsonProperty("length_unit")
  private String lengthUnit;

  /**
   * celková cena za produkt (cena je s nebo bez DPH podle příznaku `prices_with_vat_yn`)
   */
  @JsonProperty("price")
  private Float price;

  /**
   * celková cena za produkt s DPH
   */
  @JsonProperty("price_with_vat")
  private Float priceWithVat;

  /**
   * celková cena za produkt bez DPH
   */
  @JsonProperty("price_without_vat")
  private Float priceWithoutVat;

  /**
   * dostupnost produktu ve chvíli, kdy byl objednán
   */
  @JsonProperty("availability")
  private String availability;

  /**
   * pozice na skladě.
   */
  @JsonProperty("stock_position")
  private String stockPosition;

}

