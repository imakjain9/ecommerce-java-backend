package com.ecommerce.services;

import com.ecommerce.dto.BillEntryDTO;
import com.ecommerce.dto.PaymentDTO;
import com.ecommerce.entity.Customer;
import com.ecommerce.entity.Payment;
import com.ecommerce.entity.Subscription;
import com.ecommerce.repository.CustomerRepository;
import com.ecommerce.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private  SubscriptionService subscriptionService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    BillService billService;

    public void register(PaymentDTO paymentDTO,Long customerId){
        Payment payment=new Payment();
        Customer customer=customerRepository.getCustomerById(customerId);
        payment.setAmount(paymentDTO.getAmount());
        payment.setDate(new Date());
        payment.setCustomer(customer);

        paymentRepository.addPayment(payment);
      //  calPaidUptoAndBalance(customerId,payment);
    }

    private double  calPaidUptoAndBalance(Long customerId,Payment payment){
       List<Subscription> subscriptionList = subscriptionService.getSubscriptionByCustomerId(customerId);
       double balance=0.0;
       double amt=0.0;
        amt=payment.getAmount();
        Iterator<Subscription> subscriptionIterator=subscriptionList.iterator();
        while(subscriptionIterator.hasNext()) {
            BillEntryDTO billEntryDTO = billService.createBillEntryDTO(subscriptionIterator.next());
            amt = amt-billEntryDTO.getSubTotal();
            subscription.setPaidUpto(new Date());
            if(amt<0) {
                subscription.setBalance(amt);
                break;
                //17670<=1000     36<=17670
               // balance = amt-billEntryDTO.getSubTotal() ;                     //balance=1000-36
                //subscription.setPaidUpto(new Date());

               //13-05-2021
               // amt=balance;                                                    //amt=964
            }


        }

        balance= -balance;                                                      //balance=-964
        return balance;
    }

    public double getBalanceByCustomerId(Long customerId){
        return  paymentRepository.getBalanceAmountByCustomerId(customerRepository.getCustomerById(customerId));
    }
}
