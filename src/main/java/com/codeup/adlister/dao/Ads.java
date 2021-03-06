package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;


import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();

    // get a list of all the ads with same category
    List<Ad> allAdsByCategory(Category category);

    // insert a new ad and return the new ad's id
    Long insert(Ad ad);

    List<Ad> userAds(Long id);

    // get a specific ad
    Ad getAdById(Long adId);


    void updateAd(int id, String title, String description);

    void destroyAd(int id);

    List<Ad> getAdsBySearch(String search);
    List<Ad> getAdsBySearchAndCategory(String search, Category category);
}
