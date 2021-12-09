package phase2.usecase;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import java.util.List;

/**
 * Provides a method that constructs a list of errors to return to the user when rendering views.
 */
public class ErrorBuilder {

    /**
     * Builds an error message to be displayed based on a given list of error constants.
     * @param errors, a list of strings that represent error constant values.
     * @return An instance of javafx.scene.text.Text which is a combination of all the errors, each on the next line.
     */
    public static Text build(List<String> errors) {
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
