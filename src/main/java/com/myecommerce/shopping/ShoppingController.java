package com.myecommerce.shopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ShoppingController {

    @Autowired
    private ShoppingService shoppingService;

    @PostMapping("/api/shopping/add")
    public void addShopping(@RequestBody Shopping shopping) {
        shoppingService.saveShopping(shopping);
    }
}
