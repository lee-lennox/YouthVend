package za.ac.youthVend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.youthVend.domain.Buyer;

import java.util.Optional;

@Repository
    public interface BuyerRepository extends JpaRepository<Buyer, Long> {
        ;
    Optional<Buyer> findByEmail(String email);

}

