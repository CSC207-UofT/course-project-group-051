package phase2.usecase;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class ErrorBuilder {

    public static Text build(ArrayList<String> errors) {
        Text e_message = new Text();
        e_message.setFill(Color.RED);
        StringBuilder final_error = new StringBuilder();
        if (!errors.isEmpty()) {
            for (String x : errors) {
                final_error.append("\n").append(x);
            }
            final_error.append("\n").append("Please try again.");
        }
        e_message.setText(final_error.toString());
        return e_message;
    }


}
