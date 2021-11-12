package Phase1.UserActions;

import Phase1.DataAccess.DataAccessInterface;
import Phase1.UserBuilders.BuildProfileUser;
import Phase1.Users.ProfileUser;
import javafx.scene.image.Image;

import java.util.Map;

public class ProfileAction implements Transitionable{

    private ProfileUser user;
    private DataAccessInterface db;


    public ProfileAction(int id, DataAccessInterface db) {
        BuildProfileUser builder = new BuildProfileUser(id, db);
        user = builder.buildUser();
        this.db = db;

    }
    private void updateImage(Image image){
        //seperate button that updates the profile picture?
    }


    private void updateProfile(Map<String, String> results){

        // TODO Image here or in the updateImage() method.
        // TODO: ADD CHECKS FOR THE FIELDS - HERE OR DB?
        this.user.setfName(results.get("fName"));
        this.user.setlName(results.get("lName"));
        this.user.setBio(results.get("bio"));
        this.user.setGender(results.get("gender"));
        this.user.setPreference(results.get("preferences"));
        this.user.setAge(Integer.parseInt(results.get("age")));
        this.user.setUsername(results.get("username"));
        this.user.setPassword(results.get("password"));

        int id = user.getId();

        db.setFirstName(id, user.getfName());
        db.setLastName(id, user.getlName());
        db.setBio(id, user.getBio());
        db.setGender(id, user.getGender());
        db.setGenderPreference(id, user.getPreference());
        db.setAge(id, user.getAge());
        db.setUsername(id, user.getUsername());
        db.setPassword(id, user.getPassword());

    }

    public void transition(){}
}
