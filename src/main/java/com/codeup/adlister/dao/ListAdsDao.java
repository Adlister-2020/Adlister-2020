package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;

import java.util.ArrayList;
import java.util.List;

public class ListAdsDao implements Ads {
    private List<Ad> ads;

    public List<Ad> all() {
        if (ads == null) {
            ads = generateAds();
        }
        return ads;
    }

    @Override
    public List<Ad> allAdsByCategory(Category category) {
        return null;
    }

    public Long insert(Ad ad) {
        // make sure we have ads
        if (ads == null) {
            ads = generateAds();
        }
        // we'll assign an "id" here based on the size of the ads list
        // really the dao would handle this
        ad.setId((long) ads.size());
        ads.add(ad);
        return ad.getId();
    }

    @Override
    public Ad getAdById(Long adId) {
        return null;
    }

    @Override
    public List<Ad> getAdsBySearch(String search) {
        return null;
    }

    @Override
    public List<Ad> getAdsBySearchAndCategory(String search, Category category) {
        return null;
    }

    private List<Ad> generateAds() {
        List<Ad> ads = new ArrayList<>();
        return ads;
    }

   public List<Ad> userAds(Long id){
        return null;
    }

    @Override
    public void updateAd(int id, String title, String description) {
    }

    @Override
    public void destroyAd(int id) {

    }
}
