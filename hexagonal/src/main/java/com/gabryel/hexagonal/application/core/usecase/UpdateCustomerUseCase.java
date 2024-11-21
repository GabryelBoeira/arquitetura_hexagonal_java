package com.gabryel.hexagonal.application.core.usecase;

import com.gabryel.hexagonal.application.core.domain.Customer;
import com.gabryel.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.gabryel.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.gabryel.hexagonal.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUseCase {

    private final FindAddressByZipCodeOutputPort findAddress;
    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final UpdateCustomerOutputPort updateCustomerOutputPort;

    public UpdateCustomerUseCase(FindAddressByZipCodeOutputPort findAddress,
                                 FindCustomerByIdUseCase findCustomerByIdInputPort,
                                 UpdateCustomerOutputPort updateCustomerOutputPort) {
        this.findAddress = findAddress;
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.updateCustomerOutputPort = updateCustomerOutputPort;
    }

    /**
     * Updates a customer in the database. The customer's address is resolved
     * from the given zip code.
     *
     * @param customer the customer to update
     * @param zipCode the zip code to resolve the address from
     */
    public void update(Customer customer, String zipCode) {

        findCustomerByIdInputPort.find(customer.getId());
        var address = findAddress.find(zipCode);

        customer.setAddress(address);
        updateCustomerOutputPort.update(customer);
    }
}
