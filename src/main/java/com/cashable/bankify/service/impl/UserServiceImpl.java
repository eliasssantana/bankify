package com.cashable.bankify.service.impl;

import com.cashable.bankify.domain.model.User;
import com.cashable.bankify.domain.repository.UserRepository;
import com.cashable.bankify.dto.impl.UserRequestDTO;
import com.cashable.bankify.dto.impl.UserIdDTO;
import com.cashable.bankify.dto.impl.UserResponseDTO;
import com.cashable.bankify.exceptions.UserAlreadyExistsException;
import com.cashable.bankify.exceptions.UserNotFoundException;
import com.cashable.bankify.service.UserService;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDTO findById(String id) {

        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));

        return new UserResponseDTO(user);
    }

    @Override
    public UserIdDTO create(User user) {
        Optional.ofNullable(user).orElseThrow(() -> new IllegalArgumentException("Request body required."));
        Optional.ofNullable(user.getAccount()).orElseThrow(() -> new IllegalArgumentException("User account required."));
        Optional.ofNullable(user.getCard()).orElseThrow(() -> new IllegalArgumentException("User card required."));

        // TODO: o problema está aqui. O id não está sendo encontrado
        if (userRepository.existsByAccountNumber(user.getAccount().getNumber()) || userRepository.existsByCardNumber(user.getCard().getNumber())) {
            throw new UserAlreadyExistsException("User already exists in the database.");
        }

        User newUser = userRepository.save(user);

        return new UserIdDTO(newUser.getId());
    }
}
