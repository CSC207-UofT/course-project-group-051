package phase2.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextInputControl;
import javafx.stage.Stage;
import phase2.constants.Errors;
import phase2.constants.UserInfoConstants;
import phase2.dataaccess.DataAccessInterface;
import phase2.presenters.ProfileView;
import phase2.presenters.SwipeView;
import phase2.presenters.View;
import phase2.usecase.ErrorBuilder;
import phase2.usecase.ProfileCase;
import phase2.users.SelfUser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * A controller that delegates the task for each button in the profile view.
 */
public class ProfileController extends Controller {

    final SelfUser currentUser;
    EventHandler<ActionEvent> event;

    /**
     * Creates an instance of ProfileController
     *
     * @param db, the data access interface
     * @param stage, the main stage
     * @param currentUser, an instance of selfUser
     */
    public ProfileController(DataAccessInterface db, Stage stage, SelfUser currentUser) {
        super(db, stage);
        this.currentUser = currentUser;
    }

    /**
     * Packages info from selfUser into a map
     * @return info, data from selfUser to be updated in the db
     */
    public Map<String, String> getUserInfo() {
        Map<String, String> info = new HashMap<>();
        info.put(UserInfoConstants.UT_ID, currentUser.getUsername());
        info.put(UserInfoConstants.PASSWORD, currentUser.getPassword());
        info.put(UserInfoConstants.FIRST_NAME, currentUser.getFirstName());
        info.put(UserInfoConstants.LAST_NAME, currentUser.getLastName());
        info.put(UserInfoConstants.AGE, currentUser.getAge());
        info.put(UserInfoConstants.GENDER, currentUser.getGender());
        info.put(UserInfoConstants.GENDER_PREFERENCE, currentUser.getGenderPreference());
        info.put(UserInfoConstants.BIO, currentUser.getBio());
        info.put(UserInfoConstants.IMAGE_PATH, currentUser.getImagePath());
        return info;
    }

    /**
     * @return An EventHandler that returns the SwipeView
     */
    public EventHandler<ActionEvent> back() {
        event = e -> {
            View view = new SwipeView();
            view.build();
        };
        return event;
    }

    /**
     * @return An EventHandler that updates the User in db and currentUser.
     */
    public EventHandler<ActionEvent> save(Map<String, TextInputControl> inputs) {
        event = e -> {
            List<String> errors = new ArrayList<>();
            Map<String, String> info = new HashMap<>();
            info.put(UserInfoConstants.UT_ID, inputs.get("UTorIDT").getText());
            info.put(UserInfoConstants.PASSWORD, inputs.get("passwordT").getText());
            info.put(UserInfoConstants.FIRST_NAME, inputs.get("firstNameT").getText());
            info.put(UserInfoConstants.LAST_NAME, inputs.get("lastNameT").getText());
            info.put(UserInfoConstants.AGE, inputs.get("ageT").getText());
            info.put(UserInfoConstants.GENDER, inputs.get("genderT").getText());
            info.put(UserInfoConstants.GENDER_PREFERENCE,inputs.get("genderPrefT").getText());
            info.put(UserInfoConstants.BIO, inputs.get("bioT").getText());
            info.put(UserInfoConstants.IMAGE_PATH, inputs.get("imgPathT").getText());
            ProfileCase profileCase = new ProfileCase(db);
            if(info.containsValue("") || info.containsValue(null)){
                errors.add(Errors.MISSING_PROFILE);
            }
            else{
                try {
                    Integer.parseInt(info.get("age"));
                } catch (NumberFormatException io) {
                    errors.add(Errors.AGE);
                }
            }
            try {
                new FileInputStream(info.get("imgPath"));
            } catch (FileNotFoundException io) {
                errors.add(Errors.IMAGE_PATH);
            }

            if (!errors.isEmpty()) {
                View view = new ProfileView(ErrorBuilder.build(errors));
                view.build();
            } else {
                profileCase.updateUser(currentUser.getId(), info);
                View view = new SwipeView();
                view.build();
            }
        };
        return event;
    }

}




