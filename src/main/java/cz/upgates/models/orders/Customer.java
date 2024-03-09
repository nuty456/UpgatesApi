package cz.upgates.models.orders;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Represents a Customer: Zákazník.
 */
@Data
public class Customer {
  /**
   * Customer's email: Email zákazníka.
   */
  @JsonProperty("email")
  private String email;

  /**
   * Customer's phone: Telefon.
   */
  @JsonProperty("phone")
  private String phone;

  /**
   * Customer's code: Zákaznické číslo.
   */
  @JsonProperty("code")
  private String code;

  /**
   * Customer's ID: ID zákazníka.
   */
  @JsonProperty("customer_id")
  private Integer customerId;

  /**
   * Customer's pricelist ID: ID ceníku zákazníka ve kterém zákazník napoupil.
   */
  @JsonProperty("customer_pricelist_id")
  private Integer customerPricelistId;

  /**
   * Pricelist name: Název ceníku.
   */
  @JsonProperty("pricelist_name")
  private String pricelistName;

  /**
   * Pricelist percent: Procento slevy ceníku.
   */
  @JsonProperty("pricelist_percent")
  private Float pricelistPercent;

  /**
   * Agreements: Pole objektů se souhlasy.
   */
  @JsonProperty("agreements")
  private List<Agreement> agreements;

  /**
   * Billing firstname: Fakturační jméno.
   */
  @JsonProperty("firstname_invoice")
  private String firstnameInvoice;

  /**
   * Billing surname: Fakturační příjmení.
   */
  @JsonProperty("surname_invoice")
  private String surnameInvoice;

  /**
   * Delivery flag: Příznak doručovací adresy.
   */
  @JsonProperty("postal_yn")
  private Boolean postalYN;

  /**
   * Delivery firstname: Doručovací jméno.
   */
  @JsonProperty("firstname_postal")
  private String firstnamePostal;

  /**
   * Company flag: Příznak, jestli je zákazník firma.
   */
  @JsonProperty("company_yn")
  private Boolean companyYN;

  /**
   * Company name: Název firmy.
   */
  @JsonProperty("company")
  private String company;

  /**
   * VAT Payer: Příznak, jestli je firma plátce DPH.
   */
  @JsonProperty("vat_payer_yn")
  private Boolean vatPayerYN;

  /**
   * Customer note: Poznámka zákazníka.
   */
  @JsonProperty("customer_note")
  private String customerNote;

  /**
   * Invoice street: Fakturační ulice a číslo.
   */
  @JsonProperty("street_invoice")
  private String streetInvoice;

  /**
   * Invoice city: Fakturační město.
   */
  @JsonProperty("city_invoice")
  private String cityInvoice;

  /**
   * Invoice state: Fakturační okres.
   */
  @JsonProperty("state_invoice")
  private String stateInvoice;

  /**
   * Invoice zip: Fakturační PSČ.
   */
  @JsonProperty("zip_invoice")
  private String zipInvoice;

  /**
   * Invoice country id: Fakturační země.
   */
  @JsonProperty("country_id_invoice")
  private String countryIdInvoice;

  /**
   * Postal surname: Doručovací přijmení.
   */
  @JsonProperty("surname_postal")
  private String surnamePostal;

  /**
   * Postal street: Doručovací ulice a číslo.
   */
  @JsonProperty("street_postal")
  private String streetPostal;

  /**
   * Postal city: Doručovací město.
   */
  @JsonProperty("city_postal")
  private String cityPostal;

  /**
   * Postal state: Doručovací okres.
   */
  @JsonProperty("state_postal")
  private String statePostal;

  /**
   * Postal zip: Doručovací PSČ.
   */
  @JsonProperty("zip_postal")
  private String zipPostal;

  /**
   * Postal country id: Doručovací země.
   */
  @JsonProperty("country_id_postal")
  private String countryIdPostal;

  /**
   * Postal company: Doručovací název firmy.
   */
  @JsonProperty("company_postal")
  private String companyPostal;

  /**
   * Business Identification Number: IČO.
   */
  @JsonProperty("ico")
  private String ico;

  /**
   * Tax Identification Number: DIČ.
   */
  @JsonProperty("dic")
  private String dic;

  /**
   * příznak doručovací adresy.
   */
  @JsonProperty("postal_yn")
  private Boolean postalYn;

  /**
   * příznak jestli je zákazník firma.
   */
  @JsonProperty("company_yn")
  private Boolean companyYn;

  /**
   * příznak jestli je firma plátce DPH.
   */
  @JsonProperty("vat_payer_yn")
  private Boolean vatPayerYn;

}