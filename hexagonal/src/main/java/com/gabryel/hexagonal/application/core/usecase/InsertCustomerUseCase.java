package com.gabryel.hexagonal.application.core.usecase;

import com.gabryel.hexagonal.application.core.domain.Customer;
import com.gabryel.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.gabryel.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.gabryel.hexagonal.application.ports.out.InsertCustomerOutputPort;
import com.gabryel.hexagonal.application.ports.out.kafka.SendCpfForValidationOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddress;
    private final InsertCustomerOutputPort insertCustomerOutputPort;
    private final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;

    public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddress,
                                 InsertCustomerOutputPort insertCustomerOutputPort,
                                 SendCpfForValidationOutputPort sendCpfForValidationOutputPort) {
        this.findAddress = findAddress;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;
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
        sendCpfForValidationOutputPort.send(customer.getCpf());
    }

}
