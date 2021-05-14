package com.ecommerce.controllers;

import com.ecommerce.dto.SubscriptionDTO;
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
    public String addCustomerSubscription(ModelMap modelMap, @RequestParam Long userId, @RequestParam Long customerId, @RequestParam Long itemId) {
        if(sellerTargetService.sellerTargetItemQunatity(customerId,itemId)==0.00) {
            System.out.println(sellerTargetService.sellerTargetItemQunatity(customerId,itemId));
            modelMap.addAttribute("user",userId);
            modelMap.addAttribute("itemId",itemId);
            return "SellerTarget.jsp";
        }

        modelMap.addAttribute("customerId",customerId);
        modelMap.addAttribute("item",itemService.getItem(itemId.toString()));
        modelMap.addAttribute("userId",userId);
        return "itemSubscription.jsp";
    }

    @RequestMapping(value = "/removeCustomerSubscription",method = RequestMethod.GET)
    public String removeCustomerSubscription(ModelMap modelMap,@RequestParam Long userId,@RequestParam Long customerId,@RequestParam Long itemId){
        subscriptionService.removeCustomerSubscription(itemId,customerId);
        return "redirect:" + "userProfile?userId="+userId;
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
    public String getCustomerSubscription(ModelMap modelMap, @ModelAttribute("subscriptionDTO") SubscriptionDTO subscriptionDTO, @RequestParam Long userId, @ModelAttribute("customerId")@RequestParam Long customerId, @ModelAttribute("itemId")@RequestParam Long itemId) {
        try {

            subscriptionService.addSubscription(subscriptionDTO,customerId,itemId);
            return "redirect:" + "/userProfile?userId=" + userId;
        }catch (Exception e){
            modelMap.addAttribute("message",e.getMessage());
            modelMap.addAttribute("action","stopSubscription");
            e.printStackTrace();
            return  "redirect:" + "error" ;
        }
    }

}
