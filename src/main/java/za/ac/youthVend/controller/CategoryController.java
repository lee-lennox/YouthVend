package za.ac.youthVend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.youthVend.domain.Category;
import za.ac.youthVend.service.CategoryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/create")
    public Category createCategory(@RequestBody Category category) {
        return categoryService.save(category);
    }

    @GetMapping("/read/{id}")
    public Category readCategory(@PathVariable Long id) {
        return categoryService.read(id);
    }

    @GetMapping("/findByName/{name}")
    public Optional<Category> findByName(@PathVariable String name) {
        return categoryService.findByName(name);
    }

    @PostMapping("/update")
    public Category updateCategory(@RequestBody Category category) {
        return categoryService.update(category);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteById(id);
    }

    @GetMapping("/all")
    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }
}
