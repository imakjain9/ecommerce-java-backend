package com.ecommerce.services;

import com.ecommerce.dto.SubscriptionDTO;
import com.ecommerce.entity.*;
import com.ecommerce.repository.CustomerRepository;
import com.ecommerce.repository.ItemRepository;
import com.ecommerce.repository.SellerTargetRepository;
import com.ecommerce.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class SubscriptionService {

    @Autowired
    SubscriptionRepository subscriptionRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BillService billService;

    @Autowired
    SellerTargetRepository sellerTargetRepository;
    public void addSubscription(SubscriptionDTO subscriptionDTO ,Long customerId)throws  Exception{
       List<Subscription> subList= subscriptionRepository.getSubscriptionByCustomer(customerId);
        if(subList!=null && !subList.isEmpty())
            throw new Exception("Subscription Already Exists");
        Subscription subscription=new Subscription();
        Customer customer=customerRepository.getCustomerById(customerId);

        Double sellerTargetItemQunatity=sellerTargetRepository.sellerTargetItemQunatity(customer.getRegistered_seller().getId(),subscriptionDTO.getItemId());
        if(subscriptionDTO.getQuantity()>sellerTargetItemQunatity) {
            throw new Exception("unable to fullfill the Quantity requirement");
        }else{
          SellerTarget sellerTarget=  sellerTargetRepository.getSellerTarget(customer.getRegistered_seller().getId(),subscriptionDTO.getItemId());
          sellerTargetRepository.editItemTarget(sellerTarget,sellerTargetItemQunatity-(subscriptionDTO.getQuantity()));
        }
        subscription.setItemId(itemRepository.item(subscriptionDTO.getItemId()));
        subscription.setQuantity(subscriptionDTO.getQuantity());
        subscription.setCustomer_id(customer);
        subscription.setActive(true);
        subscription.setStartDate(new Date());
        subscription.setPaidUpto(subscription.getStartDate());
        String subscriptionName= customer.getCustomer_name()+"_"+itemRepository.item(subscriptionDTO.getItemId()).getName()+"_"+subscriptionDTO.getQuantity()+"_"+itemRepository.item(subscriptionDTO.getItemId()).getPrice();
        subscription.setSubscriptionName(subscriptionName);
        subscription.setPrice(itemRepository.item(subscriptionDTO.getItemId()).getPrice());
        subscriptionRepository.addSubscription(subscription);

    }

    public Subscription getSubscriptionById(Long id){ return  subscriptionRepository.getSubscriptionById(id);}

    public void removeCustomerSubscription(Long subscription){
        Subscription sub=subscriptionRepository.getSubscriptionById(subscription);
        System.out.println(sub.getBalance());
        billService.createBillEntryDTO(sub);
        System.out.println(sub.getBalance());
      subscriptionRepository.removeSubscription(sub);
    }

    public List<Subscription> getSubscriptionByCustomerId(Long customerId){
       return subscriptionRepository.getSubscriptionByCustomer(customerId);
    }

}
