package com.myecommerce.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {

    @Autowired private ProductsRepository productsRepository;

    public Iterable<Products> listAllProducts() {
        return productsRepository.findAll();
    }
}
