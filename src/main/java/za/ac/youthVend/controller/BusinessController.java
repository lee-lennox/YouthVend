package za.ac.youthVend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.youthVend.domain.Business;
import za.ac.youthVend.service.BusinessService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/business")
public class BusinessController {

    private final BusinessService businessService;

    @Autowired
    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    // Create a new Business
    @PostMapping("/create")
    public Business createBusiness(@RequestBody Business business) {
        return businessService.save(business);
    }

    // Read a Business by ID
    @GetMapping("/read/{id}")
    public Business readBusiness(@PathVariable Long id) {
        return businessService.read(id);
    }

    // Read a Business by businessName (optional)
    @GetMapping("/findByName/{businessName}")
    public Optional<Business> findByBusinessName(@PathVariable String businessName) {
        return businessService.findByBusinessName(businessName);
    }

    // Update an existing Business
    @PostMapping("/update")
    public Business updateBusiness(@RequestBody Business business) {
        return businessService.update(business);
    }

    // Delete a Business by ID
    @DeleteMapping("/delete/{id}")
    public void deleteBusiness(@PathVariable Long id) {
        businessService.deleteById(id);
    }

    // Get all businesses
    @GetMapping("/all")
    public List<Business> getAllBusinesses() {
        return businessService.findAll();
    }
}
