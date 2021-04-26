package exams.gira.repository;

import exams.gira.model.entity.Classification;
import exams.gira.model.entity.ClassificationName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassificationRepository extends JpaRepository<Classification, String> {
    Optional<Classification> findByClassificationName(ClassificationName classificationName);
}
