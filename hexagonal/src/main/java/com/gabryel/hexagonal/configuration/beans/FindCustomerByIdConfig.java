package com.gabryel.hexagonal.configuration.beans;

import com.gabryel.hexagonal.adapter.out.FindCustomerByIdAdapter;
import com.gabryel.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {

    @Bean
    public FindCustomerByIdUseCase findCustomerByIdUseCase(FindCustomerByIdAdapter findCustomerByIdAdapter)
    {
        return new FindCustomerByIdUseCase(findCustomerByIdAdapter);
    }

}
