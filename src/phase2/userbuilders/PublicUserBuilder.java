package phase2.userbuilders;

import phase2.dataaccess.DataAccessInterface;
import phase2.dataaccess.DataAccessInterface2;
import phase2.users.PublicUser;

import java.util.Map;

/**
 * Provides a streamlined process of creating an OtherUser.
 */
public class PublicUserBuilder implements UserBuilder {


    /**
     * @return a fully filled in PublicUser.
     */
    public PublicUser build(DataAccessInterface2 db, int id) {

        PublicUser publicUser = new PublicUser(id);
        updateUser(db.getUserInfo(id), publicUser);
        return publicUser;

    }
    /**
     * adds data to publicUser.
     */
    public void updateUser(Map<String, String> data, PublicUser publicUser) {
        publicUser.setlName(data.get("lName"));
        publicUser.setfName(data.get("fName"));
        publicUser.setBio(data.get("bio"));
        publicUser.setImagePath(data.get("imgPath"));
        publicUser.setAge(data.get("age"));
        publicUser.setGender(data.get("gender"));
    }

    /**
     * adds the data to the result specific to OtherUser.
     */
//    @Override
//    public void buildSpecificUser() {
//
//        int id = result.getId();
//
//        //get data from database.
//        String age = Integer.toString(db.getAge(id));
//        String bio = db.getBio(id);
//        String imagePath = db.getImgPath(id);
//        String gender = db.getGender(id);
//
//        //set the data into the user.
//        result.setAge(age);
//        result.setBio(bio);
//        result.setImagePath(imagePath);
//        result.setGender(gender);
//
//    }

    /**
     * @return a fully filled in OtherUser.
     */
//    @Override
//    public PublicUser getResult() {
//        buildBaseUser(result, db);
//        buildSpecificUser();
//        return result;
//    }
}
