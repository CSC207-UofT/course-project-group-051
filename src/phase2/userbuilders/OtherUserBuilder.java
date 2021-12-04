package phase2.userbuilders;

import phase2.dataaccess.DataAccessInterface;
import phase2.users.OtherUser;

/**
 * Provides a streamlined process of creating an OtherUser.
 */
public class OtherUserBuilder extends UserBuilder<OtherUser> {

    DataAccessInterface db;
    OtherUser result;

    /**
     * @param db A reference to our database so we can read and write from it.
     * @param id The ID of the User you want to create a User object of.
     */
    public OtherUserBuilder(DataAccessInterface db, int id) {

        this.db = db;
        result = new OtherUser(id);

    }

    /**
     * adds the data to the result specific to OtherUser.
     */
    @Override
    public void buildSpecificUser() {

        int id = result.getId();

        //get data from database.
        String age = Integer.toString(db.getAge(id));
        String bio = db.getBio(id);
        String imagePath = db.getImgPath(id);
        String gender = db.getGender(id);

        //set the data into the user.
        result.setAge(age);
        result.setBio(bio);
        result.setImagePath(imagePath);
        result.setGender(gender);

    }

    /**
     * @return a fully filled in OtherUser.
     */
    @Override
    public OtherUser getResult() {
        buildBaseUser(result, db);
        buildSpecificUser();
        return result;
    }
}
