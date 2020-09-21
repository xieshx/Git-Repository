package com.neu.pojo;

public class Product {
    private Integer productId;

    private String productName;

    private Double productPrice;

    private Double productMemberPrice;

    private Integer productStock;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Double getProductMemberPrice() {
        return productMemberPrice;
    }

    public void setProductMemberPrice(Double productMemberPrice) {
        this.productMemberPrice = productMemberPrice;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }
}