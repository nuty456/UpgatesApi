package cz.upgates.models.orders;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Orders: Pole objektů s objednávkami.
 */
@Data
public class Order {
  /**
   * Order Number: Číslo objednávky.
   */
  @JsonProperty("order_number")
  private String orderNumber;

  /**
   * Case Number: Číslo obchodního případu.
   */
  @JsonProperty("case_number")
  private String caseNumber;

  /**
   * External Order Number: Číslo objednávky z externího systému.
   */
  @JsonProperty("external_order_number")
  private String externalOrderNumber;

  /**
   * Language: Jazyk objednávky.
   */
  @JsonProperty("language_id")
  private String languageId;

  /**
   * Currency: Měna objednávky.
   */
  @JsonProperty("currency_id")
  private String currencyId;

  /**
   * Default Currency Rate: Kurz pro výchozí měnu.
   */
  @JsonProperty("default_currency_rate")
  private Float defaultCurrencyRate;

  /**
   * Prices with VAT yn: Příznak, jestli jsou ceny s DPH.
   */
  @JsonProperty("prices_with_vat_yn")
  private Boolean pricesWithVatYN;

  /**
   * Status Id: ID stavu objednávky.
   */
  @JsonProperty("status_id")
  private Integer statusId;

  /**
   * Status: Název stavu objednávky
   */
  @JsonProperty("status")
  private String status;

  /**
   * Paid Date: Datum zaplacení objednávky.
   */
  @JsonProperty("paid_date")
  private Date paidDate;

  /**
   * Tracking Code: Trackovací kód pro dopravu.
   */
  @JsonProperty("tracking_code")
  private String trackingCode;

  /**
   * Tracking Url: Trackovací URL pro dopravu.
   */
  @JsonProperty("tracking_url")
  private String trackingURL;

  /**
   * Resolved yn: Příznak pro vyřešenou objednávku.
   */
  @JsonProperty("resolved_yn")
  private Boolean resolvedYN;

  /**
   * OSS yn: Příznak, jestli byla objednávka vytvořena v režimu OSS.
   */
  @JsonProperty("oss_yn")
  private Boolean ossYN;

  /**
   * Internal Note: Interní poznámka.
   */
  @JsonProperty("internal_note")
  private String internalNote;

  /**
   * Last Update Time: Datum aktualizace.
   */
  @JsonProperty("last_update_time")
  private Date lastUpdateTime;

  /**
   * Creation Time: Datum vytvoření.
   */
  @JsonProperty("creation_time")
  private Date creationTime;

  /**
   * Variable Symbol: Variabilní symbol.
   */
  @JsonProperty("variable_symbol")
  private String variableSymbol;

  /**
   * Total Weight: Celková váha objednávky v gramech.
   */
  @JsonProperty("total_weight")
  private Integer totalWeight;

  /**
   * Order Total: Celková cena s DPH.
   */
  @JsonProperty("order_total")
  private Float orderTotal;

  /**
   * Order Total Before Round: Celková cena s DPH před zaokrouhlením.
   */
  @JsonProperty("order_total_before_round")
  private Float orderTotalBeforeRound;

  /**
   * Order Total Rest: Hodnota zaokrouhlení celkové ceny s DPH.
   */
  @JsonProperty("order_total_rest")
  private Float orderTotalRest;

  /**
   * Invoice Number: Číslo faktury.
   */
  @JsonProperty("invoice_number")
  private String invoiceNumber;

  /**
   * Origin: Původ vytvoření objednávky.
   */
  @JsonProperty("origin")
  private Origin origin;

  /**
   * Admin Url: URL do detailu objednávky v administraci.
   */
  @JsonProperty("admin_url")
  private String adminURL;

  /**
   * Customer: Zákazník.
   */
  @JsonProperty("customer")
  private Customer customer;

  /**
   * Products: Pole objektů s produkty.
   */
  @JsonProperty("products")
  private List<OrderProduct> products;

  /**
   * Discount Voucher: Slevový kupón.
   */
  @JsonProperty("discount_voucher")
  private DiscountVoucher discountVoucher;

  /**
   * Quantity Discount: Množstevní sleva.
   */
  @JsonProperty("quantity_discount")
  private QuantityDiscount quantityDiscount;

  /**
   * Loyalty Points: Věrnostní body.
   */
  @JsonProperty("loyalty_points")
  private LoyaltyPoints loyaltyPoints;

  /**
   * Shipment: Doprava.
   */
  @JsonProperty("shipment")
  private Shipment shipment;

  /**
   * Payment: Platba.
   */
  @JsonProperty("payment")
  private Payment payment;

  /**
   * Metas: Pole objektů s vlastními poli.
   */
  @JsonProperty("metas")
  private List<Meta> metas;

  /**
   * Invoice: Faktura, možnost vygenerování faktury.
   */
  @JsonProperty("invoice")
  private Invoice invoice;

}