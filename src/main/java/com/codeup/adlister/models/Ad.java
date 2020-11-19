package com.codeup.adlister.models;


import java.io.Serializable;
;
import java.sql.Timestamp;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;

import com.codeup.adlister.dao.DaoFactory;

public class Ad implements Serializable {
    private long id;
    private long userId;
    private long adId;
    private String title;
    private String description;
    private String creation;
    private java.sql.Timestamp timeStamp;

    public Ad() {}

    // get ad from db
    public Ad(long id, long userId, String title, String description,java.sql.Timestamp created_at) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.timeStamp = created_at;
        setCreation();
    }
    // create temp ad
    public Ad(long userId, String title, String description) {
        this.userId = userId;
        this.title = title;
        this.description = description;
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
}
