package za.ac.youthVend.factory;

import za.ac.youthVend.domain.Category;
import za.ac.youthVend.util.Helper;

public class CategoryFactory {
    public static Category createCategory(String name) {
        if (Helper.isNullOrEmpty(name)) {
            System.out.println("Invalid category name.");
            return null;
        }

        return new Category(name);
    }
}
