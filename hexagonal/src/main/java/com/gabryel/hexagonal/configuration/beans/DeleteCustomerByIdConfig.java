package com.gabryel.hexagonal.configuration.beans;

import com.gabryel.hexagonal.adapter.out.DeleteCustomerByIdAdapter;
import com.gabryel.hexagonal.application.core.usecase.DeleteCustomerByIdUseCase;
import com.gabryel.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {

    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(FindCustomerByIdUseCase findCustomerByIdUseCase,
                                                               DeleteCustomerByIdAdapter deleteCustomerByIdAdapter)
    {
        return new DeleteCustomerByIdUseCase(findCustomerByIdUseCase, deleteCustomerByIdAdapter);
    }
}
