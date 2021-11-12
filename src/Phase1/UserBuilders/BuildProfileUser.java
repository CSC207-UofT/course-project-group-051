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

    public DataAccessInterface getDB(){
        return this.db;
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
        int age = db.getAge(id);
        String image = db.getImage(id);


        //set this User's attributes
        resultUser.setfName(fName);
        resultUser.setLName(lName);
        resultUser.setAge(age);
        resultUser.setImage(image);

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
        String preference = db.getPreference(id);
        String username = db.getUsername(id);
        String password = db.getPassword(id);
        // State ???? #TODO figure this out


        //set this User's attributes
        resultUser.setBio(bio);
        resultUser.setGender(gender);
        resultUser.setPreference(preference);
        resultUser.setUsername(username);
        resultUser.setPassword(password);
        // State ???


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
