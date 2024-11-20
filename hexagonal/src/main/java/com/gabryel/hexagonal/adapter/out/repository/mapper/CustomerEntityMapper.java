package com.gabryel.hexagonal.adapter.out.repository.mapper;

import com.gabryel.hexagonal.adapter.out.repository.entity.CustomerEntity;
import com.gabryel.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    /**
     * Converts a {@link Customer} domain object to a {@link CustomerEntity}.
     *
     * @param customer the customer domain object to convert
     * @return the converted customer entity
     */
    CustomerEntity toEntity(Customer customer);

    /**
     * Converts a {@link CustomerEntity} repository object to a {@link Customer} domain object.
     *
     * @param customerEntity the customer entity to convert
     * @return the converted customer domain object
     */
    Customer toDomain(CustomerEntity customerEntity);

}
