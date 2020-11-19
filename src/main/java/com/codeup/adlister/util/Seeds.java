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
                DaoFactory.getUsersDao().insert(seedUser);
            }

        }
        
//      ********** CATEGORIES *********
        DaoFactory.getCategoriesDao().seedCategoriesDb();

//        ********** ADS *********
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
            DaoFactory.getAdsDao().insert(seedAd);
        }

//      ********** AD CATEGORIES *********
        for (int i = 1; i <= DaoFactory.getAdsDao().all().size(); i++) {
            Random rand = new Random();
            int max = DaoFactory.getCategoriesDao().all().size();
            int catId = rand.nextInt(((max - 1) + 1)) + 1;
            DaoFactory.getCategoriesDao().insertToAdCategoryJoinTable((long)i, (long) catId);
        }
    }

//    ********** Images CATEGORIES *********


}
