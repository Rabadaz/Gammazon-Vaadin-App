package at.scheuchi.Gammazon.Repository;

import at.scheuchi.Gammazon.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
