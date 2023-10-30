package com.myecommerce.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired private CustomerRepository customerRepository;

    public Iterable<Customer> listAllCustomer() {
        return customerRepository.findAll();
    }
}
