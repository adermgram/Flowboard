package com.adam.flowboard.service;

import java.util.Locale;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.adam.flowboard.domain.entity.User;
import com.adam.flowboard.dto.auth.RegisterRequest;
import com.adam.flowboard.dto.auth.UserResponse;
import com.adam.flowboard.exception.DuplicateEmailException;
import com.adam.flowboard.repository.UserRepository;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public UserResponse register(RegisterRequest request){

        String email = request.email().trim().toLowerCase(Locale.ROOT);

        if (userRepository.existsByEmail(email)){
            throw new DuplicateEmailException("Email already exists");
        }

        String hashedPassword =
                passwordEncoder.encode(request.password());

        
        User user = new User(
                request.name(),
                email,
                hashedPassword
        );

        User savedUser = userRepository.save(user);

        return new UserResponse(savedUser.getId(), savedUser.getName(), savedUser.getEmail());

    }
    
}
