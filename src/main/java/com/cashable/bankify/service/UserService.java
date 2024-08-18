package com.cashable.bankify.service;

import com.cashable.bankify.domain.model.User;
import com.cashable.bankify.dto.impl.UserIdDTO;
import com.cashable.bankify.dto.impl.UserResponseDTO;

import java.util.List;

public interface UserService {

    UserResponseDTO findById(String id);

    List<UserResponseDTO> findAll();

    UserIdDTO create(User user);

    UserResponseDTO update(String id, User user);

    void deleteById(String id);
}
