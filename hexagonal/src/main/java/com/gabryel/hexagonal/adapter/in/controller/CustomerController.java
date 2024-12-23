package com.gabryel.hexagonal.adapter.in.controller;

import com.gabryel.hexagonal.adapter.in.controller.mapper.CustomerMapper;
import com.gabryel.hexagonal.adapter.in.controller.request.CustomerRequest;
import com.gabryel.hexagonal.adapter.in.controller.response.CustomerResponse;
import com.gabryel.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.gabryel.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.gabryel.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.gabryel.hexagonal.application.ports.in.UpdateCustomerInputPort;
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
    private final UpdateCustomerInputPort updateCustomerInputPort;
    private final DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;
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

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") String id, @Valid @RequestBody CustomerRequest customerRequest) {
        var customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerInputPort.update(customer, customerRequest.zipCode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        deleteCustomerByIdInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }

}
