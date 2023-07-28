package com.example.paymentservice.service;

import com.example.paymentservice.client.CardClient;
import com.example.paymentservice.client.request.AmountRequest;
import com.example.paymentservice.client.response.CardClientReponse;
import com.example.paymentservice.domain.Payment;
import com.example.paymentservice.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final CardClient cardClient;

    public Payment pay(Payment payment) {

        CardClientReponse balance = cardClient.getBalance(payment.getCardPan());

        if (payment.getAmount().compareTo(balance.getBalance()) > 0) {
            throw new RuntimeException("Balansinizda yeteri qeder vesait yoxdur");
        }

        Payment savedPayment = paymentRepository.save(payment);

        cardClient.updateBalance(savedPayment.getCardPan(), new AmountRequest(savedPayment.getAmount()));

        return savedPayment;
    }
}
