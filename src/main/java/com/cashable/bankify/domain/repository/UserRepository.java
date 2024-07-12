package com.cashable.bankify.domain.repository;

import com.cashable.bankify.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    boolean existsByAccountNumber(String number);

    boolean existsByCardNumber(String number);
}
