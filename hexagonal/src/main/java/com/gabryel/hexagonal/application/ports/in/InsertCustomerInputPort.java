package com.gabryel.hexagonal.application.ports.in;

import com.gabryel.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    /**
     * Inserts a customer into the database. The customer's address is resolved
     * from the given zip code.
     *
     * @param customer the customer to insert
     * @param zipCode the zip code to resolve the address from
     */
    void insert(Customer customer, String zipCode);

}
