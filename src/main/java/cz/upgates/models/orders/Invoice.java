package cz.upgates.models.orders;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * Represents Invoice: Faktura, možnost vygenerování faktury.
 */
@Data
public class Invoice {
  /**
   * Generate yn: Příznak o vygenerování faktury.
   */
  @JsonProperty("generate_yn")
  private Boolean generateYN;

  /**
   * Expiration date: Datum splatnosti.
   */
  @JsonProperty("expiration_date")
  private Date expirationDate;

  /**
   * Date of issuance: Datum vystavení.
   */
  @JsonProperty("date_of_issuance")
  private Date dateOfIssuance;

  /**
   * Date of VAT revenue recognition: Datum zdanitelného plnění.
   */
  @JsonProperty("date_of_vat_revenue_recognition")
  private Date dateOfVatRevenueRecognition;
}