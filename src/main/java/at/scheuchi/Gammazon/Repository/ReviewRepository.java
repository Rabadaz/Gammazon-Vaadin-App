package at.scheuchi.Gammazon.Repository;

import at.scheuchi.Gammazon.Model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
