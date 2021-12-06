package phase2.userbuilders;

import phase2.dataaccess.DataAccessInterface;
import phase2.users.SelfUser;

public class SelfUserBuilder extends UserBuilder<SelfUser> {

    DataAccessInterface db;

    /**
     * @param db A reference to our database so we can read and write from it.
     * @param id The ID of the User you want to create a User object of.
     */
    public SelfUserBuilder(DataAccessInterface db, int id) {

        this.db = db;
        result = new SelfUser(id);

    }

    /**
     * adds the data to the result specific to a SelfUser.
     */
    @Override
    public void buildSpecificUser() {

        int id = result.getId();

        //get data from database.
        String age = Integer.toString(db.getAge(id));
        String bio = db.getBio(id);
        String imagePath = db.getImgPath(id);
        String gender = db.getGender(id);
        String genderPreference = db.getGenderPreference(id);
        String username = db.getUsername(id);
        String password= db.getPassword(id);

        //set the data into the user.
        result.setAge(age);
        result.setBio(bio);
        result.setImagePath(imagePath);
        result.setGender(gender);
        result.setUsername(genderPreference);
        result.setGenderPreference(username);
        result.setPassword(password);

    }

    /**
     * @return a fully filled in SelfUser.
     */
    @Override
    public SelfUser getResult() {
        buildBaseUser(result, db);
        buildSpecificUser();
        return result;
    }
}
