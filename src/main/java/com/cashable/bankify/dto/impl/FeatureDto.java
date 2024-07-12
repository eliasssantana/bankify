package com.cashable.bankify.dto.impl;

import com.cashable.bankify.domain.model.Feature;
import com.cashable.bankify.dto.DomainDTO;

public record FeatureDto(String icon, String description) implements DomainDTO<Feature> {

    public FeatureDto(Feature feature){

        this (
                // feature.getId(),
                feature.getIcon(),
                feature.getDescription()
        );
    };

    @Override
    public Feature toModel() {
        Feature model = new Feature();
        // model.setId(this.id);
        model.setIcon(this.icon);
        model.setDescription(this.description);
        return model;
    }
}
