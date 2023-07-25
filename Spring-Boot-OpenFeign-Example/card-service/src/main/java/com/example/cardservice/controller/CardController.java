package com.example.cardservice.controller;

import com.example.cardservice.dto.request.CardRequest;
import com.example.cardservice.dto.response.CardResponse;
import com.example.cardservice.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @PostMapping
    private CardResponse create(@RequestBody CardRequest request) {
        return cardService.create(request);
    }

    @PutMapping("/{id}")
    private CardResponse update(@PathVariable(name = "id") Long id, @RequestBody CardRequest request) {
        return cardService.update(id, request);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable(name = "id") Long id) {
        cardService.delete(id);
    }

    @GetMapping("/{id}")
    private CardResponse update(@PathVariable(name = "id") Long id) {
        return cardService.getCardById(id);
    }
}
