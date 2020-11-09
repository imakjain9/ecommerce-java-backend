package com.ecommerce.controllers;

import com.ecommerce.dto.CustomerRegisterDTO;
import com.ecommerce.dto.RegisterRequestDTO;
import com.ecommerce.entity.User;
import com.ecommerce.services.CustomerService;
import com.ecommerce.services.ItemService;
import com.ecommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLOutput;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private UserService userService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ItemService itemService;

    @RequestMapping(method = RequestMethod.GET)
    public String home(ModelMap modelMap) {
        modelMap.addAttribute("title", "Daily-Hisabh");
        modelMap.addAttribute("userList", userService.getUsers());
        return "home.jsp";
    }

    @RequestMapping(value = "registerForm", method = RequestMethod.GET)
    public String registerForm(ModelMap modelMap) { return "registerForm.jsp"; }

    @RequestMapping(value = "registerSubmit", method = RequestMethod.POST)
    public String register(@ModelAttribute("registerRequestDTO") RegisterRequestDTO registerRequestDTO) {
        userService.register(registerRequestDTO);
        return "home.jsp";
    }
    @RequestMapping(value="userProfile",method = RequestMethod.GET)
    public String userProfile(ModelMap modelMap, @RequestParam String userId){
        modelMap.addAttribute("userList", userService.getUsers());
        return "userProfile.jsp";
    }

    @RequestMapping(value = "addCustomerForm", method = RequestMethod.GET)
    public String addCustomerForm(ModelMap modelMap) {
        modelMap.addAttribute("userList", userService.getUsers());
        return "addCustomerForm.jsp";
    }

    @RequestMapping(value = "addCustomerSubmit", method = RequestMethod.POST)
    public String registerCustomer(@ModelAttribute("customerRegisterDTO") CustomerRegisterDTO customerRegisterDTO) {
        customerService.register(customerRegisterDTO);
        return "home.jsp";
    }

    @RequestMapping(value = "addItem", method = RequestMethod.GET)
    public String addItem(ModelMap modelMap) { return "addItem.jsp"; }


    @RequestMapping(value = "addCustomerSubscription", method = RequestMethod.GET)
    public String addCustomerSubscription(ModelMap modelMap) {
        modelMap.addAttribute("customerList",customerService.getCustomerList());
        modelMap.addAttribute("itemList",itemService.getItem());
        return "itemSubscription.jsp";
    }

    @RequestMapping(value = "getCustomerSubscription", method = RequestMethod.GET)
    public String getCustomerSubscription(ModelMap modelMap) {
        return "home.jsp";
    }
}