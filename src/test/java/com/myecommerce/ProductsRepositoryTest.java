package com.myecommerce;

import com.myecommerce.products.Products;
import com.myecommerce.products.ProductsRepository;
import com.myecommerce.products.ProductsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProductsRepositoryTest {

    @Mock
    private ProductsRepository productsRepository;

    @InjectMocks
    private ProductsService productsService;

    @Test
    public void testListAllProducts() {
        // Mocking data
        Products product1 = new Products();
        product1.setId(1L);
        product1.setName("Product 1");
        product1.setPrice(BigDecimal.TEN);

        Products product2 = new Products();
        product2.setId(2L);
        product2.setName("Product 2");
        product2.setPrice(BigDecimal.ONE);

        // Mocking behavior
        when(productsRepository.findAll()).thenReturn(Arrays.asList(product1, product2));

        // Testing the service method
        Iterable<Products> products = productsService.listAllProducts();

        // Assertions
        assertEquals(2, ((List<Products>) products).size());
        //assert products != null;
    }
}
