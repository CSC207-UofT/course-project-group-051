package phase2.usecase;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class ErrorBuilder {
    public final static String Credential_ERROR_1 = "Invalid Credential";
    public final static String FILE_PATH_ERROR = "Invalid image file path";
    public final static String whatever_error = "sadasdas";

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
