package com.cerberobeta.StoreWize.entities.products;

public class Product {

    private Integer id;
    private String title;
    private Integer price;
    private String description;
    private String category;
    private String image;
    private RatingEntity rating;

    public Product()
    {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public RatingEntity getRating() {
        return rating;
    }

    public void setRating(RatingEntity rating) {
        this.rating = rating;
    }
}
