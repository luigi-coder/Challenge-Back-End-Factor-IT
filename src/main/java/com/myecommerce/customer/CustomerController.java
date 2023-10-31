package com.myecommerce.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;


@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired private CustomerService customerService;

    @GetMapping
    @Operation(summary = "Get all customers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of all customers",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Customer.class))
            ),
            @ApiResponse(responseCode = "404", description = "No customers found")
    })
    public Iterable<Customer> listAllCustomer() {

        return customerService.listAllCustomer();
    }
}
