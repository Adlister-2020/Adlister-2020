package com.codeup.adlister.util;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Image;
import com.codeup.adlister.models.User;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Seeds {
//    ************ RUN MIGRATIONS SQL TO DROP TABLE DATA PRIOR TO RUNNING SEEDS ******
    public static void main(String[] args) {
        Faker faker = new Faker();
        System.out.println("SEEDING USERS TO DB");
//      ********** USERS *********
        for (int i = 0; i < 100; i++) {
            User seedUser = new User(
                faker.name().username(),
                faker.internet().emailAddress(),
                "123456"
            );
            if(DaoFactory.getUsersDao().findByUsername(seedUser.getUsername())!=null){
                System.out.println("****CANNOT CREATE USER****");
            }else{
                System.out.print(".");
                DaoFactory.getUsersDao().insert(seedUser);
            }

        }
        System.out.println();
        System.out.println("USERS COMPLETE");

//      ********** CATEGORIES *********
        System.out.println("SEEDING CATEGORIES TO DB");
        DaoFactory.getCategoriesDao().seedCategoriesDb();
        System.out.println();
        System.out.println("CATEGORIES COMPLETE");

//        ********** ADS *********
        System.out.println("SEEDING ADS TO DB");
        for (int i = 1; i <= DaoFactory.getUsersDao().all().size(); i++) {
            Ad seedAd = new Ad (
                i,
                faker.commerce().productName(),
                faker.princessBride().quote(),
                    Double.parseDouble(faker.commerce().price()),
                    false,
                    faker.address().cityName()
            );
            DaoFactory.getAdsDao().insert(seedAd);
            seedAd = new Ad (
                    i,
                    faker.commerce().productName(),
                    faker.backToTheFuture().quote(),
                    Double.parseDouble(faker.commerce().price()),
                    false,
                    faker.address().cityName()
            );
            System.out.print(".");
            DaoFactory.getAdsDao().insert(seedAd);
        }
        System.out.println();
        System.out.println("SEEDING AD CATEGORIES TO DB");
//      ********** AD CATEGORIES *********
        for (int i = 1; i <= DaoFactory.getAdsDao().all().size(); i++) {
            Random rand = new Random();
            int max = DaoFactory.getCategoriesDao().all().size();
            int catId = rand.nextInt(((max - 1) + 1)) + 1;
            System.out.print(".");
            DaoFactory.getCategoriesDao().insertToAdCategoryJoinTable((long)i, (long) catId);
            catId = rand.nextInt(((max - 1) + 1)) + 1;
            DaoFactory.getCategoriesDao().insertToAdCategoryJoinTable((long)i, (long) catId);
        }
        System.out.println();
        System.out.println("ADS COMPLETE");
        //    ********** Images CATEGORIES *********
        System.out.println("SEEDING IMAGES FOR ADS TO DB");

        for (int i = 1; i <= DaoFactory.getAdsDao().all().size(); i++) {
            DaoFactory.getImagesDao().insertToAdImages((long)i, randomImg());
            DaoFactory.getImagesDao().insertToAdImages((long)i, randomImg());
            DaoFactory.getImagesDao().insertToAdImages((long)i, randomImg());
            System.out.print(".");
        }
        System.out.println();
        System.out.println("DONE... EXITING SEEDS");
    }

    public static long randomImg(){
        Faker faker = new Faker();
        List<String> words = new ArrayList<>();
        words.add(faker.commerce().material());
        words.add(faker.animal().name());
        words.add(faker.color().name());
        words.add(faker.ancient().god());
        words.add(faker.dragonBall().character());
        words.add(faker.music().instrument());
        words.add(faker.rickAndMorty().character());
        Random rand = new Random();
        int max = words.size()-1;
        int num = rand.nextInt(((max - 1) + 1)) + 1;
        String randomWord = words.get(num);
        String imageUrl = "https://loremflickr.com/800/600/"+randomWord;
        Image img = new Image(imageUrl);
        return DaoFactory.getImagesDao().insert(img);
    }




}
