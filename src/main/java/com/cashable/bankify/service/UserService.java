package com.cashable.bankify.domain.service;

import com.cashable.bankify.domain.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findById(Long id);

    User create(User user);
}
