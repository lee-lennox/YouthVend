package za.ac.youthVend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.youthVend.domain.Business;

import java.util.Optional;

public interface BusinessRepository extends JpaRepository<Business,Long> {

    Optional<Business> findById(Long aLong);
    Optional<Business> findByBusinessName(String businessName);


}
