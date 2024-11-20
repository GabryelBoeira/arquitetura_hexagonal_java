package com.gabryel.hexagonal.adapter.out;

import com.gabryel.hexagonal.adapter.out.repository.CustomerRepository;
import com.gabryel.hexagonal.adapter.out.repository.mapper.CustomerEntityMapper;
import com.gabryel.hexagonal.application.core.domain.Customer;
import com.gabryel.hexagonal.application.ports.out.InsertCustomerOutputPort;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutputPort {

    private final CustomerEntityMapper customerEntityMapper;
    private final CustomerRepository customerRepository;

    public InsertCustomerAdapter(CustomerEntityMapper customerEntityMapper, CustomerRepository customerRepository) {
        this.customerEntityMapper = customerEntityMapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public void insert(Customer customer) {
        customerRepository.save(customerEntityMapper.toEntity(customer));
    }
}
