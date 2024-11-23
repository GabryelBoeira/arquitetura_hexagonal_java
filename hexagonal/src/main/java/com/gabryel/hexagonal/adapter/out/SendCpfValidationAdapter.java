package com.gabryel.hexagonal.adapter.out;

import com.gabryel.hexagonal.application.ports.out.kafka.SendCpfForValidationOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SendCpfValidationAdapter implements SendCpfForValidationOutputPort {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void send(String cpf) {
        kafkaTemplate.send("tp-cpf-validation", cpf);
    }

}
