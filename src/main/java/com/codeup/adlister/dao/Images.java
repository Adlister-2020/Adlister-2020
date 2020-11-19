package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Image;
import java.util.List;

public interface Images {
    List <Image> all();
    Image getImageById(Long imageId);
    void deleteImage (Image image);
}
