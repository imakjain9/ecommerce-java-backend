package com.ecommerce.entity;


import javax.persistence.*;

@Entity
public class SellerTarget {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
        @ManyToOne
        @JoinColumn(name="sellerId", nullable=false)
    private Seller sellerId;
    @ManyToOne
    @JoinColumn(name="itemId",nullable = false)
    private Item itemId;

    private  Double targetQuantity;

    public Seller getSellerId() { return sellerId; }

    public void setSellerId(Seller sellerId) { this.sellerId = sellerId; }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTargetQuantity() {
        return targetQuantity;
    }

    public void setTargetQuantity(Double targetQuantity) {
        this.targetQuantity = targetQuantity;
    }

    public Item getItemId() {
        return itemId;
    }

    public void setItemId(Item itemId) {
        this.itemId = itemId;
    }
}
