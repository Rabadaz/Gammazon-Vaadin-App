package at.scheuchi.Gammazon.Repository;

import at.scheuchi.Gammazon.Model.Customer;
import at.scheuchi.Gammazon.Model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface SaleRepository extends JpaRepository<Sale, Integer> {
    @Query("SELECT s from Sale s where s.customer = :customer")
    public Collection<Sale> getSalesByCustomer(Customer customer);
}
