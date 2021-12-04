package phase2.presenters;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class ErrorMessage {

    static Text loginWarning(){
        Text warning = new Text();
        warning.setFill(Color.RED);
        warning.setText("Invalid Credential. Please try again.");
        return warning;
    }

    /**
     * Displays the Path Invalid warning.
     */
    static Text pathInvalid(){
        Text warning = new Text();
        warning.setFill(Color.RED);
        warning.setText("Invalid file path. Please try again.");
        return warning;
    }

    /**
     * Displays password don't match message
     */
    static Text passwordDontMatch(){
        Text warning = new Text();
        warning.setFill(Color.RED);
        warning.setText("Your passwords don't match, please try again");
        return warning;
    }

    /**
     * Displays the message that the account exists
     */
    static Text accountExists(){
        Text warning = new Text();
        warning.setFill(Color.RED);
        warning.setText("Your account already exists in our system. Please log in.");
        return warning;
    }
}
