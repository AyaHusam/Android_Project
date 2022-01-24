package com.example.designproject.Domain;

import java.io.Serializable;

public class DomainCategory {
    private  String title;
    private int photo;
    private String price;

    public DomainCategory(String title, int photo , String price) {
        this.title = title;
        this.photo = photo;
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int  getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
