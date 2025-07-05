package za.ac.youthVend.service;

import za.ac.youthVend.domain.Buyer;

import java.util.Optional;

public interface IBuyerService extends IService<Buyer, Long> {
    Optional<Buyer> findByEmail(String email);
}
