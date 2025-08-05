package za.ac.youthVend.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.youthVend.domain.Category;
import za.ac.youthVend.factory.CategoryFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CategoryControllerTest {

    @Autowired
    private CategoryController categoryController;

    private static Category category = CategoryFactory.createCategory("Clothing");
    private static Long savedCategoryId;

    @Test
    @Order(1)
    void createCategory() {
        Category created = categoryController.createCategory(category);
        assertNotNull(created);
        assertEquals("Clothing", created.getName());
        savedCategoryId = created.getCategoryId(); // Make sure getCategoryId() exists
        System.out.println("Created Category: " + created);
    }

    @Test
    @Order(2)
    void readCategory() {
        Category found = categoryController.readCategory(savedCategoryId);
        assertNotNull(found);
        assertEquals(category.getName(), found.getName());
        System.out.println("Read Category: " + found);
    }

    @Test
    @Order(3)
    void findByName() {
        Optional<Category> found = categoryController.findByName(category.getName());
        assertTrue(found.isPresent());
        assertEquals("Clothing", found.get().getName());
        System.out.println("Found Category by name: " + found.get());
    }

    @Test
    @Order(4)
    void updateCategory() {
        Category updatedCategory = new Category.Builder()
                .copy(category)
                .setCategoryId(savedCategoryId)
                .setName("Accessories")
                .build();

        Category updated = categoryController.updateCategory(updatedCategory);
        assertNotNull(updated);
        assertEquals("Accessories", updated.getName());
        System.out.println("Updated Category: " + updated);
    }

    @Test
    @Order(5)
    void deleteCategory() {
        categoryController.deleteCategory(savedCategoryId);
        Category deleted = categoryController.readCategory(savedCategoryId);
        assertNull(deleted);
        System.out.println("Deleted Category with ID: " + savedCategoryId);
    }
}
