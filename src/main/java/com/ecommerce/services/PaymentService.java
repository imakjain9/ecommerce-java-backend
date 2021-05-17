package com.ecommerce.services;

import com.ecommerce.dto.BillEntryDTO;
import com.ecommerce.dto.PaymentDTO;
import com.ecommerce.entity.Customer;
import com.ecommerce.entity.Payment;
import com.ecommerce.entity.Subscription;
import com.ecommerce.repository.CustomerRepository;
import com.ecommerce.repository.PaymentRepository;
import com.ecommerce.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private SubscriptionService subscriptionService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    BillService billService;

    public void register(PaymentDTO paymentDTO, Long customerId) {
        Payment payment = new Payment();
        Customer customer = customerRepository.getCustomerById(customerId);
        payment.setAmount(paymentDTO.getAmount());
        payment.setDate(new Date());
        payment.setCustomer(customer);
        paymentRepository.addPayment(payment);
        calPaidUptoAndBalance(customerId, payment);
    }

    private void calPaidUptoAndBalance(Long customerId, Payment payment) {
        List<Subscription> subscriptionList = subscriptionService.getSubscriptionByCustomerId(customerId);
        double amt = 0.0;
        amt = payment.getAmount();
        Iterator<Subscription> subscriptionIterator = subscriptionList.iterator();
        while (subscriptionIterator.hasNext()) {
            Subscription subscription = subscriptionIterator.next();

            BillEntryDTO billEntryDTO = billService.createBillEntryDTO(subscription);
              amt = amt - billEntryDTO.getSubTotal();
            subscription.setBalance(amt);
            subscription.setPaidUpto(new Date());

            if (amt < 0) {
               subscriptionRepository.updateSubscription(subscription);
             break;
        }
          if(amt>0 && subscriptionIterator.hasNext()){
        subscription.setBalance(0);
        }
        subscriptionRepository.updateSubscription(subscription);
    }

}



}
