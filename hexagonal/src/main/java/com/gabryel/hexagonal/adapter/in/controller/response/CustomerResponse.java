package com.gabryel.hexagonal.adapter.in.controller.response;

public record CustomerResponse(
        String name,
        String cpf,
        Boolean isValidCpf,
        AddressResponse address
) {
}
