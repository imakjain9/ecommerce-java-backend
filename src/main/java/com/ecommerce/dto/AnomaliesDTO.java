package com.ecommerce.dto;

import java.util.Date;

public class AnomaliesDTO {
    private  Long id;
    private  Long subscription_id;
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

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }
}
