package com.gabryel.hexagonal.application.ports.out.kafka;

public interface SendCpfForValidationOutputPort {

    /**
     * Sends a CPF to the message broker to validate it.
     *
     * @param cpf the CPF to be validated
     */
    void send(String cpf);
}
