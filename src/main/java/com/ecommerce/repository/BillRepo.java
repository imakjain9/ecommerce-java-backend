package com.ecommerce.repository;

import com.ecommerce.dto.BillDTO;
import com.ecommerce.dto.BillEntryDTO;
import com.ecommerce.entity.Anomalies;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BillRepo {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public  void  getBill(BillDTO billDTO, BillEntryDTO billEntryDTO, Long customerId){


    }
}
