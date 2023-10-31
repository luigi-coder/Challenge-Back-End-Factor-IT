package com.myecommerce.shopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@RestController
@RequestMapping("/api/shopping")
public class ShoppingController {

    @Autowired
    private ShoppingService shoppingService;

    @Operation(summary = "Get all shopping items")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of all shopping items",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Shopping.class))
            ),
            @ApiResponse(responseCode = "404", description = "No shopping items found")
    })
    @GetMapping
    public ResponseEntity<List<Shopping>> getAllShopping() {
        List<Shopping> shoppingList = shoppingService.getAllShopping();
        return ResponseEntity.ok(shoppingList);
    }

    @Operation(summary = "Add a shopping item")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Shopping item added successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid shopping item")
    })
    @PostMapping("/add")
    public ResponseEntity<String> addShopping(@RequestBody Shopping shopping) {
        shoppingService.saveShopping(shopping);
        return ResponseEntity.ok("Shopping added successfully.");
    }
}
