package Phase1.Run;

import Phase1.DataAccess.DataBaseAccess;
import Phase1.EventHandler.EventHandlerMapper;
import Phase1.States.States;
import Phase1.UserActions.Actions;
import Phase1.Users.ProfileUser;
import Phase1.Views.LogInViewBuilder;
import Phase1.Views.RegistrationViewBuilder;
import Phase1.Views.SwipeViewBuilder;
import Phase1.Views.ViewBuilderFactory;
import com.sun.org.apache.bcel.internal.generic.LNEG;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;

import javafx.event.ActionEvent;

import java.io.FileNotFoundException;

import javafx.scene.image.Image;


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


                LogInViewBuilder lb = new ViewBuilderFactory().lBuilder();
                RegistrationViewBuilder rb = new RegistrationViewBuilder();
                lb.build(stage);
                EventHandlerMapper em = new EventHandlerMapper(c, stage, new DataBaseAccess());
                em.mapRegistration(lb, rb);
                em.mapLogIn(lb, rb,null );
                em.mapCreateAccount(rb);
                stage.show();


                //Adding scene to the stage
                //Displaying the contents of the stage

                //TODO




            }




    public static void main(String[] args) {
        launch(args);
    }
}