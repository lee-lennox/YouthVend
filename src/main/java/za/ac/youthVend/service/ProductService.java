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
    public void deleteById(Long aLong) {

    }

    @Override
    public Products read(Long aLong) {
        return null;
    }


    @Override
    public List<Products> findByNameContainingIgnoreCase(String sellerName) {
        return repository.findByNameContainingIgnoreCase(sellerName);
    }

    @Override
    public List<Products> findBySellerId(Long sellerId) {
        return List.of();
    }


}
