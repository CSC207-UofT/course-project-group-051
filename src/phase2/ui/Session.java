package phase2.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import phase2.constants.State;
import phase2.constants.States;
import phase2.controllers.ControllerFactory;
import phase2.presenters.LoginView;
import phase2.dataaccess.*;

public class Session extends Application {
    @Override
    public void start(Stage stage) {

        FXMLLoader fxmlLoader = new FXMLLoader(phase2.ui.Session.class.getResource("hello-view.fxml"));
        stage.setTitle("UofT Tinder");

        ControllerFactory.getInstance().setStage(stage);
        LoginView view = new LoginView();
        view.build();
        //stage.setResizable(false);
        stage.show();

        //Adding scene to the stage
        //Displaying the contents of the stage

        //TODO




    }




    public static void main(String[] args) {
        launch(args);
    }
}
