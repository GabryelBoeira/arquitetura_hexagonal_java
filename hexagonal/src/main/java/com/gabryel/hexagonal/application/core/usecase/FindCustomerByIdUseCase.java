package com.gabryel.hexagonal.application.core.usecase;

import com.gabryel.hexagonal.application.core.domain.Customer;
import com.gabryel.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.gabryel.hexagonal.application.ports.out.FindCustomerByIdOutputPort;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {

    private final FindCustomerByIdOutputPort findCustomerByIdInputPort;

    public FindCustomerByIdUseCase(FindCustomerByIdOutputPort findCustomerByIdInputPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
    }

    @Override
    public Customer find(String id) {
        return findCustomerByIdInputPort.find(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

}
