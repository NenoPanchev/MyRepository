package exam.shoppinglist.repository;

import exam.shoppinglist.model.entity.Category;
import exam.shoppinglist.model.entity.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
    Optional<Category> findByName(CategoryName name);
}
