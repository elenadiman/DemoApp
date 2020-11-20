package com.example.demo.mapper;

import com.example.demo.dto.CreateCardRequest;
import com.example.demo.model.Card;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CardMapper {

    CardMapper instance = Mappers.getMapper(CardMapper.class);
    @Mapping(source = "type", target = "type")
    @Mapping(source = "cardNumber", target = "cardNumber")
    @Mapping(source = "balance", target = "balance")
    @Mapping(source = "validFrom", target = "validFrom")
    @Mapping(source = "validTo", target = "validTo")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "visiblePan", target = "visiblePan")
    Card card(CreateCardRequest createCardRequest);
}
