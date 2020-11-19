package com.codeup.adlister.util;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.github.javafaker.Faker;
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
                faker.howIMetYourMother().quote()
            );
            DaoFactory.getAdsDao().insert(seedAd);
            seedAd = new Ad (
                    i,
                    faker.commerce().productName(),
                    faker.backToTheFuture().quote()
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
        }
        System.out.println();
        System.out.println("ADS COMPLETE");
        //    ********** Images CATEGORIES *********
        System.out.println("DONE... EXITING SEEDS");
    }




}
