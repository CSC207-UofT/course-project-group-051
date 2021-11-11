package Phase1.Run;

import Phase1.DataAccess.DataBaseAccess;
import Phase1.EventHandler.EventHandlerFactory;
import Phase1.Users.ProfileUser;
import Phase1.Views.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;


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
                DataBaseAccess db = new DataBaseAccess();


                LogInViewBuilder lb = new ViewBuilderFactory().lBuilder();
                RegistrationViewBuilder rb = new RegistrationViewBuilder();
                lb.getLogIn().setOnAction(EventHandlerFactory.LogInHandler(c, stage, db, lb));
                lb.getCreateAccount().setOnAction(EventHandlerFactory.Registration(c, stage, db));
                lb.build(stage);
               // EmptyMainViewBuilder eb = new EmptyMainViewBuilder(new ProfileUser(15, "Victor",
                 //       "Kwan", new Date("Dec,06,1999"), "os", new ImageView(new Image(new FileInputStream("C:\\Users\\Fei Guan\\OneDrive\\Desktop\\tay.jpg")))));
                //eb.build(stage);
                //sb.build(stage);
                stage.show();


                //Adding scene to the stage
                //Displaying the contents of the stage

                //TODO




            }




    public static void main(String[] args) {
        launch(args);
    }
}