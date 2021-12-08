package phase2.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import phase2.controllers.ControllerFactory;
import phase2.presenters.LoginView;

/** The run page that will display the application
 */
public class Session extends Application {
    @Override
    public void start(Stage stage) {

        new FXMLLoader(phase2.ui.Session.class.getResource("hello-view.fxml"));
        stage.setTitle("UofT Tinder");

        ControllerFactory.getInstance().setStage(stage);
        LoginView view = new LoginView();
        view.build();
        stage.show();

    }




    public static void main(String[] args) {
        launch(args);
    }
}
