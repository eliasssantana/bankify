package com.cashable.bankify.dto.impl;

import java.util.List;
import java.util.Optional;

import com.cashable.bankify.domain.model.User;

import static java.util.Collections.emptyList;

public record UserRequestDTO(
    // String id,
    String name,
    AccountDto account,
    CardDto card,
    List<FeatureDto> features,
    List<NewsDto> news
) {

    public User toModel() {
        User model = new User();
        // model.setId(this.id);
        model.setName(this.name);
        model.setAccount(Optional.of(this.account.toModel()).orElse(null));
        model.setCard(Optional.of(this.card.toModel()).orElse(null));
        model.setFeatures(Optional.ofNullable(this.features).orElse(emptyList()).stream().map(FeatureDto::toModel).toList());
        model.setNews(Optional.ofNullable(this.news).orElse(emptyList()).stream().map(NewsDto::toModel).toList());
        return model;
    }
    
}
