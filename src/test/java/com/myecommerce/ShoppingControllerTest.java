package com.myecommerce;

import com.myecommerce.shopping.Shopping;
import com.myecommerce.shopping.ShoppingController;
import com.myecommerce.shopping.ShoppingService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ShoppingControllerTest {

    @Mock
    private ShoppingService shoppingService;

    @InjectMocks
    private ShoppingController shoppingController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllShopping() throws Exception {
        List<Shopping> shoppingList = new ArrayList<>();
        Shopping shopping1 = new Shopping();
        shopping1.setId(1L);
        shopping1.setUsername("maria@example.com");
        shopping1.setIsVip("vip");
        shopping1.setTotalAmount(BigDecimal.valueOf(12885));
        shopping1.setLastPurchaseDate(LocalDate.now());

        Shopping shopping2 = new Shopping();
        shopping2.setId(2L);
        shopping2.setUsername("jose@example.com");
        shopping2.setIsVip("comun");
        shopping2.setTotalAmount(BigDecimal.valueOf(789.30));
        shopping2.setLastPurchaseDate(LocalDate.now());

        shoppingList.add(shopping1);
        shoppingList.add(shopping2);

        when(shoppingService.getAllShopping()).thenReturn(shoppingList);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/shopping"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    }
}
