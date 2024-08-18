package com.cashable.bankify.dto;

import java.time.LocalDateTime;

public record ResponseError<T>(LocalDateTime timestamp, String details) implements IResponse<T> {}