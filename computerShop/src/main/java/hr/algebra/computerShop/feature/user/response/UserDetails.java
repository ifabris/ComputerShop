package hr.algebra.computerShop.feature.user.response;

import hr.algebra.computerShop.feature.category.Category;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserDetails {
    private Integer id;
    private String username;
    private String email;
}
