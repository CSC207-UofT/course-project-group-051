package Phase1.Run;

import Phase1.DataAccess.DataAccessInterface;
import Phase1.DataAccess.DataBaseAccess;
import Phase1.Views.LogInViewBuilder;
import Phase1.Views.RegistrationViewBuilder;
import Phase1.Views.ViewBuilderFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import java.io.FileNotFoundException;


//public class Session extends Application {
  //@Override
  //public void start(Stage primaryStage) throws IOException {
    //  FXMLLoader fxmlLoader = new FXMLLoader(Session.class.getResource("hello-view.fxml"));
      //primaryStage.setTitle("UofT Tinder");


public class Session extends Application {
            @Override
            public void start(Stage stage) throws FileNotFoundException {
                StateMachine c = new StateMachine();
                //Creating an image
                FXMLLoader fxmlLoader = new FXMLLoader(Session.class.getResource("hello-view.fxml"));
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
                DataAccessInterface db = new DataBaseAccess();
                LogInViewBuilder lb = new ViewBuilderFactory().lBuilder();
                RegistrationViewBuilder rb = new RegistrationViewBuilder();
                lb.getLogIn().setOnAction(Controller.LogInHandler(c, stage, db, lb));
                lb.getCreateAccount().setOnAction(Controller.Registration(c, stage, db));
                lb.build(stage);
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