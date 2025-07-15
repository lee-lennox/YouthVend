package za.ac.youthVend.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Products> products;

    protected Category() {}

    private Category(Builder builder) {
        this.categoryId = builder.categoryId;
        this.name = builder.name;
        this.products = builder.products;
    }

    public Category(String name) {
        this.name = name;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public List<Products> getProducts() {
        return products == null ? List.of() : products;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                '}';
    }

    public static class Builder {
        private String name;
        private List<Products> products;
        private Long categoryId;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setCategoryId(Long categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public Builder setProducts(List<Products> products) {
            this.products = products;
            return this;
        }

        public Builder copy(Category category) {
            this.name = category.getName();
            this.products = category.getProducts();
            this.categoryId = category.getCategoryId();
            return this;
        }

        public Category build() {
            return new Category(this);
        }
    }
}
