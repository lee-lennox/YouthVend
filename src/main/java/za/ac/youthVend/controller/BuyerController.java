package za.ac.youthVend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.youthVend.domain.Buyer;
import za.ac.youthVend.service.BuyerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/buyer")
public class BuyerController {

    private final BuyerService buyerService;

    @Autowired
    public BuyerController(BuyerService buyerService) {
        this.buyerService = buyerService;
    }

    // Create a new Buyer
    @PostMapping("/create")
    public Buyer createBuyer(@RequestBody Buyer buyer) {
        return buyerService.save(buyer);
    }

    // Read a Buyer by ID
    @GetMapping("/read/{id}")
    public Buyer readBuyer(@PathVariable Long id) {
        return buyerService.read(id);
    }

    // Find Buyer by Email
    @GetMapping("/findByEmail/{email}")
    public Optional<Buyer> findByEmail(@PathVariable String email) {
        return buyerService.findByEmail(email);
    }

    // Update Buyer
    @PostMapping("/update")
    public Buyer updateBuyer(@RequestBody Buyer buyer) {
        return buyerService.update(buyer);
    }

    // Delete Buyer by ID
    @DeleteMapping("/delete/{id}")
    public void deleteBuyer(@PathVariable Long id) {
        buyerService.deleteById(id);
    }

    // Get all Buyers
    @GetMapping("/all")
    public List<Buyer> getAllBuyers() {
        return buyerService.findAll();
    }
}
