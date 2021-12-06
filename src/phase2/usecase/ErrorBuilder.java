package phase2.usecase;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class ErrorBuilder {

    public static Text build(ArrayList<String> errors) {
        Text e_message = new Text();
        e_message.setFill(Color.RED);
        String final_error = "";
        if (!errors.isEmpty()) {
            for (String x : errors) {
                final_error = final_error + "\n" + x;
            }
            final_error = final_error + "\n" + "Please try again.";
        }
        e_message.setText(final_error);
        return e_message;
    }


}
