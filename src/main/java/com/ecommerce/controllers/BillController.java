package com.ecommerce.controllers;


import com.ecommerce.dto.BillDTO;
import com.ecommerce.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/bill")
public class BillController {

    @Autowired
    BillService billService;


    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public String getBill(ModelMap modelMap, @RequestParam Long customerId){
        BillDTO billDTO=billService.gentrateBill( customerId);
        modelMap.addAttribute("billDto",billDTO);
        return "bill.jsp";
    }


}
