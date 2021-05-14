/*
package com.ecommerce.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/items")
public class ItemController {

     @Autowired
    private ItemService itemService;


    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String addItem(ModelMap modelMap) { return "addItem.jsp"; }

    @RequestMapping(method = RequestMethod.POST)
    public String itemSubmit(@ModelAttribute("itemAddDTO") ItemAddDTO itemAddDTO) {
        itemService.register(itemAddDTO);
        return "redirect:" + "addCustomerSubscription";
    }
    @RequestMapping(value = "/:id/edit", method = RequestMethod.GET)
    public String addItem(ModelMap modelMap) { return "editItem.jsp"; }

    @RequestMapping(value="/:id",method = RequestMethod.PUT)
    public String itemSubmit(@ModelAttribute("itemAddDTO") ItemAddDTO itemAddDTO) {
      return "redirect:" + "addCustomerSubscription";
    }

    @RequestMapping(value="/:id",method=RequestMethod.DELETE)
    public String deleteItem(ModelMap modelMap, @RequestParam String itemId){
      itemService.deleteItem(itemId);
        return "redirect:" + "addCustomerSubscription";
    }

}
*/