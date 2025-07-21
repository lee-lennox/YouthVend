package za.ac.youthVend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.youthVend.domain.Business;
import za.ac.youthVend.repository.BusinessRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BusinessService implements IBusinessService {

    private final BusinessRepository businessRepository;

    @Autowired
    public BusinessService(BusinessRepository businessRepository) {
        this.businessRepository = businessRepository;
    }

    @Override
    public Optional<Business> findById(Long aLong) {
        return businessRepository.findById(aLong);
    }

    @Override
    public Optional<Business> findByBusinessName(String businessName) {
        return businessRepository.findByBusinessName(businessName);
    }


    @Override
    public Business save(Business entity) {
        return businessRepository.save(entity);
    }

    @Override
    public Business update(Business entity) {
        return businessRepository.save(entity);
    }
    public Business read(Long id) {
        return businessRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        businessRepository.deleteById(id);
    }

    public List<Business> findAll() {
        return businessRepository.findAll();
    }
}
