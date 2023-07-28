package com.example.cardservice.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaidAmountRequest {
    private BigDecimal amount;
}
