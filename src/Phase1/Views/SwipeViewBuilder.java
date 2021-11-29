package Phase1.Views;

import Phase1.States.SelfProfile;
import Phase1.Users.ProfileUser;
import Phase1.Users.SwipeUser;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * The builder for Swiping view
 */
public class SwipeViewBuilder implements SceneBuilder{
    Scene scene;//the scene object
    HBox hb;//the hb containing the buttons
    StackPane sp;//the stack pane for the photo, first name and bio
    Button btn;//the Nah button
    Button btn1;//the yes button
    Button btn2;//the matches button
    Button btn3;//the log out button
    Button btn4;//the me button
    BorderPane bp;//the borderpane containing the vbox
    VBox v; // the vbox containing the scroll pane
    ImageView image;// the profile Image View of the swipeuser
    SwipeUser u;//the swipeuser
    HBox hb2;//the second horizontal box
    Label fnameage; //
    Label bio;

    /**
     * @param image the image of SwipeUser
     * @param u the SwipeUser
     */


    public SwipeViewBuilder(ImageView image, SwipeUser u) {
        this.bp = new BorderPane();
        this.image = image;
        this.image.setFitHeight(500);
        this.image.setFitWidth(500);
        this.sp = new StackPane();
        this.btn = new Button("Nah");
        this.btn1 = new Button("Like");
        this.btn2 = new Button("Matches");
        this.btn3 = new Button("Log Out");
        this.btn4 = new Button("Me");
        this.hb = new HBox();
        this.v = new VBox();
        this.u = u;
        this.hb2 = new HBox();
        this.fnameage = new Label(u.getfName() + ", " + Integer.toString(u.getAge()));
        this.fnameage.setMinWidth(Region.USE_PREF_SIZE);
        this.fnameage.setFont(new Font(20));
        this.fnameage.setStyle("-fx-background-color: lightblue; -fx-background-radius: 10;"
        );
        this.image.setFitHeight(500);
        this.image.setFitHeight(500);
       this.bio = new Label(u.getBio());
        this.bio.setStyle("-fx-background-color: lightblue; -fx-background-radius: 10;"
        );


    }

    /**
     * Creates the HBoxes necessary for the scene.
     */
    @Override
    public void addHBox() {
        this.bp.setTop(this.hb);
        this.bp.setBottom(this.hb2);
    }


    /**
     * Adds the imageview to the view.
     */
    public void addImage(){
        this.sp.getChildren().add(this.image);
    }

    /** Adds the buttons to the scene
     */
    @Override
    public void addButton() {
        this.bp.setLeft(btn);
        this.bp.setRight(btn1);
        this.hb.getChildren().add(btn2);
        this.hb.getChildren().add(btn3);
        this.hb.getChildren().add(btn4);


    }

    /**
     * @return the swipe left button.
     */

    public Button getLeft(){
        return this.btn;
    }

    /**
     * @return the swipe right button.
     */
    public Button getRight(){
        return this.btn1;
    }

    /**
     * @return the matches button.
     */
    public Button getMatches(){
        return this.btn2;
    }

    public Button getLogOut(){
        return this.btn3;
    }

    public Button getMe(){
        return this.btn4;
    }

    /**
     * Creates all the VBoxes necessary for the scene.
     */
    @Override
    public void addVBox() {
        this.bp.setCenter(v);

    }



    /**
     * Adds textfield to the corresponding box.
     */
    @Override
    public void addTextField() {
    }

    /**
     * Sets the spacing for each box.
     */
    @Override
    public void setSpacing() {

        hb.setSpacing(this.image.getFitWidth() / 4);
    }

    /**
     * Sets the margin of the biggest box in the borderpane.
     */

    public void addsp(){
        this.bp.setCenter(this.sp);

    }

    /**
     * Adds the text elements to the Scrollpane.
     */
    public void addchildsp(){
        this.sp.getChildren().add(this.fnameage);
        this.sp.getChildren().add(this.bio);

    }

    /**
     * Sets the margin for the view.
     */
    @Override
    public void setMargin() {
        this.bp.setMargin(this.hb, new Insets(40, 20, 0, 150));
        this.bp.setMargin(this.btn, new Insets(320, 10, 50, 50));
        this.bp.setMargin(this.btn1, new Insets(320, 50, 50, 10));

        this.bp.setMargin(this.v, new Insets(50, 50, 50, 50));

        this.sp.setMargin(this.fnameage, new Insets(this.image.getFitHeight()*0.75, this.image.getFitWidth()*7/8,
                50, this.image.getFitWidth()/8));
        this.sp.setMargin(this.bio, new Insets(this.image.getFitHeight()*0.88, this.image.getFitWidth()*7/8,
                50, this.image.getFitWidth()*1/8));
        this.hb2.setAlignment(Pos.BASELINE_LEFT);


    }

    /** Set scene on the stage.
     * @param stage the mainstage where we display the scene.
     */
    @Override
    public void setScene(Stage stage) {
        this.scene = new Scene(this.bp, this.image.getFitWidth() + 300, this.image.getFitHeight() + 250);
        stage.setScene(this.scene);
    }


    /** Builds the view on given stage
     * @param s the main stage.
     */
    @Override
    public void build(Stage s){
        this.addButton();
        this.addImage();
        this.addHBox();
        this.addVBox();
        this.addTextField();
        this.setSpacing();
        this.addchildsp();
        this.addsp();
        this.setMargin();
        this.setScene(s);


    }

}
