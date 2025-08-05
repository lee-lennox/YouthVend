package za.ac.youthVend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.youthVend.domain.Products;
import za.ac.youthVend.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Products save(Products product) {
        return repository.save(product);
    }



    @Override
    public List<Products> findAll() {
        return List.of();
    }

    @Override
    public Products update(Products product) {
        return repository.save(product);
    }

    @Override
    public Products read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Products> findBySellerId(Long sellerId) {
        return repository.findBySeller_UserId(sellerId);
    }
    @Override
    public List<Products> findByNameContainingIgnoreCase(String sellerName) {
        return repository.findByNameContainingIgnoreCase(sellerName);
    }

}
