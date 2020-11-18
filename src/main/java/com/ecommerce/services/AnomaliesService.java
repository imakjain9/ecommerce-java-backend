package com.ecommerce.services;

import com.ecommerce.dto.AnomaliesDTO;
import com.ecommerce.entity.Anomalies;
import com.ecommerce.repository.AnomaliesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnomaliesService {

    @Autowired
    private AnomaliesRepository anomaliesRepository;

    public void register(AnomaliesDTO anomaliesDTO){
        Anomalies anomalies=new Anomalies();
        anomalies.setId(anomaliesDTO.getId());
       // anomalies.setSubscription_id();
        anomalies.setQuantity(anomaliesDTO.getQuantity());
        anomaliesRepository.addAnomalies(anomalies);
    }
}
