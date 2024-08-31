package hr.algebra.computerShop.feature.invoice.request;


import hr.algebra.computerShop.feature.user.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InvoiceRequest {
  private User user;
  private LocalDateTime date;
}
