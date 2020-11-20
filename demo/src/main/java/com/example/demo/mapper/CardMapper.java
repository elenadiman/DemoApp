package com.example.demo.mapper;

import com.example.demo.dto.CreateCardRequest;
import com.example.demo.model.Card;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CardMapper {
    CreateCardRequest cardToCardDto(Card card);
}
