package com.arthurezeagbo.paymentprocessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;

@EnableRetry
@EnableEurekaClient
@SpringBootApplication
public class PaymentProcessorApplication {

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(PaymentProcessorApplication.class);
		app.run(args);
	}



	@Bean
	public WebClient.Builder getWebClient(){
		return WebClient.builder();
	}

}
