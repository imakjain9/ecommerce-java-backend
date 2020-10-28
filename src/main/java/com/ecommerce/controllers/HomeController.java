package com.ecommerce.controllers;

import com.ecommerce.dto.RegisterRequestDTO;
import com.ecommerce.entity.User;
import com.ecommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLOutput;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String home(ModelMap modelMap){
        modelMap.addAttribute("title","E-commerce");
        modelMap.addAttribute("userList", userService.getUsers());
        return "home.jsp";
    }

    @RequestMapping(value="registerForm",method = RequestMethod.GET)
    public String registerForm(ModelMap modelMap){
        return "registerForm.jsp";
    }

    @RequestMapping(value="registerSubmit",method = RequestMethod.POST)
    public String register(@ModelAttribute("registerRequestDTO") RegisterRequestDTO registerRequestDTO) {
        userService.register(registerRequestDTO);
        return "home.jsp";
    }
}
