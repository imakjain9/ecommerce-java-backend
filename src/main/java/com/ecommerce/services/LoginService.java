package com.ecommerce.services;

import com.ecommerce.dto.LoginDTO;
import com.ecommerce.entity.User;
import org.springframework.stereotype.Service;

@Service
public class LoginService {


    public void userAuthantication(LoginDTO loginDTO){
        User user=new User();
         user.setEmail(loginDTO.getEmail());
         user.setPassword(loginDTO.getPassword());
    }
}
