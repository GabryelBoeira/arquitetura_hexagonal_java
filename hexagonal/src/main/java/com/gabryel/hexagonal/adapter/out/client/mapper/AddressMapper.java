package com.gabryel.hexagonal.adapter.out.client.mapper;

import com.gabryel.hexagonal.adapter.out.client.response.AddressResponse;
import com.gabryel.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    /**
     * Maps an {@link AddressResponse} to an {@link Address}.
     *
     * @param addressResponse the response to map
     * @return the mapped address
     */
    Address toDomain(AddressResponse addressResponse);

    /**
     * Maps an {@link Address} to an {@link AddressResponse}.
     *
     * @param address the domain object to map
     * @return the mapped response
     */
    AddressResponse toResponse(Address address);

}
