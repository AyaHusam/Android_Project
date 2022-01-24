package com.example.designproject.Domain;

import java.io.Serializable;

public class DomainFashion implements Serializable {
    private String title;
    private String photo;
    private String description;
    private int fee;
    private int numberInCard;

    public DomainFashion(String title, String photo, String description, int fee) {
        this.title = title;
        this.photo = photo;
        this.description = description;
        this.fee = fee;
    }

    public DomainFashion(String title, String photo, String description, int fee, int numberInCard) {
        this.title = title;
        this.photo = photo;
        this.description = description;
        this.fee = fee;
        this.numberInCard = numberInCard;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int getNumberInCard() {
        return numberInCard;
    }

    public void setNumberInCard(int numberInCard) {
        this.numberInCard = numberInCard;
    }
}
