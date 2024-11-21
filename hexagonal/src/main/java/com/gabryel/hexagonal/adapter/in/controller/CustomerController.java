package com.gabryel.hexagonal.adapter.in.controller;

import com.gabryel.hexagonal.adapter.in.controller.mapper.CustomerMapper;
import com.gabryel.hexagonal.adapter.in.controller.request.CustomerRequest;
import com.gabryel.hexagonal.adapter.in.controller.response.CustomerResponse;
import com.gabryel.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.gabryel.hexagonal.application.ports.in.InsertCustomerInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final InsertCustomerInputPort insertCustomerInputPort;
    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final CustomerMapper customerMapper;


    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody CustomerRequest customerRequest) {

        var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.zipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable("id") String id) {

        var customer = findCustomerByIdInputPort.find(id);
        return ResponseEntity.ok().body(customerMapper.toCustomerResponse(customer));
    }
}