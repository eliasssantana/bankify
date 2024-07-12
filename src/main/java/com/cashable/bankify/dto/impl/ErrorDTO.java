package com.cashable.bankify.dto.impl;

import java.time.LocalDate;

public record ErrorDTO(
        LocalDate timestamp,
        String status,
        Integer code,
        String message
) {
}
