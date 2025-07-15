package za.ac.youthVend.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.youthVend.domain.Buyer;
import za.ac.youthVend.domain.Category;
import za.ac.youthVend.factory.BuyerFactory;
import za.ac.youthVend.factory.CategoryFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class CategoryServiceTest {
    @Autowired
    private CategoryService categoryService;
    private static Category savedCategory;

    @Test
    @Order(1)
    void a_create() {
        Category category = CategoryFactory.createCategory("Seja");
        savedCategory = categoryService.save(category);
        assertNotNull(savedCategory);
        assertNotNull(savedCategory.getCategoryId());
        System.out.println(" Created: " + savedCategory);
    }

    @Test
    @Order(2)
    void b_read() {
        assertNotNull(savedCategory);
        Category read = categoryService.read(savedCategory.getCategoryId());
        assertNotNull(read);
        assertEquals(savedCategory.getCategoryId(), read.getCategoryId());
        System.out.println(" Read: " + read);
    }

    @Test
    @Order(3)
    void c_update() {
        Category updated = new Category.Builder()
                .copy(savedCategory)
                .setName("Updated Seja")
                .build();

        Category result = categoryService.update(updated);
        assertNotNull(result);
        assertEquals("Updated Seja", result.getName());
        System.out.println(" Updated: " + result);
    }

    @Test
    @Order(4)
    void d_findByName() {
        Optional<Category> found = categoryService.findByName("Updated Seja");
        assertTrue(found.isPresent());
        System.out.println(" Found by name: " + found.get());
    }

    @Test
    @Order(5)
    void e_delete() {
        assertNotNull(savedCategory);
        categoryService.deleteById(savedCategory.getCategoryId());

        Category deleted = categoryService.read(savedCategory.getCategoryId());
        assertNull(deleted);
        System.out.println(" Deleted category with ID: " + savedCategory.getCategoryId());
    }

}