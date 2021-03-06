package course.springdata.jsonprocessingex2.repositories;

import course.springdata.jsonprocessingex2.models.entities.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends JpaRepository<Part, Long> {
    Part getById(Long id);
}
