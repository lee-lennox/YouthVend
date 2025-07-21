package za.ac.youthVend.service;

import za.ac.youthVend.domain.Business;

import java.util.Optional;

public interface IBusinessService extends IService<Business,Long> {

    Optional<Business> findById(Long aLong);
    Optional<Business> findByBusinessName(String businessName);

}
