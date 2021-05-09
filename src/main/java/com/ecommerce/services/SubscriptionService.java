package com.ecommerce.services;

import com.ecommerce.dto.SubscriptionDTO;
import com.ecommerce.entity.Customer;
import com.ecommerce.entity.Item;
import com.ecommerce.entity.SellerTarget;
import com.ecommerce.entity.Subscription;
import com.ecommerce.repository.CustomerRepository;
import com.ecommerce.repository.ItemRepository;
import com.ecommerce.repository.SellerTargetRepository;
import com.ecommerce.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SubscriptionService {

    @Autowired
    SubscriptionRepository subscriptionRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    SellerTargetRepository sellerTargetRepository;
    public void addSubscription(SubscriptionDTO subscriptionDTO ,Long customerId,Long itemId)throws  Exception{
       List<Subscription> subList= subscriptionRepository.getSubscriptionByCustomerAndItem(customerId,itemId);
        if(subList!=null && !subList.isEmpty())
            throw new Exception("Subscription Already Exists");
        Subscription subscription=new Subscription();
        Item item=itemRepository.item(itemId);
        Customer customer=customerRepository.getCustomerById(customerId);
        Double sellerTargetItemQunatity=sellerTargetRepository.sellerTargetItemQunatity(customer.getRegistered_seller().getId(),itemId);
        if(subscriptionDTO.getQuantity()>sellerTargetItemQunatity) {
            throw new Exception("unable to fullfill the Quantity requirement");
        }else{
          SellerTarget sellerTarget=  sellerTargetRepository.getSellerTarget(customer.getRegistered_seller().getId(),itemId);
          sellerTargetRepository.editItemTarget(sellerTarget,sellerTargetItemQunatity-(subscriptionDTO.getQuantity()));
        }
        subscription.setItemId(item);
        subscription.setQuantity(subscriptionDTO.getQuantity());
        subscription.setCustomer_id(customer);
        subscription.setActive(true);
        subscription.setStartDate(new Date());
        subscription.setPaidUpto(subscription.getStartDate());
        String subscriptionName= customer.getCustomer_name()+"_"+item.getName()+"_"+subscriptionDTO.getQuantity()+"_"+item.getPrice();
        subscription.setSubscriptionName(subscriptionName);
        subscription.setPrice(item.getPrice());
        subscriptionRepository.addSubscription(subscription);

    }

    public Subscription getSubscriptionById(Long id){ return  subscriptionRepository.getSubscriptionById(id);}

    public void removeCustomerSubscription(Long itemId,Long customerId){
        Subscription subscription=subscriptionRepository.getSubscriptionByCustomerAndItem(customerId,itemId).get(0);
        subscriptionRepository.removeSubscription(subscription);
    }

    public List<Subscription> getSubscriptionByCustomerId(Long customerId){
       return subscriptionRepository.getSubscriptionByCustomer(customerId);
    }

}
