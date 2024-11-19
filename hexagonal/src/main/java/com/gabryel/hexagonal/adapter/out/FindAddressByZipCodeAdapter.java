package com.gabryel.hexagonal.adapter.out;

import com.gabryel.hexagonal.adapter.out.client.FindAddressByZipCodeClient;
import com.gabryel.hexagonal.adapter.out.client.mapper.AddressMapper;
import com.gabryel.hexagonal.application.core.domain.Address;
import com.gabryel.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    private final FindAddressByZipCodeClient clientZipCode;
    private final AddressMapper addressMapper;
    
    public FindAddressByZipCodeAdapter(FindAddressByZipCodeClient clientZipCode, AddressMapper addressMapper) {
        this.clientZipCode = clientZipCode;
        this.addressMapper = addressMapper;
    }

    @Override
    public Address find(String zipCode) {
        return addressMapper.toDomain(clientZipCode.find(zipCode));
    }

}
