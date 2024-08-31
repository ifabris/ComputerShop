package hr.algebra.computerShop.feature.product;


import hr.algebra.computerShop.feature.category.Category;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_description")
    private String description;

    @Column(name = "product_price", nullable = false)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "product_categoryid")
    private Category category;

}