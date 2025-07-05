package za.ac.youthVend.service;

import za.ac.youthVend.domain.Seller;

import java.util.Optional;

public interface ISellerService extends IService<Seller, Long> {
    Optional<Seller> findByBusinessName(String businessName);
}
