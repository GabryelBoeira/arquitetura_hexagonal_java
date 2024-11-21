package com.gabryel.hexagonal.adapter.in.controller.mapper;

import com.gabryel.hexagonal.adapter.in.controller.request.CustomerRequest;
import com.gabryel.hexagonal.adapter.in.controller.response.CustomerResponse;
import com.gabryel.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    /**
     * Maps a {@link CustomerRequest} to a {@link Customer} domain object.
     * The fields "id", "address", and "isValidCpf" are ignored during mapping.
     *
     * @param customerRequest the customer request containing data to map
     * @return the mapped customer domain object
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    Customer toCustomer(CustomerRequest customerRequest);

    /**
     * Maps a {@link Customer} domain object to a {@link CustomerResponse} object.
     *
     * @param customer the customer domain object containing data to map
     * @return the mapped customer response object
     */
    CustomerResponse toCustomerResponse(Customer customer);

}
