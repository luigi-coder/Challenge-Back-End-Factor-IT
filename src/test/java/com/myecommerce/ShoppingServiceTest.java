package com.myecommerce;

import com.myecommerce.shopping.Shopping;
import com.myecommerce.shopping.ShoppingRepository;
import com.myecommerce.shopping.ShoppingService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ShoppingServiceTest {

    @InjectMocks
    private ShoppingService shoppingService;

    @Mock
    private ShoppingRepository shoppingRepository;

    @Test
    public void testGetAllShopping() {
        // Mocking the data
        List<Shopping> shoppingList = new ArrayList<>();

        Shopping mariaShopping = new Shopping();
        mariaShopping.setId(15L);
        mariaShopping.setUsername("maria@example.com");
        mariaShopping.setIsVip("vip");
        mariaShopping.setTotalAmount(BigDecimal.valueOf(12885));
        mariaShopping.setLastPurchaseDate(LocalDate.now()); // Set the last purchase date

        Shopping joseShopping = new Shopping();
        joseShopping.setId(16L);
        joseShopping.setUsername("jose@example.com");
        joseShopping.setIsVip("comun");
        joseShopping.setTotalAmount(BigDecimal.valueOf(789.30));
        joseShopping.setLastPurchaseDate(LocalDate.now()); // Set the last purchase date

        shoppingList.add(mariaShopping);
        shoppingList.add(joseShopping);

        when(shoppingRepository.findAll()).thenReturn(shoppingList);

        // Testing the service
        List<Shopping> shoppingListResult = shoppingService.getAllShopping();

        assertEquals(2, shoppingListResult.size());

        assertEquals("maria@example.com", shoppingListResult.get(0).getUsername());
        assertEquals("vip", shoppingListResult.get(0).getIsVip());
        assertEquals(BigDecimal.valueOf(12885), shoppingListResult.get(0).getTotalAmount());
        assertEquals(LocalDate.now(), shoppingListResult.get(0).getLastPurchaseDate());

        assertEquals("jose@example.com", shoppingListResult.get(1).getUsername());
        assertEquals("comun", shoppingListResult.get(1).getIsVip());
        assertEquals(BigDecimal.valueOf(789.30), shoppingListResult.get(1).getTotalAmount());
        assertEquals(LocalDate.now(), shoppingListResult.get(1).getLastPurchaseDate());
    }
}
