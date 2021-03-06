package com.ecommerce.services;

import com.ecommerce.dto.CustomerRegisterDTO;
import com.ecommerce.entity.Customer;
import com.ecommerce.entity.Payment;
import com.ecommerce.entity.Seller;
import com.ecommerce.entity.Subscription;
import com.ecommerce.repository.CustomerRepository;
import com.ecommerce.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private SellerRepository sellerRepository;

    public Long register(CustomerRegisterDTO customerRegisterDTO){
        Seller seller = sellerRepository.getUser(customerRegisterDTO.getRegistered_user());
        Customer customer=new Customer();
        customer.setId(customerRegisterDTO.getId());
        customer.setCustomer_name(customerRegisterDTO.getCustomer_name());
       // System.out.println(customerRegisterDTO.getCustomer_email());
        customer.setCustomer_email(customerRegisterDTO.getCustomer_email());
        customer.setCustomer_address(customerRegisterDTO.getCustomer_address());
        customer.setCustomer_phone(customerRegisterDTO.getCustomer_phone());
        customer.setCustomer_type(customerRegisterDTO.getCustomer_type());
        customer.setRegistered_seller(seller);
        customerRepository.addCustomer(customer);
        return seller.getId();
    }

    public List<Customer> getCustomerList(){
        return  customerRepository.customerList();
    }

    public Customer getCustomerById(Long id){ return  customerRepository.getCustomerById(id);}

    public Set<Subscription> getCustomerSubscriptions(Long id){
        return  customerRepository.getCustomerSubscriptions(id);
    }

    public Long getRegisteredUser(Long id){
        return customerRepository.getCustomerRegisteredUserId(id);
    }

    public Long getCustomerIdByCustomerName(String customerName){
        return customerRepository.getIdByCustomerName(customerName);
    }

    public Set<Payment> getPaymentListByCustomerId(Long customerId){
         Customer customer=customerRepository.getCustomerById(customerId);
        return customer.getPayments();
    }
}
