package com.example.cardservice.mapper;

import com.example.cardservice.domain.Card;
import com.example.cardservice.dto.request.CardRequest;
import com.example.cardservice.dto.response.CardResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CardMapper {
    CardMapper INSTANCE = Mappers.getMapper( CardMapper.class );

    @Mapping(target = "pan", source = "pan")
    @Mapping(target = "expDate", source = "expDate")
    @Mapping(target = "cvv", source = "cvv")
    @Mapping(target = "customer.id", source = "customerId")
    Card cardRequestToCard(CardRequest request);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "pan", source = "pan")
    @Mapping(target = "expDate", source = "expDate")
    @Mapping(target = "cvv", source = "cvv")
    CardResponse cardtoCardResponse(Card card);
}
