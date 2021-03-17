package at.scheuchi.Gammazon.Repository;

import at.scheuchi.Gammazon.Model.ProductColor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductColorRepository extends JpaRepository<ProductColor, Integer> {
}
