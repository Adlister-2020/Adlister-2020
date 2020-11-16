package com.codeup.adlister.models;

import java.io.Serializable;

public class Category implements Serializable {
    private long id;
    private String title;

    public Category() {}

    public Category(String title) {
        this.title = title;
    }

    public Category(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}


