package com.gabryel.hexagonal.configuration.beans;

import com.gabryel.hexagonal.adapter.out.FindAddressByZipCodeAdapter;
import com.gabryel.hexagonal.adapter.out.InsertCustomerAdapter;
import com.gabryel.hexagonal.adapter.out.SendCpfValidationAdapter;
import com.gabryel.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
                                                       InsertCustomerAdapter insertCustomerAdapter,
                                                       SendCpfValidationAdapter sendCpfValidationAdapter)
    {
        return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter, sendCpfValidationAdapter);
    }

}
