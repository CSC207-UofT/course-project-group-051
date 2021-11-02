package Phase1.Views;

import Phase1.Users.ProfileUser;
import Phase1.Users.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;


public class Session extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Session.class.getResource("hello-view.fxml"));
        SelfViewBuilder cb = new SelfViewBuilder(new ProfileUser(1, "Victor", "Kwan",
                new Date("December,6,1999"), "asd"));
        cb.build(primaryStage, new ArrayList<>());
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}