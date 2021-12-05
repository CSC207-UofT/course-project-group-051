package phase2.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import phase2.constants.State;
import phase2.constants.States;
import phase2.controllers.MainController;
import phase2.presenters.LoginView;
import phase2.dataaccess.*;

public class Session extends Application {
    @Override
    public void start(Stage stage) {

        FXMLLoader fxmlLoader = new FXMLLoader(phase2.ui.Session.class.getResource("hello-view.fxml"));
        stage.setTitle("UofT Tinder");

        //Setting the image view

        //Setting the position of the image
        //imageView.setX(50);
        // imageView.setY(25);

        //setting the fit height and width of the image view
        // imageView.setFitHeight(455);
        //  imageView.setFitWidth(500);

        //Setting the preserve ratio of the image view
        //  imageView.setPreserveRatio(true);
        State.setState(States.LOGGED_OUT);
        DataAccessInterface db = new DataBaseAccess();
        MainController.getInstance().setStage(stage);
        LoginView view = new LoginView();
        view.build();
        stage.setResizable(false);
        stage.show();

        //Adding scene to the stage
        //Displaying the contents of the stage

        //TODO




    }




    public static void main(String[] args) {
        launch(args);
    }
}
