package hr.algebra.computerShop.scheduler;

import hr.algebra.computerShop.feature.product.Product;
import hr.algebra.computerShop.feature.product.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GlobalScheduler {
  private final ProductRepo productRepo;

  @Scheduled(fixedRate = 30000) // 30 seconds = 30,000 milliseconds
  public void showCustomerTripCount() {
    List<Product> products = productRepo.findAll();

    products.forEach(
            product ->
                    System.out.println(
                            product.getProductName() + " has a price of " + product.getPrice() + " euros."));
  }
}
