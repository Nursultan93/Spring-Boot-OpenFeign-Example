package com.example.paymentservice.client;

import com.example.paymentservice.client.request.AmountRequest;
import com.example.paymentservice.client.response.CardClientReponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@FeignClient(name = "card-client", url = "http://localhost:8080")
public interface CardClient {


    @GetMapping("/cards/balance/{pan}")
    CardClientReponse getBalance(@PathVariable String pan);

    @PutMapping("/cards/balance/{pan}")
    void updateBalance(@PathVariable String pan, @RequestBody AmountRequest request);
}
