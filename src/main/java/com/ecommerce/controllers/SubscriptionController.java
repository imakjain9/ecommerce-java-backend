package com.ecommerce.controllers;

import com.ecommerce.dto.SubscriptionDTO;
import com.ecommerce.entity.Subscription;
import com.ecommerce.services.ItemService;
import com.ecommerce.services.SellerTargetService;
import com.ecommerce.services.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping("/subscription")
public class SubscriptionController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private SubscriptionService subscriptionService;

    @Autowired
    private SellerTargetService sellerTargetService;


    @RequestMapping(value ="/addCustomerSubscription", method = RequestMethod.GET)
    public String addCustomerSubscription(ModelMap modelMap, @RequestParam Long userId, @RequestParam Long customerId) {
        modelMap.addAttribute("customerId",customerId);
        modelMap.addAttribute("userId",userId);
        modelMap.addAttribute("items",itemService.getItems());
        return "itemSubscription.jsp";
    }

    @RequestMapping(value = "/removeCustomerSubscription",method = RequestMethod.GET)
    public String removeCustomerSubscription(ModelMap modelMap,@RequestParam Long userId,@RequestParam Long customerId){
        List<Subscription> subList= subscriptionService.getSubscriptionByCustomerId(customerId);
        modelMap.addAttribute("customerId",customerId);
       modelMap.addAttribute("userId",userId);
       modelMap.addAttribute("subscriptionList",subList);
        return "stopSubscription.jsp";
    }

    @RequestMapping(value = "/stop",method = RequestMethod.GET)
    public String stopSubscription(@RequestParam Long userId,@RequestParam Long customerId,@RequestParam Long subscriptionId){
        subscriptionService.removeCustomerSubscription(subscriptionId);
        return "redirect:" + "/userProfile?userId="+userId;
    }
    @RequestMapping(value = "error",method = RequestMethod.GET )
    public String error(ModelMap modelMap,@RequestParam String message,@RequestParam String action,@RequestParam(required = false)String role){
        modelMap.addAttribute("message",message);
        modelMap.addAttribute("action",action);
        if(action.equals("Login")) modelMap.addAttribute("actionUrl","getlogin?role="+role);
        if(action.equals("stopSubscription"))modelMap.addAttribute("actionUrl","#");
        return "error.jsp";
    }

    @RequestMapping(value = "/submitCustomerSubscription", method = RequestMethod.POST)
    public String submitCustomerSubscription(ModelMap modelMap, @ModelAttribute("subscriptionDTO") SubscriptionDTO subscriptionDTO, @RequestParam Long userId,@RequestParam Long customerId) {
        System.out.println("Subscription itemId: " + subscriptionDTO.getItemId());
        if(sellerTargetService.sellerTargetItemQunatity(customerId,subscriptionDTO.getItemId())==0.00) {
            System.out.println(sellerTargetService.sellerTargetItemQunatity(customerId,subscriptionDTO.getItemId()));
            modelMap.addAttribute("user",userId);
            modelMap.addAttribute("itemId",subscriptionDTO.getItemId());
            return "SellerTarget.jsp";
        }


        try {

            subscriptionService.addSubscription(subscriptionDTO,customerId);
            return "redirect:" + "/userProfile?userId=" + userId;
        }catch (Exception e){
            modelMap.addAttribute("message",e.getMessage());
            modelMap.addAttribute("action","stopSubscription");
            e.printStackTrace();
            return  "redirect:" + "error" ;
        }
    }

}
