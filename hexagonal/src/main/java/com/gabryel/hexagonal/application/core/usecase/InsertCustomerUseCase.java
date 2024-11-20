package com.gabryel.hexagonal.application.core.usecase;

import com.gabryel.hexagonal.application.core.domain.Customer;
import com.gabryel.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.gabryel.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.gabryel.hexagonal.application.ports.out.InsertCustomerOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddress;
    private final InsertCustomerOutputPort insertCustomerOutputPort;

    public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddress,
                                 InsertCustomerOutputPort insertCustomerOutputPort) {
        this.findAddress = findAddress;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
    }

    /**
     * Insert a customer into the database. The customer's address is resolved
     * from the given zip code.
     *
     * @param customer the customer to insert
     * @param zipCode the zip code to resolve the address from
     */
    @Override
    public void insert(Customer customer, String zipCode) {

        var address = findAddress.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);
    }

}
