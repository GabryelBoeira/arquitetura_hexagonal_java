package com.gabryel.hexagonal.adapter.out;

import com.gabryel.hexagonal.adapter.out.repository.CustomerRepository;
import com.gabryel.hexagonal.adapter.out.repository.mapper.CustomerEntityMapper;
import com.gabryel.hexagonal.application.core.domain.Customer;
import com.gabryel.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> find(String id) {

        return customerRepository.findById(id).map(customerEntityMapper::toDomain);
    }
}
