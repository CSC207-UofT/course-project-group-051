package Phase1.UserBuilders;

import Phase1.DataAccess.*;
import Phase1.Users.*;

/**
 * Implements the methods needed to create a SwipeUser.
 */
public class BuildSwipeUser implements UserBuilder {

    private SwipeUser resultUser;
    private DataAccessInterface db;


    public BuildSwipeUser(int id, DataAccessInterface db) {
        resultUser = new SwipeUser(id);
        this.db = db;
    }

    /**
     * Adds the information from the base User class to the result.
     */
    @Override
    public void buildBaseClass() {

        int id = resultUser.getId();

        // get data from database
        String fName = db.getFirstName(id);
        String lName = db.getLastName(id);
        // Date birthdate = db.getbirthdate(id);


        //set this User's attributes
        resultUser.setfName(fName);
        resultUser.setLName(lName);
        // resultUser.setBirthdate(birthdate);

    }

    /**
     * Adds the unique SwipeUser instance attributes to the result.
     */
    @Override
    public void buildSpecificClass() {

        int id = resultUser.getId();

        //data from database
        int age = calculateAge();
        String gender = db.getGender(id);
        String bio = db.getBio(id);
        //TODO how we get the swiper's ID.

        //Input into the SwipeUser
        resultUser.setAge(age);
        resultUser.setGender(gender);
        resultUser.setBio(bio);
        // TODO: resultUser.setSwiper(swiperID);

    }


    /**
     * Finds the age of the resultUser from the database.
     * @return the Age of the resultUser.
     */
    private int calculateAge() {


        //TODO
        return 5;

    }

    /**
     * @return the User with fully filled in instance attributes.
     */
    @Override
    public SwipeUser buildUser() {

        this.buildBaseClass();

        this.buildSpecificClass();

        return this.resultUser;
    }
}
