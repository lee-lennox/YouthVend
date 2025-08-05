package za.ac.youthVend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.youthVend.domain.Products;
import za.ac.youthVend.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    public Products createProduct(@RequestBody Products product) {
        return productService.save(product);
    }

    @GetMapping("/read/{id}")
    public Products readProduct(@PathVariable Long id) {
        return productService.read(id);
    }

    @PostMapping("/update")
    public Products updateProduct(@RequestBody Products product) {
        return productService.update(product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @GetMapping("/all")
    public List<Products> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/seller/{sellerId}")
    public List<Products> findBySellerId(@PathVariable Long sellerId) {
        return productService.findBySellerId(sellerId);
    }

    @GetMapping("/search")
    public List<Products> findByNameContainingIgnoreCase(@RequestParam String name) {
        return productService.findByNameContainingIgnoreCase(name);
    }
}
