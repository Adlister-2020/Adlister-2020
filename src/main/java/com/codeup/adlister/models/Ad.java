package com.codeup.adlister.models;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;

import com.codeup.adlister.dao.DaoFactory;

public class Ad implements Serializable {
    private long id;
    private long userId;
    private String title;
    private String description;
    private double price;
    private boolean sold;
    private String location;
    private String creation;
    private java.sql.Timestamp timeStamp;

    public Ad() {}

    // get ad from db
    public Ad(long id, long userId, String title, String description,double price, boolean sold, String location, java.sql.Timestamp created_at) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        setPrice(price);
        this.sold = sold;
        this.location = location;
        this.timeStamp = created_at;
        setCreation();
    }
    // create temp ad
    public Ad(long userId, String title, String description) {
        this.userId = userId;
        this.title = title;
        this.description = description;
    }
    // ideal ad creation
    public Ad(long userId, String title, String description,double price, boolean sold, String location) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        setPrice(price);
        this.sold = sold;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAuthor(){
        return DaoFactory.getUsersDao().findByUserId(this.userId);
    }

    public String getCreation() {
        return creation;
    }
    public void setCreation() {
        Format formatter = new SimpleDateFormat("MMM d, ''yy");
        this.creation = formatter.format(this.timeStamp);
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }
    public List<Image> getImages(){
       return DaoFactory.getImagesDao().imagesByAdId(this.getId());
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = Math.round(price*100)/100.0d;;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
