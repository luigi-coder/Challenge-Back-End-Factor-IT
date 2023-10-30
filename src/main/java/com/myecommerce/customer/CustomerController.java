package com.myecommerce.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired private CustomerService customerService;

    @GetMapping
    public Iterable<Customer> listAllCustomer() {
        return customerService.listAllCustomer();
    }
}
