package com.myecommerce.shopping;

import com.myecommerce.customer.Customer;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingRepository extends CrudRepository<Shopping, Long> {
}
