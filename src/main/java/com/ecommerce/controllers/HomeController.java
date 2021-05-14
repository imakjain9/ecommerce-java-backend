package com.ecommerce.controllers;

import com.ecommerce.dto.*;
import com.ecommerce.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private SellerService sellerService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ItemService itemService;

    @Autowired
    private SubscriptionService subscriptionService;

    @Autowired
    private AnomaliesService anomaliesService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private SellerTargetService sellerTargetService;

    @Autowired
    private  LoginService loginService;

    @RequestMapping(method = RequestMethod.GET)
    public String home(ModelMap modelMap) {
        modelMap.addAttribute("title", "F");
        modelMap.addAttribute("userList", sellerService.getUsers());

        return "home.jsp";
    }
    @RequestMapping(value = "getlogin",method = RequestMethod.GET)
    public String loginForm(ModelMap modelMap,@RequestParam String role){
        modelMap.addAttribute("role",role);
        return "LoginForm.jsp";
    }
    //this method is for login from user
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(ModelMap modelMap,@ModelAttribute("loginDTO") LoginDTO loginDTO,@RequestParam String role){
        if(role.equals("admin")){
           Boolean auth=loginService.userAuthantication(loginDTO);
            System.out.println(auth);
           if(auth) {
               modelMap.addAttribute("itemList", itemService.getItems());
               return "redirect:" + "adminProfile";
           }else{
               modelMap.addAttribute("role",role);
               modelMap.addAttribute("message","Look like you're email or password is wrong");
               modelMap.addAttribute("action","Login");
               return "redirect:" + "error";
           }
        }
        else {
            Boolean auth = sellerService.sellerAuthantication(loginDTO);
            if (auth) {
                Long id = sellerService.sellerIdByEmail(loginDTO);
                return "redirect:" + "userProfile?userId=" + id;
            } else {
                modelMap.addAttribute("role",role);
                modelMap.addAttribute("message","Look like you're email or password is wrong");
                modelMap.addAttribute("action","Login");
                return "redirect:" + "error";
            }
        }
    }
    @RequestMapping(value = "registerForm", method = RequestMethod.GET)
    public String registerForm(ModelMap modelMap) { return "registerForm.jsp"; }

    @RequestMapping(value = "registerSubmit", method = RequestMethod.POST)
    public String register(@ModelAttribute("registerRequestDTO") RegisterRequestDTO registerRequestDTO) {
        sellerService.register(registerRequestDTO);
        return "redirect:" + "/";
    }
    @RequestMapping(value="userProfile",method = RequestMethod.GET)
    public String userProfile(ModelMap modelMap, @RequestParam String userId){
        modelMap.addAttribute("itemList",itemService.getItems());
        modelMap.addAttribute("user", sellerService.getUser(userId));
        modelMap.addAttribute("userCustomersList", sellerService.getUserCustomers(Long.parseLong(userId)));
        modelMap.addAttribute("TargetList",sellerService.getSellerTargetList(Long.parseLong(userId)));
        return "userProfile.jsp";
    }
    @RequestMapping(value="adminProfile",method = RequestMethod.GET)
    public String adminProfile(ModelMap modelMap){
        modelMap.addAttribute("itemList", itemService.getItems());
        return "AdminProfile.jsp";
    }
    @RequestMapping(value="customerProfile",method = RequestMethod.GET)
    public String customerrProfile(ModelMap modelMap,@RequestParam Long customerId){
        modelMap.addAttribute("customerId",customerService.getCustomerById(customerId));
        return "CustomerProfile.jsp";
    }
    @RequestMapping(value = "addCustomerForm", method = RequestMethod.GET)
    public String addCustomerForm(ModelMap modelMap,@RequestParam Long userId) {
        modelMap.addAttribute("userList", sellerService.getUsers());
        return "addCustomerForm.jsp";
    }

    @RequestMapping(value = "addCustomerSubmit", method = RequestMethod.POST)
    public String registerCustomer(@ModelAttribute("customerRegisterDTO") CustomerRegisterDTO customerRegisterDTO) {
        Long userId = customerService.register(customerRegisterDTO);
        return "redirect:" + "userProfile?userId="+userId;
    }

    @RequestMapping(value = "sellerTargetSubmit",method = RequestMethod.POST)
    public String sellerTargetSubmit(@ModelAttribute("sellerTargetDTO")SellerTargetDTO sellerTargetDTO,@RequestParam Long user,@RequestParam Long itemId ){
        sellerTargetService.addUserProfessionalDetails(sellerTargetDTO,user,itemId);
        return  "redirect:" + "userProfile?userId="+user;
    }
    @RequestMapping(value = "items/new", method = RequestMethod.GET)
    public String addItem(ModelMap modelMap) {
        return "addItem.jsp";
    }

    @RequestMapping(value = "items", method = RequestMethod.POST)
    public String itemSubmit(@ModelAttribute("itemAddDTO") ItemAddDTO itemAddDTO) {
        itemService.register(itemAddDTO);
        return "redirect:" + "adminProfile";
    }

    @RequestMapping(value="itemdelete",method=RequestMethod.GET)
    public String deleteItem(ModelMap modelMap,@RequestParam String itemId){
        modelMap.addAttribute("item",itemService.getItem(itemId));
        itemService.deleteItem(itemId);
        return "redirect:" + "adminProfile";
    }
    @RequestMapping(value = "itemedit", method = RequestMethod.GET)
    public String editItem(ModelMap modelMap,@RequestParam String itemId) {
        modelMap.addAttribute("item",itemService.getItem(itemId));
        return "editItem.jsp";
    }

    @RequestMapping(value="updateItem",method = RequestMethod.POST)
    public String updateItem(@ModelAttribute("itemAddDTO") ItemAddDTO itemAddDTO,@RequestParam String itemId) {
      itemService.updateItem(itemAddDTO,itemId);
      return "redirect:" + "adminProfile";
    }


    @RequestMapping(value = "error",method = RequestMethod.GET )
    public String error(ModelMap modelMap,@RequestParam String message,@RequestParam String action,@RequestParam(required = false)String role){
        modelMap.addAttribute("message",message);
        modelMap.addAttribute("action",action);
        if(action.equals("Login")) modelMap.addAttribute("actionUrl","getlogin?role="+role);
        if(action.equals("stopSubscription"))modelMap.addAttribute("actionUrl","#");
        return "error.jsp";
    }



}