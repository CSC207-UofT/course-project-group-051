package Phase1.Views;

import Phase1.Users.ProfileUser;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    HBox hb1;
    StackPane sp;
    HBox hb2;
    Button btn;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Text text1;
    BorderPane bp;
    VBox v;
    ImageView image;
    javafx.scene.text.Text text;
    ProfileUser u;
    public SwipeViewBuilder(ImageView image, ProfileUser u){
        this.bp = new BorderPane();
        this.image = image;
        this.text = new Text(u.getfName() + ", " + Integer.toString(u.getAge()));
        this.text.setFont(Font.font(null, FontWeight.BOLD, 25));
        this.text.setFill(Color.WHITE);
        this.text1 = new Text(u.getBio());
        this.text1.setFont(Font.font(null, FontWeight.BOLD, 10));
        this.text1.setFill(Color.WHITE);
        this.sp = new StackPane();
    }


    /**
     * Creates the HBoxes necessary for the scene.
     */
    @Override
    public void addHBox() {
        this.hb1 = new HBox();
        this.hb2 = new HBox();
    }


    /** Maps each button to its corresponding eventhandler.
     * @param e A list of eventhandlers
     */

    @Override
    public void addButton() {
        this.btn = new Button("<");
        this.btn1 = new Button(">");
        this.btn2 = new Button("Matches");
        this.btn3 = new Button("Log Out");
        this.btn4 = new Button("Me");

        this.hb1.getChildren().add(btn);
        this.hb1.getChildren().add(this.image);
        this.hb1.getChildren().add(btn1);
        this.hb2.getChildren().add(btn2);
        this.hb2.getChildren().add(btn3);
        this.hb2.getChildren().add(btn4);


    }

    /**
     * Creates all the VBoxes necessary for the scene.
     */
    @Override
    public void addVBox() {

        this.v = new VBox();
        v.getChildren().add(this.hb2);
        v.getChildren().add(this.hb1);

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
        v.setSpacing(30);
        hb1.setSpacing(30);
        hb2.setSpacing(this.image.getFitWidth() - 370);
    }

    /**
     * Sets the margin of the biggest box in the borderpane.
     */
    @Override
    public void setMargin() {
        this.bp.setCenter(v);
        this.bp.setLeft(btn);
        this.bp.setRight(btn1);
        this.bp.setMargin(this.btn, new Insets(350, 10, 50, 10));
        this.bp.setMargin(this.btn1, new Insets(350, 10, 50, 10));

        this.bp.setMargin(this.v, new Insets(50, 50, 50, 50));
        this.sp.getChildren().add(this.bp);
        this.sp.getChildren().add(this.text);
        this.sp.getChildren().add(this.text1);

        this.sp.setMargin(this.text, new Insets(this.image.getFitHeight(), this.image.getFitWidth()- 220,
                20, 20 ));
        this.sp.setMargin(this.text1, new Insets(this.image.getFitHeight(), 20,
                20, this.image.getFitWidth()- 220));


    }

    /** Set scene on the stage.
     * @param stage the mainstage where we display the scene.
     */
    @Override
    public void setScene(Stage stage) {
        this.scene = new Scene(this.sp, this.image.getFitWidth() + 150, this.image.getFitHeight() + 190);
        stage.setScene(this.scene);
    }


    @Override
    public void build(Stage s){
        this.addHBox();
        this.addButton();
        this.addVBox();
        this.addTextField();
        this.setSpacing();
        this.setMargin();
        this.setScene(s);


    }

}
