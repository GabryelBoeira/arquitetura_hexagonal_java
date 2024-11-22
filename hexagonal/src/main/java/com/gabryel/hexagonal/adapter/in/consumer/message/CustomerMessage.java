package com.gabryel.hexagonal.adapter.in.consumer.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerMessage {

    private String id;
    private String name;
    private String cpf;
    private String zipCode;
    private Boolean isValidCpf;
}
