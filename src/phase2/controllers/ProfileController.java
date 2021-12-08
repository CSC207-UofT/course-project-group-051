package phase2.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextInputControl;
import javafx.stage.Stage;
import phase2.constants.Errors;
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

public class ProfileController extends Controller {

    SelfUser currentUser;
    Map<String, TextInputControl> inputs;
    EventHandler<ActionEvent> event;
    final public static String[] VALID_MONTH = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug",
            "Sep", "Oct", "Nov", "Dec"};

    public ProfileController(DataAccessInterface db, Stage stage, SelfUser currentUser) {
        super(db, stage);
        this.currentUser = currentUser;
    }

    public Map<String, String> getUserInfo() {
        Map<String, String> info = new HashMap<>();
        info.put("firstName", currentUser.getFirstName());

        info.put("lastName", currentUser.getLastName());

        info.put("age", currentUser.getAge());
        System.out.println(currentUser.getImagePath());
        System.out.println(currentUser.getBio());
        info.put("imgPath", currentUser.getImagePath());
        info.put("gender", currentUser.getGender());
        info.put("genderPref", currentUser.getGenderPreference());
        info.put("UTorID", currentUser.getUsername());
        info.put("bio", currentUser.getBio());
        info.put("password", currentUser.getPassword());
        return info;
    }

    public EventHandler<ActionEvent> back() {
        event = e -> {
            View view = new SwipeView();
            view.build();
        };
        return event;
    }

    public EventHandler<ActionEvent> save(Map<String, TextInputControl> inputs) {
        event = e -> {
            this.inputs = inputs;
            List<String> errors = new ArrayList<>();
            Map<String, String> info = new HashMap<>();
            info.put("uTID", inputs.get("UTorIDT").getText());
            info.put("password", inputs.get("passwordT").getText());
            info.put("firstName", inputs.get("firstNameT").getText());
            info.put("lastName", inputs.get("lastNameT").getText());
            info.put("age", inputs.get("ageT").getText());
            info.put("gender", inputs.get("genderT").getText());
            info.put("genderPref",inputs.get("genderPrefT").getText());
            info.put("bio", inputs.get("bioT").getText());
            info.put("imgPath", inputs.get("imgPathT").getText());
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




