package com.codeup.adlister.models;


import java.io.Serializable;
import java.util.List;

import com.codeup.adlister.dao.DaoFactory;

public class Ad implements Serializable {
    private long id;
    private long userId;
    private String title;
    private String description;

    public Ad() {}

    public Ad(long id, long userId, String title, String description) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
    }

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

    public List<Image> getImages(){
       return DaoFactory.getImagesDao().imagesByAdId(this.getId());
    }
}
