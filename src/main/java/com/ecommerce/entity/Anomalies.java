package com.ecommerce.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Anomalies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    @ManyToOne
    @JoinColumn(name = "subscription_id",nullable = false)
    private Long subscription_id;
    private Double quantity;
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSubscription_id() {
        return subscription_id;
    }

    public void setSubscription_id(Long subscription_id) {
        this.subscription_id = subscription_id;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
