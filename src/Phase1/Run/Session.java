package Phase1.Run;

import Phase1.Users.ProfileUser;
import Phase1.Views.SwipeViewBuilder;
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
                        "Swann", new Date("July,9,1989"), "afokl");
                u.setBio("Insert your best pickup line");
                 SwipeViewBuilder sb = new SwipeViewBuilder(imageView, u);



                EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        System.out.println("Hello World");
                    }
                };

                ArrayList<EventHandler> list = new ArrayList<>();
                list.add(eventHandler);
                //Adding scene to the stage
                sb.build(stage, list);
                //Displaying the contents of the stage
                stage.show();
            }






    public static void main(String[] args) {
        launch(args);
    }
}