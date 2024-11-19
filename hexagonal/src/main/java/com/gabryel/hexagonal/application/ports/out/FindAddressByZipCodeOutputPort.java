package com.gabryel.hexagonal.application.ports.out;

import com.gabryel.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipCode);

}
