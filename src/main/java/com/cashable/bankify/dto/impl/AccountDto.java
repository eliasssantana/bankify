package com.cashable.bankify.dto.impl;

import java.math.BigDecimal;

import com.cashable.bankify.domain.model.Account;
import com.cashable.bankify.dto.DomainDTO;

public record AccountDto(String number, String agency, BigDecimal balance, BigDecimal limit) implements DomainDTO<Account> {

    public AccountDto(Account account)
    {
        this(
                // account.getId(),
                account.getNumber(),
                account.getAgency(),
                account.getBalance(),
                account.getLimit()

        );
    }

    public Account toModel() {
        Account model = new Account();
        // model.setId(this.id);
        model.setNumber(this.number);
        model.setAgency(this.agency);
        model.setBalance(this.balance);
        model.setLimit(this.limit);
        return model;
    }
}
