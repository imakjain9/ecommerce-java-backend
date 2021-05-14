package com.ecommerce.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

     @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumn(name="customer_id")
    private Customer customer_id;

     @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="itemId")
    private Item itemId;

    private  String subscriptionName;

    @OneToMany(mappedBy = "subscription_id",fetch = FetchType.EAGER)
    private Set<Anomalies> anomalies;

    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private Date paidUpto;

     private Double price;
    private Double quantity;

    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private Date startDate;
    private Boolean active;

    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id;}


    public Item getItemId() {
        return itemId;
    }

    public void setItemId(Item itemId) {
        this.itemId = itemId;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Customer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Customer customer_id) {
        this.customer_id = customer_id;
    }

    public Double getPrice() { return price; }

    public void setPrice(Double price) { this.price = price; }

    public String getSubscriptionName() {
        return subscriptionName;
    }

    public void setSubscriptionName(String subscriptionName) {
        this.subscriptionName = subscriptionName;
    }

    public Set<Anomalies> getAnomalies() {
        return anomalies;
    }

    public void setAnomalies(Set<Anomalies> anomalies) {
        this.anomalies = anomalies;
    }

    public Date getPaidUpto() {
        return paidUpto;
    }

    public void setPaidUpto(Date paidUpto) {
        this.paidUpto = paidUpto;
    }
}
