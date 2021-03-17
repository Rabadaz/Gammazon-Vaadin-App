package at.scheuchi.Gammazon.Repository;

import at.scheuchi.Gammazon.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
