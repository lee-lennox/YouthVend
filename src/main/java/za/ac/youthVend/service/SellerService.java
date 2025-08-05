package za.ac.youthVend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.youthVend.domain.Seller;
import za.ac.youthVend.repository.SellerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SellerService implements ISellerService {
    private final SellerRepository repository;

    @Autowired
    public SellerService(SellerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Seller save(Seller seller) {
        return repository.save(seller);
    }



    @Override
    public List<Seller> findAll() {
        return List.of();
    }

    @Override
    public Seller update(Seller seller) {
        return repository.save(seller);
    }

    @Override
    public Seller read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Seller> findByBusinessName(String businessName) {
        return repository.findByBusinessName(businessName);
    }
}
