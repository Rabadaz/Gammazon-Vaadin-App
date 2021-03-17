package at.scheuchi.Gammazon.Repository;

import at.scheuchi.Gammazon.Model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Integer> {
}
