package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;
import com.mysql.cj.jdbc.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
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
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    public List<Ad> userAds(Long userId){
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement("SELECT * FROM ads WHERE user_id = " + userId +""); //retrieves ads from specific user
            ResultSet rs = statement.executeQuery();
            return createAdsFromResults(rs);
        } catch(SQLException e){
            throw new RuntimeException("Error retrieving  ads.", e);
        }
    }

    @Override
    public List<Ad> allAdsByCategory(Category category) {
        PreparedStatement stmt = null;
        String query = "SELECT * FROM ads WHERE id IN (SELECT ad_id FROM ad_categories WHERE category_id = " + category.getId() + ");";
        try {
            stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads(user_id, title, description, price, sold, location) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.setDouble(4,ad.getPrice());
            stmt.setBoolean(5,ad.isSold());
            stmt.setString(6,ad.getLocation());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    @Override
    public Ad getAdById(Long adId) {
        Ad ad = null;
        String query = "SELECT * FROM ads WHERE id = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, adId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()){
                ad = new Ad(
                    rs.getLong("id"),
                    rs.getLong("user_id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getDouble("price"),
                    rs.getBoolean("sold"),
                    rs.getString("location"),
                    rs.getTimestamp("created_at")
                );
            }
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return ad;
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description"),
            rs.getDouble("price"),
            rs.getBoolean("sold"),
            rs.getString("location"),
            rs.getTimestamp("created_at")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }

    @Override
    public void updateAd(int id, String title, String description) {
      String query = "UPDATE ads SET title = ?, description = ? WHERE id = ?";
      try {
//          Creating Prepared statement
          PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
//          Set statement parameters
          stmt.setString(1, title);
          stmt.setString(2, description);
          stmt.setLong(3, id);

//          Updating SQL statement
          stmt.executeUpdate();

      } catch (SQLException e) {
          throw new RuntimeException("Error Updating Ad", e);
      }

    }

    @Override
    public void destroyAd(int id) {
        String query = "DELETE from ads WHERE id = ?";
        try
        {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error deleting ad", e);
        }
    }
  
    public List<Ad> getAdsBySearch(String search) {
        PreparedStatement stmt = null;
        String searchTermWithWildcards = "%" + search + "%";
        String query = "SELECT * FROM ads WHERE title LIKE ? || description LIKE ?";
        try {
            stmt = connection.prepareStatement(query);
            stmt.setString(1, searchTermWithWildcards);
            stmt.setString(2, searchTermWithWildcards);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving ads.", e);
        }
    }

    public List<Ad> getAdsBySearchAndCategory(String search, Category category) {
        PreparedStatement stmt = null;
        String searchTermWithWildcards = "%" + search + "%";
        String query = "SELECT * FROM ads WHERE (title LIKE ? || description LIKE ?) AND id IN (SELECT ad_id FROM ad_categories WHERE category_id = " + category.getId() + ");";
        try {
            stmt = connection.prepareStatement(query);
            stmt.setString(1, searchTermWithWildcards);
            stmt.setString(2, searchTermWithWildcards);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving ads.", e);
        }
    }

}
