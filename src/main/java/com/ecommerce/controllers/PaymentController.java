package com.ecommerce.controllers;

import com.ecommerce.dto.PaymentDTO;
import com.ecommerce.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public String getPayment(ModelMap modelMap, @RequestParam Long customerId){
        modelMap.addAttribute("customer",customerId);
        modelMap.addAttribute("date",new Date());
        return "payment.jsp";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addPayment(@ModelAttribute("paymentDTO") PaymentDTO paymentDTO, @ModelAttribute("customer")@RequestParam Long customer){

        paymentService.register(paymentDTO,customer);
        return "redirect:" + "/customerProfile?customerId="+customer;
    }
}
