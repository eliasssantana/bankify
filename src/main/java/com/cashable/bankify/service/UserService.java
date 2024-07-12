package com.cashable.bankify.service;

import com.cashable.bankify.domain.model.User;
import com.cashable.bankify.dto.impl.UserIdDTO;
import com.cashable.bankify.dto.impl.UserResponseDTO;

public interface UserService {

    UserResponseDTO findById(String id);

    UserIdDTO create(User user);
}
