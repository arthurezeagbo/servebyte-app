package com.arthurezeagbo.paymentprocessor.service;

import com.arthurezeagbo.paymentprocessor.dto.PaymentDto;

public interface PaymentService {

    String makePayment(PaymentDto paymentDto);
}
