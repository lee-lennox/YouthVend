package za.ac.youthVend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.youthVend.domain.Category;
import za.ac.youthVend.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    private final CategoryRepository repository;

    @Autowired
    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Category save(Category category) {
        return repository.save(category);
    }


    @Override
    public List<Category> findAll() {
        return List.of();
    }

    @Override
    public Category update(Category category) {
        return repository.save(category);
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Category read(Long aLong) {
        return null;
    }

    @Override
    public Optional<Category> findByName(String name) {
        return repository.findByName(name);
    }
}