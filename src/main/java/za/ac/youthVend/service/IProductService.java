package za.ac.youthVend.service;

import za.ac.youthVend.domain.Products;

import java.util.List;

public interface IProductService extends IService<Products, Long> {
    List<Products> findByNameContainingIgnoreCase(String name);
    List<Products> findBySellerId(Long sellerId);
}
