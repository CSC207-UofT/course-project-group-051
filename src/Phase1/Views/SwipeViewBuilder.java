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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class SwipeViewBuilder implements SceneBuilder{
    Scene scene;
    HBox hb;
    StackPane sp;
    Button btn;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Text text1;
    BorderPane bp;
    VBox v;
    ImageView image;
    SwipeUser u;
    HBox hb2;
    Label fnameage;
    Label bio;


    public SwipeViewBuilder(ImageView image, SwipeUser u) {
        this.bp = new BorderPane();
        this.image = image;
        this.image.setFitHeight(500);
        this.image.setFitWidth(500);
        this.sp = new StackPane();
        this.btn = new Button("<");
        this.btn1 = new Button(">");
        this.btn2 = new Button("Matches");
        this.btn3 = new Button("Log Out");
        this.btn4 = new Button("Me");
        this.hb = new HBox();
        this.v = new VBox();
        this.u = u;
        this.hb2 = new HBox();
        this.fnameage = new Label(u.getfName() + ", " + Integer.toString(u.getAge()));
        this.fnameage.setFont(new Font(20));
        this.fnameage.setStyle("-fx-background-color: lightblue; -fx-background-radius: 10;"
        );
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


    /** Maps each button to its corresponding eventhandler.
     */

    public void addImage(){
        this.sp.getChildren().add(this.image);
    }

    @Override
    public void addButton() {
        this.bp.setLeft(btn);
        this.bp.setRight(btn1);
        this.hb.getChildren().add(btn2);
        this.hb.getChildren().add(btn3);
        this.hb.getChildren().add(btn4);


    }

    public Button getLeft(){
        return this.btn;
    }

    public Button getRight(){
        return this.btn1;
    }

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
        this.hb2.setSpacing(50);
    }

    /**
     * Sets the margin of the biggest box in the borderpane.
     */

    public void addsp(){
        this.bp.setCenter(this.sp);

    }

    public void addchildsp(){
        this.sp.getChildren().add(this.fnameage);
        this.sp.getChildren().add(this.bio);

    }
    @Override
    public void setMargin() {
        this.bp.setMargin(this.hb, new Insets(40, 20, 0, 150));
        this.bp.setMargin(this.btn, new Insets(320, 10, 50, 50));
        this.bp.setMargin(this.btn1, new Insets(320, 50, 50, 10));

        this.bp.setMargin(this.v, new Insets(50, 50, 50, 50));

        this.bp.setMargin(this.hb2, new Insets(0, 50,
                50, this.image.getFitWidth()/2 ));

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
        this.scene = new Scene(this.bp, this.image.getFitWidth() + 250, this.image.getFitHeight() + 190);
        stage.setScene(this.scene);
    }



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
