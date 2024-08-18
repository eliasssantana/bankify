package com.cashable.bankify.dto.impl;

import com.cashable.bankify.domain.model.User;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;
public record UserResponseDTO(
    String id,
    String name,
    AccountDto account,
    CardDto card,
    List<FeatureDto> features,
    List<NewsDto> news
) {

    public UserResponseDTO(User user){

        this(
                user.getId(),
                user.getName(),
                Optional.of(user.getAccount()).map(AccountDto::new).orElse(null),
                Optional.of(user.getCard()).map(CardDto::new).orElse(null),
                Optional.of(user.getFeatures()).orElse(emptyList()).stream().map(FeatureDto::new).toList(),
                Optional.of(user.getNews()).orElse(emptyList()).stream().map(NewsDto::new).toList()
        );
    }
    
}
