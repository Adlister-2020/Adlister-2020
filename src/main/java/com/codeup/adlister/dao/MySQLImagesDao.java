package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Image;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLImagesDao implements Images{
    private Connection connection = null;

    public MySQLImagesDao(Config config) {
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
    public List<Image> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM images");
            ResultSet rs = stmt.executeQuery();
            return createImgsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Image getImageById(Long imageId) {
        Image image = null;
        String query = "SELECT * FROM images WHERE id = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, imageId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()){
                image = new Image(
                        rs.getLong("id"),
                        rs.getString("url")
                );
            }
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return image;
    }

    @Override
    public void deleteImage(Image image) {
        String query = "DELETE from images WHERE id = ?";
        try
        {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1,image.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            // log the exception
            throw new RuntimeException("Error creating deleting image", e);
        }
    }

    private List<Image> createImgsFromResults(ResultSet rs) throws SQLException {
        List<Image> images = new ArrayList<>();
        while (rs.next()) {
            images.add(extractImage(rs));
        }
        return images;
    }
    private Image extractImage(ResultSet rs) throws SQLException {
        return new Image(
                rs.getLong("id"),
                rs.getString("url")
        );
    }
}
