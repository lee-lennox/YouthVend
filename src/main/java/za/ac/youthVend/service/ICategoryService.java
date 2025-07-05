package za.ac.youthVend.service;

import za.ac.youthVend.domain.Category;

import java.util.Optional;

public interface ICategoryService extends IService<Category, Long> {
    Optional<Category> findByName(String name);
}
