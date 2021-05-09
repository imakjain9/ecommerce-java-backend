package com.ecommerce.controllers;

import com.ecommerce.dto.AnomaliesDTO;
import com.ecommerce.entity.Subscription;
import com.ecommerce.repository.SubscriptionRepository;
import com.ecommerce.services.AnomaliesService;
import com.ecommerce.services.CustomerService;
import com.ecommerce.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;


@Controller
@RequestMapping("/anomaly")
public class AnomalyController {

    @Autowired
    CustomerService customerService;

    @Autowired
    AnomaliesService anomaliesService;

    @Autowired
    SubscriptionRepository subscriptionRepository;

    @RequestMapping(value = "/getAnomalies",method = RequestMethod.GET)
    public String getAnomailes(ModelMap modelMap, @RequestParam Long customerId) {
        modelMap.addAttribute("customerSubscriptionList",customerService.getCustomerSubscriptions(customerId));
        modelMap.addAttribute("customerId",customerId);
        return "dailyAnomilies.jsp";
    }

    @RequestMapping(value = "error",method = RequestMethod.GET )
    public String error(ModelMap modelMap,@RequestParam String message,@RequestParam String action,@RequestParam(required = false)String role,@RequestParam(required = false)Long customerId){
        modelMap.addAttribute("message",message);
        modelMap.addAttribute("action",action);
        if(action.equals("Login")) modelMap.addAttribute("actionUrl","getlogin?role="+role);
        if(action.equals("stopSubscription"))modelMap.addAttribute("actionUrl","#");
        if(action.equals("getAnomalies"))modelMap.addAttribute("actionUrl","/anomaly/getAnomalies?customerId="+customerId);
        return "error.jsp";
    }

    @RequestMapping(value = "/addAnomalies",method = RequestMethod.POST)
    public String addAnomalies(ModelMap modelMap,@ModelAttribute("anomaliesDTO") AnomaliesDTO anomaliesDTO, @ModelAttribute("customerId")@RequestParam Long customerId)throws Exception{
        Subscription subscription=subscriptionRepository.getSubscriptionById(anomaliesDTO.getSubscription_id());
        Date anomalyDate= DateUtil.stringToDate(anomaliesDTO.getDate());
        Date subStartDate=subscription.getStartDate();
        Date currentDate= new Date();

        if(subscription.getActive() && anomalyDate.after(subStartDate) && anomalyDate.before(currentDate)) {
            Long userId = anomaliesService.register(anomaliesDTO, customerId);
            return "redirect:" + "userProfile?userId=" + userId;
        }
        modelMap.addAttribute("message","Invalid Date");
        modelMap.addAttribute("action","getAnomalies");
        modelMap.addAttribute("customerId",customerId);
        return  "redirect:" + "error" ;
    }

}
