package com.gabryel.hexagonal.adapter.in.controller;

import com.gabryel.hexagonal.adapter.in.controller.mapper.CustomerMapper;
import com.gabryel.hexagonal.adapter.in.controller.request.CustomerRequest;
import com.gabryel.hexagonal.application.ports.in.InsertCustomerInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final InsertCustomerInputPort insertCustomerInputPort;
    private final CustomerMapper customerMapper;


    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody CustomerRequest customerRequest) {

        var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.zipCode());

        return ResponseEntity.ok().build();
    }

}
