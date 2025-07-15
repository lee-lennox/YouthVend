package za.ac.youthVend.factory;

import org.junit.jupiter.api.Test;
import za.ac.youthVend.domain.Category;

import static org.junit.jupiter.api.Assertions.*;

class CatagoryFactoryTest {
    @Test
    void testCreateCategory() {
        Category category = CategoryFactory.createCategory("Clothing");

        assertNotNull(category);
        assertEquals("Clothing", category.getName());
    }
}