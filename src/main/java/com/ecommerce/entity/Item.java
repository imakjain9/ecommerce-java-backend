package com.ecommerce.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private  String name;
    private  Double price;
    private String url;
    @OneToMany(mappedBy = "itemId",fetch = FetchType.EAGER)
    private Set<SellerTarget> sellerTargets;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public Double getPrice() { return price; }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
