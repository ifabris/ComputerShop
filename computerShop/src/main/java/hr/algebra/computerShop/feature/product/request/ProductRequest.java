package hr.algebra.computerShop.feature.product.request;


import hr.algebra.computerShop.feature.category.Category;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequest {
  private String name;
  private String description;
  private BigDecimal price;
  private Category category;
}
