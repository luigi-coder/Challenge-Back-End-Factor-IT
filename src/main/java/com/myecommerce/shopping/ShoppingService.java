package com.myecommerce.shopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingService {

    @Autowired
    private ShoppingRepository shoppingRepository;

    public void saveShopping(Shopping shopping) {
        System.out.println(shopping);
        shoppingRepository.save(shopping);
    }

    public List<Shopping> getAllShopping() {
        return (List<Shopping>) shoppingRepository.findAll();
    }

}
