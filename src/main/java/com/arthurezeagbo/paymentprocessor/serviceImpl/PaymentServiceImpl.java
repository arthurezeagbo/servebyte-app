package com.arthurezeagbo.paymentprocessor.serviceImpl;

import com.arthurezeagbo.paymentprocessor.dto.PaymentDto;
import com.arthurezeagbo.paymentprocessor.dto.PaymentResponseDto;
import com.arthurezeagbo.paymentprocessor.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    WebClient.Builder webclient;


    @Value( "${app.secret}" )
    private String secret;

    @Override
    public String makePayment(PaymentDto paymentDto) {

        var b = secret;
        PaymentResponseDto request = webclient.build()
                .post()
                .uri("https://api.paystack.co/transaction/initialize")
                .header("Authorization", "Bearer "+secret)
                .bodyValue(paymentDto)
                .retrieve()
                .bodyToMono(PaymentResponseDto.class).block();


        if(!request.getStatus()) return "failed";
        return "success";
    }
}
