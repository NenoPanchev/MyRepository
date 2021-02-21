package springdataintroex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springdataintroex.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
