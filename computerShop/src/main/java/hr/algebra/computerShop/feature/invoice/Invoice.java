package hr.algebra.computerShop.feature.invoice;


import hr.algebra.computerShop.feature.user.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "invoice_userid")
    private User user;

    @Column(name = "invoice_date", nullable = false)
    private LocalDateTime date;
}
