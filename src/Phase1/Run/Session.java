package Phase1.Run;

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
                Image image = new Image(new FileInputStream("C:\\Users\\HP\\Desktop\\myimg.jpg"));

                //Setting the image view
                ImageView imageView = new ImageView(image);

                //Setting the position of the image
                imageView.setX(50);
                imageView.setY(25);

                //setting the fit height and width of the image view
                imageView.setFitHeight(455);
                imageView.setFitWidth(500);

                //Setting the preserve ratio of the image view
                imageView.setPreserveRatio(true);


                ProfileUser u = new ProfileUser(1, "Madeline",
                        "Swann", new Date("July,9,1989"), "afokl", null);
                u.setBio("Insert your best pickup line");
                LogInViewBuilder lb = new ViewBuilderFactory().lBuilder();
                lb.build(stage);


                //Adding scene to the stage
                sb.build(stage);
                //Displaying the contents of the stage

                //TODO




                EventHandler<ActionEvent> SelfProfile = new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        if (c.getState().equals(States.LoggedIn)) {

                        }


                    }
                };

                EventHandler<ActionEvent> Matches = new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        if (c.getState().equals(States.LoggedIn)){

                        }


                    }


                };
                EventHandler<ActionEvent> Messaging = new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        if (c.getState().equals(States.LoggedIn)){

                        }


                    }


                };

                EventHandler<ActionEvent> Send = new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        if (c.getState().equals(States.Messaging)){

                        }


                    }


                };

                EventHandler<ActionEvent> Unmatch = new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        if (c.getState().equals(States.Messaging)){

                        }


                    }


                };

            }




    public static void main(String[] args) {
        launch(args);
    }
}