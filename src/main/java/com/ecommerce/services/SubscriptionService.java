package com.ecommerce.services;

import com.ecommerce.dto.SubscriptionDTO;
import com.ecommerce.entity.Subscription;
import com.ecommerce.repository.CustomerRepository;
import com.ecommerce.repository.ItemRepository;
import com.ecommerce.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SubscriptionService {

    @Autowired
    SubscriptionRepository subscriptionRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    CustomerRepository customerRepository;
    public void addSubscription(SubscriptionDTO subscriptionDTO){
        Subscription subscription=new Subscription();
        subscription.setItemId( itemRepository.item(subscriptionDTO.getItemId()));
        subscription.setQuantity(subscriptionDTO.getQuantity());
        subscription.setCustomer_id(customerRepository.getCustomerById(subscriptionDTO.getCustomer_id()));
        subscription.setActive(true);
        subscription.setStartDate(new Date());
        subscriptionRepository.addSubscription(subscription);
    }
}
