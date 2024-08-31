package hr.algebra.computerShop.feature.product.response;

import hr.algebra.computerShop.feature.category.Category;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDetails {
    private Integer id;
    private String productName;
    private String description;
    private BigDecimal price;
    private Category category;
}
