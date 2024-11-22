package com.gabryel.hexagonal.application.ports.in;

public interface DeleteCustomerByIdInputPort {

    /**
     * Deletes a customer by their ID.
     *
     * @param id the customer ID
     */
    void delete(String id);
}
