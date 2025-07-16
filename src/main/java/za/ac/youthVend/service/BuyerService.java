package za.ac.youthVend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.youthVend.domain.Buyer;
import za.ac.youthVend.repository.BuyerRepository;

import java.util.List;
import java.util.Optional;
@Service
public class BuyerService implements IBuyerService {

    private final BuyerRepository repository;

    @Autowired
    public BuyerService(BuyerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Buyer save(Buyer buyer) {
        return repository.save(buyer);
    }

    @Override
    public List<Buyer> findAll() {
        return repository.findAll();
    }

    @Override
    public Buyer update(Buyer buyer) {
        return repository.save(buyer);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Buyer read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Optional<Buyer> findByEmail(String email) {
        return repository.findByEmail(email);
    }
}