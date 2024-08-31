package hr.algebra.computerShop.feature.product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProducts();

    Optional<Product> getProductById(int id);

    Product saveOrUpdateProduct(Product product);

    void deleteProduct(int id);
}
