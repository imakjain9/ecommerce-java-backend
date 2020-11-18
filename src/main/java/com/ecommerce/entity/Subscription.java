package com.ecommerce.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
     private Double price;
    private Double quantity;
    private Date startDate;
    private Boolean active;

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
}
