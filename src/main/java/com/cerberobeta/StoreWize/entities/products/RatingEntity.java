package com.cerberobeta.StoreWize.entities.products;

public class RatingEntity {
    private String rate;

    private String count;

    public  RatingEntity()
    {

    }
    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
