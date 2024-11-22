package com.gabryel.hexagonal.application.ports.out;

public interface DeleteCustomerByIdOutputPort {

    /**
     * Deletes a customer by their ID.
     *
     * @param id the customer ID
     */
    void delete(String id);

}
