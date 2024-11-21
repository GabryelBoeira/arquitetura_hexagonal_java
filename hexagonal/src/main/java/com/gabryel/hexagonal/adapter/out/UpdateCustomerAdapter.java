package com.gabryel.hexagonal.adapter.out;

import com.gabryel.hexagonal.adapter.out.repository.CustomerRepository;
import com.gabryel.hexagonal.adapter.out.repository.mapper.CustomerEntityMapper;
import com.gabryel.hexagonal.application.core.domain.Customer;
import com.gabryel.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    /**
     * Updates a customer in the database.
     *
     * @param customer the customer to update
     */
    @Override
    public void update(Customer customer) {
        customerRepository.save(customerEntityMapper.toEntity(customer));
    }

}
