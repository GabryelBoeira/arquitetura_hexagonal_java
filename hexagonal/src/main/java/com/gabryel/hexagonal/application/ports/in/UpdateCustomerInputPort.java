package com.gabryel.hexagonal.application.ports.in;

import com.gabryel.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {

    /**
     * Updates a customer's information in the system. The customer's address
     * is updated based on the provided zip code.
     *
     * @param customer the customer whose information is to be updated
     * @param zipCode the zip code used to determine the new address
     */
    void update(Customer customer, String zipCode);

}
