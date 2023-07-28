package com.example.paymentservice.client.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardClientReponse {
    private BigDecimal balance;
}
