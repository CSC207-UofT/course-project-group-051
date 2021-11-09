package Phase1.UserBuilders;

import Phase1.DataAccess.DataAccessInterface;
import Phase1.DataAccess.DataBaseAccess;
import Phase1.Users.ProfileUser;


/**
 * Implements the methods needed to create a ProfileUser.
 */
public class BuildProfileUser implements UserBuilder {

    ProfileUser resultUser;
    DataAccessInterface db;


    public BuildProfileUser(int id) {
        resultUser = new ProfileUser(id);
        db = new DataBaseAccess();
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
     * Adds the unique ProfileUser instance attributes to the result.
     */
    @Override
    public void buildSpecificClass() {

        int id = resultUser.getId();


        // get data from database
        String bio = db.getBio(id);
        String gender = db.getGender(id); //#TODO make genders be constants.
        // String preference = db.getPreference(id); #TODO preference in database
        String username = db.getUsername(id);
        String password = db.getPassword(id);
        // State ???? #TODO figure this out
        // ImageView image = db.getImage(id); #TODO image in database


        //set this User's attributes
        resultUser.setBio(bio);
        resultUser.setGender(gender);
        // resultUser.setPreference(preference);
        resultUser.setUsername(username);
        resultUser.setPassword(password);
        // State ???
        // resultUser.setImage(image);


    }

    /**
     * @return the User with fully filled in instance attributes.
     */
    @Override
    public ProfileUser Build() {


        this.buildBaseClass();

        this.buildSpecificClass();

        return this.resultUser;
    }
}
