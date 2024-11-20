package com.gabryel.hexagonal.adapter.out;

import com.gabryel.hexagonal.adapter.out.client.FindAddressByZipCodeClient;
import com.gabryel.hexagonal.adapter.out.client.mapper.AddressMapper;
import com.gabryel.hexagonal.application.core.domain.Address;
import com.gabryel.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    private final FindAddressByZipCodeClient clientZipCode;
    private final AddressMapper addressMapper;

    @Override
    public Address find(String zipCode) {
        return addressMapper.toDomain(clientZipCode.find(zipCode));
    }

}
