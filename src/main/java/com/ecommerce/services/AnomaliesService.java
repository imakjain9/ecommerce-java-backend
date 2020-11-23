package com.ecommerce.services;

import com.ecommerce.dto.AnomaliesDTO;
import com.ecommerce.entity.Anomalies;
import com.ecommerce.entity.Subscription;
import com.ecommerce.entity.User;
import com.ecommerce.repository.AnomaliesRepository;
import com.ecommerce.repository.CustomerRepository;
import com.ecommerce.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Service
public class AnomaliesService {

    @Autowired
    private AnomaliesRepository anomaliesRepository;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public Long register(AnomaliesDTO anomaliesDTO,Long id) throws Exception{
        Subscription subscription=subscriptionRepository.getSubscriptionById(anomaliesDTO.getSubscription_id());
        Anomalies anomalies=new Anomalies();
        Long userId=customerRepository.getCustomerRegisteredUserId(id);
        anomalies.setSubscription_id(subscription);
        anomalies.setQuantity(anomaliesDTO.getQuantity());
        DateFormat format = new SimpleDateFormat("dd-mm-yyyy", Locale.ENGLISH);
        Date date = format.parse(anomaliesDTO.getDate());
        anomalies.setDate(date);
        anomaliesRepository.addAnomalies(anomalies);
        return userId;
    }
    public Long getSubscriptionCustomerUser(){

        return  null;
    }
}
