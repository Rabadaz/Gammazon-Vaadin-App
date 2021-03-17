package at.scheuchi.Gammazon.Repository;

import at.scheuchi.Gammazon.Model.ProductSale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSaleRepository extends JpaRepository<ProductSale, Integer> {
}
