package com.gabryel.hexagonal.application.ports.in;

import com.gabryel.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    /**
     * Finds a customer by their ID.
     *
     * @param id the customer ID
     * @return the customer or null if not found
     */
    Customer find(String id);
}
