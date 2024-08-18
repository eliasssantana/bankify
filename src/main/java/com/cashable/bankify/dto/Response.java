package com.cashable.bankify.dto;


public record Response<T>(T data) implements IResponse<T> {}
