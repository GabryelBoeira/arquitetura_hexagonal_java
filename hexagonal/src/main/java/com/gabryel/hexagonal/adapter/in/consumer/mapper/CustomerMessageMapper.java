package com.gabryel.hexagonal.adapter.in.consumer.mapper;

import com.gabryel.hexagonal.adapter.in.consumer.message.CustomerMessage;
import com.gabryel.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMessageMapper {

    @Mapping(target = "address", ignore = true)
    Customer toCustomer(CustomerMessage customerMessage);

}
