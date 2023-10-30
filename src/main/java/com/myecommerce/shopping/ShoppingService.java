package com.myecommerce.shopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingService {

    @Autowired
    private ShoppingRepository shoppingRepository;

    public void saveShopping(Shopping shopping) {
        shoppingRepository.save(shopping);
    }

}
