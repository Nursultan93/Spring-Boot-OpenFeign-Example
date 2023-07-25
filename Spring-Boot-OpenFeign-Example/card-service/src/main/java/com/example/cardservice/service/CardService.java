package com.example.cardservice.service;

import com.example.cardservice.dto.request.CardRequest;
import com.example.cardservice.dto.response.CardResponse;
import com.example.cardservice.mapper.CardMapper;
import com.example.cardservice.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    CardMapper mapper = CardMapper.INSTANCE;

    public CardResponse create(CardRequest request) {
        var entity = mapper.cardRequestToCard(request);

        var card = cardRepository.save(entity);

        return mapper.cardtoCardResponse(card);
    }

    public CardResponse update(Long id, CardRequest request) {
        return new CardResponse();
    }

    public void delete(Long id) {

    }

    public CardResponse getCardById(Long id) {
        return new CardResponse();
    }
}
