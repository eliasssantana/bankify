package com.cashable.bankify.dto.impl;

import com.cashable.bankify.domain.model.News;
import com.cashable.bankify.dto.DomainDTO;

public record NewsDto(String icon, String description) implements DomainDTO<News> {

    public NewsDto(News news){
        this (
                // news.getId(),
                news.getIcon(),
                news.getDescription()
        );
    }

    @Override
    public News toModel() {
        News model = new News();
        // model.setId(this.id);
        model.setIcon(this.icon);
        model.setDescription(this.description);
        return model;
    }
}
