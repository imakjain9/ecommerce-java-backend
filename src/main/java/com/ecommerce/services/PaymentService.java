package com.ecommerce.services;

import com.ecommerce.dto.PaymentDTO;
import com.ecommerce.entity.Customer;
import com.ecommerce.entity.Payment;
import com.ecommerce.repository.CustomerRepository;
import com.ecommerce.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public void register(PaymentDTO paymentDTO,Long customerId){
        Payment payment=new Payment();
        Customer customer=customerRepository.getCustomerById(customerId);
        payment.setAmount(paymentDTO.getAmount());
        payment.setDate(new Date());
        payment.setCustomer(customer);
        paymentRepository.addPayment(payment);
    }
}
