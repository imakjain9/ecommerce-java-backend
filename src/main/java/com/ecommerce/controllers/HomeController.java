package com.ecommerce.controllers;

import com.ecommerce.dto.CustomerRegisterDTO;
import com.ecommerce.dto.ItemAddDTO;
import com.ecommerce.dto.RegisterRequestDTO;
import com.ecommerce.dto.SubscriptionDTO;
import com.ecommerce.entity.User;
import com.ecommerce.services.CustomerService;
import com.ecommerce.services.ItemService;
import com.ecommerce.services.SubscriptionService;
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

    @Autowired
    private SubscriptionService subscriptionService;

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
        System.out.println(registerRequestDTO.getFirstName());
        userService.register(registerRequestDTO);
        return "redirect:" + "/";
    }
    @RequestMapping(value="userProfile",method = RequestMethod.GET)
    public String userProfile(ModelMap modelMap, @RequestParam String userId){
        modelMap.addAttribute("user",userService.getUser(userId));
        modelMap.addAttribute("userList", userService.getUsers());
        modelMap.addAttribute("userCustomersList",userService.getUserCustomers(userId));
        return "userProfile.jsp";
    }

    @RequestMapping(value = "addCustomerForm", method = RequestMethod.GET)
    public String addCustomerForm(ModelMap modelMap) {
        modelMap.addAttribute("userList", userService.getUsers());
        return "addCustomerForm.jsp";
    }

    @RequestMapping(value = "addCustomerSubmit", method = RequestMethod.POST)
    public String registerCustomer(@ModelAttribute("customerRegisterDTO") CustomerRegisterDTO customerRegisterDTO) {
        Long userId = customerService.register(customerRegisterDTO);
        return "redirect:" + "userProfile?userId="+userId;
    }

    @RequestMapping(value = "items/new", method = RequestMethod.GET)
    public String addItem(ModelMap modelMap) { return "addItem.jsp"; }

    @RequestMapping(value = "items", method = RequestMethod.POST)
    public String itemSubmit(@ModelAttribute("itemAddDTO") ItemAddDTO itemAddDTO) {
        itemService.register(itemAddDTO);
        return "redirect:" + "addCustomerSubscription";
    }

    @RequestMapping(value="itemdelete",method=RequestMethod.GET)
    public String deleteItem(ModelMap modelMap,@RequestParam String itemId){
        modelMap.addAttribute("item",itemService.getItem(itemId));
             itemService.deleteItem(itemId);
        return "redirect:" + "addCustomerSubscription";
    }
    @RequestMapping(value = "itemedit", method = RequestMethod.GET)
    public String editItem(ModelMap modelMap,@RequestParam String itemId) {
        modelMap.addAttribute("item",itemService.getItem(itemId));
        return "editItem.jsp";
    }

    @RequestMapping(value="updateItem",method = RequestMethod.POST)
    public String updateItem(@ModelAttribute("itemAddDTO") ItemAddDTO itemAddDTO,@RequestParam String itemId) {
      itemService.updateItem(itemAddDTO,itemId);
        return "redirect:" + "addCustomerSubscription";
    }


    @RequestMapping(value ="addCustomerSubscription", method = RequestMethod.GET)
    public String addCustomerSubscription(ModelMap modelMap) {
        modelMap.addAttribute("customerList",customerService.getCustomerList());
        modelMap.addAttribute("itemList",itemService.getItems());
        return "itemSubscription.jsp";
    }

    @RequestMapping(value = "submitCustomerSubscription", method = RequestMethod.POST)
    public String submitCustomerSubscription(ModelMap modelMap,@ModelAttribute("subscriptionDTO")SubscriptionDTO subscriptionDTO) {
        subscriptionService.addSubscription(subscriptionDTO);
        return "redirect:" + "/";
    }
}