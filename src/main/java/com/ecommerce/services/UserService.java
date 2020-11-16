package com.ecommerce.services;

import com.ecommerce.dto.RegisterRequestDTO;
import com.ecommerce.entity.Customer;
import com.ecommerce.entity.User;
import com.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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

    public User getUser(String userid){
        Long id=Long.parseLong(userid);
        return userRepository.getUser(id);
    }
    public Set<Customer> getUserCustomers(String id) {
        return userRepository.getUserCustomers(Long.parseLong(id));
    }
}
