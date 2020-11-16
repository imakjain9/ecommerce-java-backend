package com.ecommerce.services;

import com.ecommerce.dto.CustomerRegisterDTO;
import com.ecommerce.entity.Customer;
import com.ecommerce.entity.User;
import com.ecommerce.repository.CustomerRepository;
import com.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private UserRepository userRepository;

    public Long register(CustomerRegisterDTO customerRegisterDTO){
        User user = userRepository.getUser(customerRegisterDTO.getRegistered_user());
        Customer customer=new Customer();
        customer.setId(customerRegisterDTO.getId());
        customer.setCustomer_name(customerRegisterDTO.getCustomer_name());
       // System.out.println(customerRegisterDTO.getCustomer_email());
        customer.setCustomer_email(customerRegisterDTO.getCustomer_email());
        customer.setCustomer_address(customerRegisterDTO.getCustomer_address());
        customer.setCustomer_phone(customerRegisterDTO.getCustomer_phone());
        customer.setCustomer_type(customerRegisterDTO.getCustomer_type());
        customer.setRegistered_user(user);
        customerRepository.addCustomer(customer);
        return user.getId();
    }

    public List<Customer> getCustomerList(){
        return  customerRepository.customerList();
    }
}
