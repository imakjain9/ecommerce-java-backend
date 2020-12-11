package com.ecommerce.services;

import com.ecommerce.dto.SubscriptionDTO;
import com.ecommerce.entity.Customer;
import com.ecommerce.entity.Item;
import com.ecommerce.entity.Subscription;
import com.ecommerce.repository.CustomerRepository;
import com.ecommerce.repository.ItemRepository;
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


    public void addSubscription(SubscriptionDTO subscriptionDTO ,Long customerId,Long itemId)throws  Exception{
        List<Subscription> sub= subscriptionRepository.getSubscriptionByCustomerAndItem(customerId,itemId);
        if(!sub.isEmpty())
            throw new Exception("Subscription Already Exists");
        Subscription subscription=new Subscription();
        Item item=itemRepository.item(itemId);
        Customer customer=customerRepository.getCustomerById(customerId);
        subscription.setItemId(item);
        subscription.setQuantity(subscriptionDTO.getQuantity());
        subscription.setCustomer_id(customer);
        subscription.setActive(true);
        subscription.setStartDate(new Date());
        String subscriptionName= customer.getCustomer_name()+"_"+item.getName()+"_"+subscriptionDTO.getQuantity()+"_"+item.getPrice();
        subscription.setSubscriptionName(subscriptionName);
        subscription.setPrice(item.getPrice());
        subscriptionRepository.addSubscription(subscription);

    }

    public Subscription getSubscriptionById(Long id){ return  subscriptionRepository.getSubscriptionById(id);}



}
