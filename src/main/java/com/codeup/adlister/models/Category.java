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

    public String getCaplizedFirstLetterTitle() {
        String c = (title != null) ? title.trim() : "";
        String[] words = c.split(" ");
        StringBuilder result = new StringBuilder();
        for (String w : words) {
            result.append(w.length() > 1 ? w.substring(0, 1).toUpperCase() + w.substring(1).toLowerCase() : w.toUpperCase()).append(" ");
        }
        return result.toString().trim();
    }

    public String getPurifiedTitle() {
        String c = (title != null) ? title.trim() : "";
        String[] words = c.split(" ");
        StringBuilder result = new StringBuilder();
        for (String w : words) {
            if (!w.equals("&")) {
                result.append(w.length() > 1 ? w.substring(0, 1).toUpperCase() + w.substring(1).toLowerCase() : w.toUpperCase()).append(" ");
            }
        }
        return result.toString().trim();
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


