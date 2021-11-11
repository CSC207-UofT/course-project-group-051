package Phase1.Views;

import Phase1.Users.ProfileUser;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.Effect;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EmptyMainViewBuilder implements SceneBuilder{
    ProfileUser primary;
    HBox hb;
    StackPane sp;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    BorderPane bp;
    VBox v;
    Scene scene;
    Effect effect;
    Text text;


    public EmptyMainViewBuilder(ProfileUser user){
        this.primary = user;
        this.bp = new BorderPane();
        this.sp = new StackPane();
        this.btn1 = new Button("Matches");
        this.btn2 = new Button("Me");
        this.btn3 = new Button("Log Out");
        this.btn4 = new Button("Refresh");
        this.hb = new HBox();
        this.v = new VBox();
        this.text = new Text("There is no user to swipe at the moment,\n" +
                " please refresh or try again later");
    }


    /**
     * Creates the HBoxes necessary for the scene.
     */
    @Override
    public void addHBox() {
        this.bp.setTop(this.hb);
    }


    /** Maps each button to its corresponding eventhandler.
     */


    @Override
    public void addButton() {
        this.v.getChildren().add(btn4);
        this.hb.getChildren().add(btn1);
        this.hb.getChildren().add(btn2);
        this.hb.getChildren().add(btn3);


    }


    public Button getMatches(){
        return this.btn1;
    }

    public Button getLogOut(){
        return this.btn3;
    }

    public Button getMe(){
        return this.btn2;
    }

    public Button getRefresh(){
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
        this.v.setSpacing(30);
        this.hb.setSpacing(30);

    }

    /**
     * Sets the margin of the biggest box in the borderpane.
     */

    public void addbp(){
        this.sp.getChildren().add(this.bp);

    }



    @Override
    public void setMargin() {
        this.bp.setMargin(this.hb, new Insets(40, 20, 0, 70));
        this.bp.setMargin(this.btn1, new Insets(320, 10, 50, 50));
        this.bp.setMargin(this.btn2, new Insets(320, 50, 50, 10));
        this.v.setMargin(this.btn4, new Insets(0, 50, 0, 140));
        this.v.setMargin(this.text, new Insets(150, 50, 0, 65));



    }

    /** Set scene on the stage.
     * @param stage the mainstage where we display the scene.
     */
    @Override
    public void setScene(Stage stage) {
        this.scene = new Scene(this.sp, 350, 490);
        stage.setScene(this.scene);
    }

    public void setText(){
        this.v.getChildren().add(this.text);

    }



    @Override
    public void build(Stage s){
        this.setText();
        this.addButton();
        this.addHBox();
        this.addVBox();
       this.setSpacing();
       this.addbp();
        this.setMargin();
        this.setScene(s);


    }

}

