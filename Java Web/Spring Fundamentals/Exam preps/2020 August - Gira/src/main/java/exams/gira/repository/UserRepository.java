package exams.gira.repository;

import exams.gira.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String > {
    Optional<User> findByEmailAndPassword(String email, String password);
}
