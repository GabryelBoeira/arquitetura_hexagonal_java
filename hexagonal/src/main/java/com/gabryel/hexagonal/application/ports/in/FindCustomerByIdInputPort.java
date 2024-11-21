package com.gabryel.hexagonal.application.ports.in;

import com.gabryel.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    Customer find(String id);
}
