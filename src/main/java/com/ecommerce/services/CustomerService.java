package com.ecommerce.services;

import com.ecommerce.dto.CustomerRegisterDTO;
import com.ecommerce.entity.Customer;
import com.ecommerce.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public void register(CustomerRegisterDTO customerRegisterDTO){
        customerRepository.addCustomer(customerRegisterDTO);
    }

    public List<Customer> getCustomerList(){
        return  customerRepository.customerList();
    }
}
