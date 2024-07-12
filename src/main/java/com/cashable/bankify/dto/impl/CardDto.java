package com.cashable.bankify.dto.impl;

import com.cashable.bankify.domain.model.Card;
import com.cashable.bankify.dto.DomainDTO;

import java.math.BigDecimal;

public record CardDto(String number, BigDecimal limit) implements DomainDTO<Card> {

    public CardDto(Card card)
    {
        this(
                // card.getId(),
                card.getNumber(),
                card.getLimit()
        );
    }
    public Card toModel(){
        Card model = new Card();
        // model.setId(this.id);
        model.setNumber(this.number);
        model.setLimit(this.limit);
        return model;
    }

}
