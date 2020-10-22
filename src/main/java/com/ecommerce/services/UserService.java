package com.ecommerce.services;

import com.ecommerce.dto.RegisterRequestDTO;
import com.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void register(RegisterRequestDTO registerRequestDTO){
        userRepository.addUser(registerRequestDTO);
    }
}
