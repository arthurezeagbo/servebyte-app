package com.arthurezeagbo.paymentprocessor.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaymentDto {

    private Long amount;
    private String email;
}
