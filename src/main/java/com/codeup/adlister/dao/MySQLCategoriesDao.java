package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLCategoriesDao implements Categories {
    private Connection connection = null;

    public MySQLCategoriesDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Category> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM categories");
            ResultSet rs = stmt.executeQuery();
            List<Category> categories = new ArrayList<>();
            while (rs.next()) {
                categories.add(new Category(
                        rs.getLong("id"),
                        rs.getString("title")
                ));
            }
            return categories;
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Category getCategoryByTitle(String cat) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM categories WHERE title = ?");
            stmt.setString(1, cat);
            ResultSet rs = stmt.executeQuery();
            Category category = new Category();
            while (rs.next()) {
                category.setId(rs.getLong("id"));
                category.setTitle(rs.getString("title"));
            }
            return category;
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public void insertToAdCategoryJoinTable(Long adId, Long categoryId) {
        try {
            String insertQuery = "INSERT INTO ad_categories(ad_id, category_id) VALUES (?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery);
            stmt.setLong(1, adId);
            stmt.setLong(2, categoryId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad Category.", e);
        }
    }

    @Override
    public List<Category> getCategoriesOfAd(Ad ad) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM categories " +
                    "WHERE id IN " +
                    "(SELECT category_id FROM ad_categories WHERE ad_id = " +ad.getId() + ");");
            ResultSet rs = stmt.executeQuery();
            List<Category> categories = new ArrayList<>();
            while (rs.next()) {
                categories.add(new Category(
                        rs.getLong("id"),
                        rs.getString("title")
                ));
            }
            return categories;
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public void seedCategoriesDb(){
      List<String> seedList = new ArrayList<>();
      seedList.add("Baby & Kids");
      seedList.add("Furniture");
      seedList.add("Clothing");
      seedList.add("Cars & Trucks");
      seedList.add("Electronics");
      seedList.add("Jewelry");
      seedList.add("Appliances");
      seedList.add("Tools");
      seedList.add("Free");
      seedList.add("Pets");

      List<Category> dbList = all();
//      seed full list if database is empty
      if(dbList.size()<1){
        for(String title : seedList){
            insertIntoCategories(title);
        }
//        seed missing categories into database if not empty
      }else{
        for(Category c : dbList){
          for(String title : seedList){
              if(!seedList.contains(c.getTitle())){
                  insertIntoCategories(title);
              }
          }
        }
      }
    }

    @Override
    public long insertIntoCategories(String title){
        try {
            String query = "INSERT INTO categories(title) VALUES (?)";
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1,title);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new category.", e);
        }
    }
}
