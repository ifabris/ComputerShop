package hr.algebra.computerShop.feature.invoice.response;

import hr.algebra.computerShop.feature.user.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InvoiceDetails {
    private Integer id;
    private User user;
    private LocalDateTime date;
}
