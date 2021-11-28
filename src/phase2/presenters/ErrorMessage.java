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
}
