package at.scheuchi.Gammazon.Repository;

import at.scheuchi.Gammazon.Model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {
}
