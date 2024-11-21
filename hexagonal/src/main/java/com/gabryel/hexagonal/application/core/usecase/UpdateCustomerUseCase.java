package com.gabryel.hexagonal.application.core.usecase;

import com.gabryel.hexagonal.application.core.domain.Customer;
import com.gabryel.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.gabryel.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.gabryel.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.gabryel.hexagonal.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

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

    public void update(Customer customer, String zipCode) {

        findCustomerByIdInputPort.find(customer.getId());
        var address = findAddress.find(zipCode);

        customer.setAddress(address);
        updateCustomerOutputPort.update(customer);
    }
}
