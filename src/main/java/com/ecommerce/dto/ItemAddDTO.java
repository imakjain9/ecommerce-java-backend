package com.ecommerce.dto;

public class ItemAddDTO {

    private Long id;
    private  String name;
    private  Double price;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }
}
