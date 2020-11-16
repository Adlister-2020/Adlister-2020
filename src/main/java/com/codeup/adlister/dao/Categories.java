package com.codeup.adlister.dao;

import com.codeup.adlister.models.Category;

import java.util.List;

public interface Categories {
    // get a list of all the categories
    List<Category> all();
    // get a Category object by the title
    Category getCategoryByTitle(String cat);

    // insert a new category and return the new category's id
//    Long insert(Category ad);
}
