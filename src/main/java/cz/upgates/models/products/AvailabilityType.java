package cz.upgates.models.products;

import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Represents the availability status of a product or variant.
 */
@XmlRootElement
public enum AvailabilityType {
  OnRequest,
  NotAvailable,
  InStock,
  Custom
}