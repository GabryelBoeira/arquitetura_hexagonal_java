package com.gabryel.hexagonal.configuration.beans;

import com.gabryel.hexagonal.adapter.out.FindAddressByZipCodeAdapter;
import com.gabryel.hexagonal.adapter.out.UpdateCustomerAdapter;
import com.gabryel.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.gabryel.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
                                                       FindCustomerByIdUseCase findCustomerByIdUseCase,
                                                       UpdateCustomerAdapter updateCustomerAdapter)
    {
        return new UpdateCustomerUseCase(findCustomerByIdUseCase, findAddressByZipCodeAdapter, updateCustomerAdapter);
    }

}
