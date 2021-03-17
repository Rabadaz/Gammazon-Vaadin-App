package at.scheuchi.Gammazon.Repository;

import at.scheuchi.Gammazon.Model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
}
