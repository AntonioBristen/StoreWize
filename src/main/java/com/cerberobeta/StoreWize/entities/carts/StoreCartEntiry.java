package com.cerberobeta.StoreWize.entities.carts;

import java.util.Date;

public class StoreCartEntiry {
    private int id;
    private Date date;
    private int userId;
    private ProductCartEntity[] products;

    public StoreCartEntiry(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public ProductCartEntity[] getProducts() {
        return products;
    }

    public void setProducts(ProductCartEntity[] products) {
        this.products = products;
    }
}
