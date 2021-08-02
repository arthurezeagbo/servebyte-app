package com.arthurezeagbo.paymentprocessor.controller;

import com.arthurezeagbo.paymentprocessor.dto.PaymentDto;
import com.arthurezeagbo.paymentprocessor.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public String makePayment(@RequestBody PaymentDto paymentDto){
        return paymentService.makePayment(paymentDto);
    }
}
