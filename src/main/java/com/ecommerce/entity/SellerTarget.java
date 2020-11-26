package com.ecommerce.entity;


import javax.persistence.*;

@Entity
public class SellerTarget {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(mappedBy = "userProfessionalDetails")
    private Seller sellerId;

    private  Double targetMilkQuantity;

    public Seller getSellerId() { return sellerId; }

    public void setSellerId(Seller sellerId) { this.sellerId = sellerId; }

    public Double getTargetMilkQuantity() { return targetMilkQuantity; }

    public void setTargetMilkQuantity(Double targetMilkQuantity) { this.targetMilkQuantity = targetMilkQuantity; }
}
