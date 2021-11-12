package Phase1.UserBuilders;

import Phase1.DataAccess.*;
import Phase1.Users.ProfileUser;


/**
 * Implements the methods needed to create a ProfileUser.
 */
public class BuildProfileUser implements UserBuilder {

    private ProfileUser resultUser;
    private DataAccessInterface db;


    public BuildProfileUser(int id, DataAccessInterface db) {
        resultUser = new ProfileUser(id);
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
     * Adds the unique ProfileUser instance attributes to the result.
     */
    @Override
    public void buildSpecificClass() {

        int id = resultUser.getId();


        // get data from database
        String bio = db.getBio(id);
        String gender = db.getGender(id); //#TODO make genders be constants.
        String preference = db.getGenderPreference(id);
        String username = db.getUsername(id);
        String password = db.getPassword(id);


        //set this User's attributes
        resultUser.setBio(bio);
        resultUser.setGender(gender);
        resultUser.setPreference(preference);
        resultUser.setUsername(username);
        resultUser.setPassword(password);


    }

    /**
     * @return the User with fully filled in instance attributes.
     */
    @Override
    public ProfileUser buildUser() {


        this.buildBaseClass();

        this.buildSpecificClass();

        return this.resultUser;
    }
}
