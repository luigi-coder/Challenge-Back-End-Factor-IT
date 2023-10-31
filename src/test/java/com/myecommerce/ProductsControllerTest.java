package com.myecommerce;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myecommerce.products.Products;
import com.myecommerce.products.ProductsController;
import com.myecommerce.products.ProductsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ProductsService productsService;

    @InjectMocks
    private ProductsController productsController;

    private List<Products> productList;

    @BeforeEach
    public void setup() {
        // Assign mocked productsService to controller
        productsController = new ProductsController(productsService);

        // Mocking data
        Products product1 = new Products();
        product1.setId(1L);
        product1.setName("Bombone Ferrero Rocher");
        product1.setPrice(BigDecimal.valueOf(3985.85));

        Products product2 = new Products();
        product2.setId(2L);
        product2.setName("Surtido Arcor");
        product2.setPrice(BigDecimal.valueOf(1811.45));

        Products product3 = new Products();
        product3.setId(3L);
        product3.setName("Alfajores Milka");
        product3.setPrice(BigDecimal.valueOf(1537.78));

        Products product4 = new Products();
        product4.setId(4L);
        product4.setName("Chocolate Cofler Blockazo");
        product4.setPrice(BigDecimal.valueOf(6038.60));


        Products product7 = new Products();
        product7.setId(7L);
        product7.setName("Bon o Bon");
        product7.setPrice(BigDecimal.valueOf(3450.50));

        Products product8 = new Products();
        product8.setId(8L);
        product8.setName("Turron de Almendra Bariloche");
        product8.setPrice(BigDecimal.valueOf(5000.00));

        Products product9 = new Products();
        product9.setId(9L);
        product9.setName("Surtido Arcor Seleccion");
        product9.setPrice(BigDecimal.valueOf(2293.20));

        Products product10 = new Products();
        product10.setId(10L);
        product10.setName("Alfajores chocoarroz");
        product10.setPrice(BigDecimal.valueOf(400.50));

        Products product11 = new Products();
        product11.setId(11L);
        product11.setName("Caramelo Duro Pico Dulce");
        product11.setPrice(BigDecimal.valueOf(789.30));

        Products product13 = new Products();
        product13.setId(13L);
        product13.setName("Pastillas Tic Tac");
        product13.setPrice(BigDecimal.valueOf(780.40));

        Products product14 = new Products();
        product14.setId(14L);
        product14.setName("Caramelos masticables Pico Dulce");
        product14.setPrice(BigDecimal.valueOf(1866.25));

        productList = Arrays.asList(product1, product2); // Inicialización de productList

        // Mocking behavior of productsService in controller
        when(productsService.listAllProducts()).thenReturn(productList);
    }

    @Test
    public void testListAllProducts() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(content().json("["
                        + "{'id': 1, 'name': 'Bombone Ferrero Rocher', 'price': 3985.85},"
                        + "{'id': 2, 'name': 'Surtido Arcor', 'price': 1811.45},"
                        + "{'id': 3, 'name': 'Alfajores Milka', 'price': 1537.78},"
                        + "{'id': 4, 'name': 'Chocolate Cofler Blockazo', 'price': 6038.60},"
                        + "{'id': 7, 'name': 'Bon o Bon', 'price': 3450.50},"
                        + "{'id': 8, 'name': 'Turron de Almendra Bariloche', 'price': 5000.00},"
                        + "{'id': 9, 'name': 'Surtido Arcor Seleccion', 'price': 2293.20},"
                        + "{'id': 10, 'name': 'Alfajores chocoarroz', 'price': 400.50},"
                        + "{'id': 11, 'name': 'Caramelo Duro Pico Dulce', 'price': 789.30},"
                        + "{'id': 13, 'name': 'Pastillas Tic Tac', 'price': 780.40},"
                        + "{'id': 14, 'name': 'Caramelos masticables Pico Dulce', 'price': 1866.25}"
                        + "]"));
    }
}
