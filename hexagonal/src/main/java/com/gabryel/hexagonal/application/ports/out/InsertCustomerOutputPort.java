package com.gabryel.hexagonal.application.ports.out;

import com.gabryel.hexagonal.application.core.domain.Customer;

public interface InsertCustomerOutputPort {

    void insert(Customer customer);

}
