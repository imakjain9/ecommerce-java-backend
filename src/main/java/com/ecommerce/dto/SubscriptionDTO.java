package com.ecommerce.dto;

import java.util.Date;

public class SubscriptionDTO {
    private Long customer_id;
    private Long itemId;
    private Double quantity;
    private Double price;
    private  String subscriptionName;
    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() { return price; }

    public void setPrice(Double price) { this.price = price; }

    public String getSubscriptionName() {
        return subscriptionName;
    }

    public void setSubscriptionName(String subscriptionName) {
        this.subscriptionName = subscriptionName;
    }
}
