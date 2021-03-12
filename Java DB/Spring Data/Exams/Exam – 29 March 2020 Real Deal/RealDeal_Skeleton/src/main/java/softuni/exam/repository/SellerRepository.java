package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Integer> {
    Seller getByEmail(String email);
    Seller getById(Long id);
}
