package Phase1.UserBuilders;

import Phase1.DataAccess.*;
import Phase1.Users.*;

/**
 * Implements the methods needed to create a SwipeUser.
 */
public class BuildSwipeUser implements UserBuilder {

    private SwipeUser resultUser;
    private DataAccessInterface db;

    /**
     * Construct an instance of BuildSwipeUser using a unique ID to access other information about the swiper
     * @param id an integer representation of the unique ID of the swiper
     * @param db a variable used to facilitate the implementation of swiping via the DataBase
     */

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

        //set this User's attributes
        resultUser.setfName(fName);
        resultUser.setlName(lName);
    }

    /**
     * Adds the unique SwipeUser instance attributes to the result.
     */
    @Override
    public void buildSpecificClass() {

        int id = resultUser.getId();

        //data from database
        String gender = db.getGender(id);
        String bio = db.getBio(id);
        String imagePath = db.getImgPath(id);
        int age = db.getAge(id);

        //Input into the SwipeUser
        resultUser.setGender(gender);
        resultUser.setBio(bio);
        resultUser.setImagePath(imagePath);
        resultUser.setAge(age);

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
