package com.ecommerce.services;

import com.ecommerce.dto.AnomaliesDTO;
import com.ecommerce.entity.Anomalies;
import com.ecommerce.entity.Subscription;
import com.ecommerce.repository.AnomaliesRepository;
import com.ecommerce.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnomaliesService {

    @Autowired
    private AnomaliesRepository anomaliesRepository;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public void register(AnomaliesDTO anomaliesDTO){
        Subscription subscription=subscriptionRepository.getSubscriptionById(anomaliesDTO.getSubscription_id());
        Anomalies anomalies=new Anomalies();
        anomalies.setId(anomaliesDTO.getId());
        anomalies.setSubscription_id(subscription);
        anomalies.setQuantity(anomaliesDTO.getQuantity());
        anomalies.setDate(anomaliesDTO.getDate());
        anomaliesRepository.addAnomalies(anomalies);
    }
}
