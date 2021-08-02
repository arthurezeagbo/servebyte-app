package com.arthurezeagbo.apigateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayFallbackController {

    @PostMapping("/paymentFallBack")
    public String paymentFallBackMethod(){
        return "Payment service is taking longer time to respond, please try again later";
    }

    @GetMapping("/restaurantFallBack")
    public String restaurantFallBackMethod(){
        return "Restaurant service is taking longer time respond, please try again later";
    }


}
