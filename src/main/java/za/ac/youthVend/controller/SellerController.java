package za.ac.youthVend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.youthVend.domain.Seller;
import za.ac.youthVend.service.SellerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/seller")
public class SellerController {

    private final SellerService sellerService;

    @Autowired
    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    // Create a new Seller
    @PostMapping("/create")
    public Seller createSeller(@RequestBody Seller seller) {
        return sellerService.save(seller);
    }

    // Read a Seller by ID
    @GetMapping("/read/{id}")
    public Seller readSeller(@PathVariable Long id) {
        return sellerService.read(id);
    }

    // Read a Seller by businessName (optional)
    @GetMapping("/findByName/{businessName}")
    public Optional<Seller> findByBusinessName(@PathVariable String businessName) {
        return sellerService.findByBusinessName(businessName);
    }

    // Update an existing Seller
    @PostMapping("/update")
    public Seller updateSeller(@RequestBody Seller seller) {
        return sellerService.update(seller);
    }

    // Delete a Seller by ID
    @DeleteMapping("/delete/{id}")
    public void deleteSeller(@PathVariable Long id) {
        sellerService.deleteById(id);
    }

    // Get all sellers
    @GetMapping("/all")
    public List<Seller> getAllSellers() {
        return sellerService.findAll();
    }
}
