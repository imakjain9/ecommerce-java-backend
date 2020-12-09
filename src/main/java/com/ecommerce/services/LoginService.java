package com.ecommerce.services;

import com.ecommerce.dto.LoginDTO;
import com.ecommerce.entity.User;
import com.ecommerce.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private  AdminRepository adminRepository;

    public Boolean userAuthantication(LoginDTO loginDTO){

       String userEmail= loginDTO.getEmail();
       String userPassword= loginDTO.getPassword();
         return adminRepository.userAuthantication(userEmail,userPassword);
    }

  /*  public User getAdmin(){
        return adminRepository.getAdmin();
    }

   */
}
