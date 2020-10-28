package com.ecommerce.services;

import com.ecommerce.dto.RegisterRequestDTO;
import com.ecommerce.entity.User;
import com.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void register(RegisterRequestDTO registerRequestDTO){
        userRepository.addUser(registerRequestDTO);
    }

    public List<User> getUsers(){
        return userRepository.list();
    }
}
