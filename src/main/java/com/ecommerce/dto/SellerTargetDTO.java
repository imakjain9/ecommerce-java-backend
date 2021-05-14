package com.ecommerce.dto;

public class SellerTargetDTO {

    private Long id;

    private Double targetQuantity;

    private Long itemId;

    private Long sellerId;

    public Double getTargetQuantity() {
        return targetQuantity;
    }

    public void setTargetQuantity(Double targetQuantity) {
        this.targetQuantity = targetQuantity;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }
}
