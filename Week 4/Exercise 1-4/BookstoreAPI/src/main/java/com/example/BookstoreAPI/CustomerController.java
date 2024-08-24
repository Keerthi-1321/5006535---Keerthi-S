package com.example.BookstoreAPI;

import com.example.BookstoreAPI.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private List<Customer> customers = new ArrayList<>();

    // 1. Create a new customer by accepting a JSON request body
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return customer;
    }

    // 2. Process form data for customer registrations
    @PostMapping("/register")
    public Customer registerCustomer(@RequestParam int id,
                                     @RequestParam String name,
                                     @RequestParam String email,
                                     @RequestParam String address,
                                     @RequestParam String phoneNumber) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setEmail(email);
        customer.setAddress(address);
        customer.setPhoneNumber(phoneNumber);
        customers.add(customer);
        return customer;
    }

    // Fetch all customers (for testing purposes)
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customers;
    }
}

