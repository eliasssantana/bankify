package com.cashable.bankify.domain.service.impl;

import com.cashable.bankify.domain.model.User;
import com.cashable.bankify.domain.repository.UserRepository;
import com.cashable.bankify.domain.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id).orElseThrow( new UserNotFoundException());
    }

    @Override
    public User create(User user) {
        return null;
    }
}
