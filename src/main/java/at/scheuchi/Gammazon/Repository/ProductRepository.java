package at.scheuchi.Gammazon.Repository;

import at.scheuchi.Gammazon.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
