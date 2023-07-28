package com.example.paymentservice.controller;

import com.example.paymentservice.client.CardClient;
import com.example.paymentservice.client.response.CardClientReponse;
import com.example.paymentservice.domain.Payment;
import com.example.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public Payment pay(@RequestBody Payment payment) {
        return paymentService.pay(payment);
    }

}
