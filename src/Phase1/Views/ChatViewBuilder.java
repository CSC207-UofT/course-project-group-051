package Phase1.Views;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
class ChatViewBuilder implements SceneBuilder{
    String name;
    TextField tf;
    ScrollPane sp;
    HBox hb1;
    HBox hb2;
    BorderPane bp;
    Button send;
    Button unmatch;
    Button ret;
    Scene scene;
    VBox vb;

    public Button getSend(){
        return this.send;
    }

    public Button getUnmatch(){
        return this.unmatch;
    }

    public Button getReturn(){
        return this.ret;
    }
    public ChatViewBuilder(String firstName){
        this.name = firstName;
        this.bp = new BorderPane();
        this.sp = new ScrollPane();
    }


    /**
     * Creates the HBoxes necessary for the scene.
     */
    @Override
    public void addHBox() {
        this.hb1 = new HBox();
        this.hb2 = new HBox();
    }

    @Override
    public void addTextField() {
        this.tf = new TextField();
        this.hb2.getChildren().add(tf);
    }

    /** Maps each button to its corresponding eventhandler.
     */

    @Override
    public void addButton() {
        this.ret = new Button("<");
        this.send = new Button("Send");
        this.unmatch = new Button("Unmatch");

        this.hb1.getChildren().add(ret);
        this.hb1.getChildren().add(new Text(this.name));
        this.hb1.getChildren().add(this.unmatch);
        this.hb2.getChildren().add(send);

    }

    /**
     * Creates all the VBoxes necessary for the scene.
     */
    @Override
    public void addVBox() {
    this.vb = new VBox();
    vb.getChildren().add(this.hb1);
    vb.getChildren().add(this.sp);
    vb.getChildren().add(this.hb2);
    }



    /**
     * Sets the spacing for each box.
     */
    @Override
    public void setSpacing() {

        hb1.setSpacing(30);
        hb2.setSpacing(20);
        vb.setSpacing(50);

    }

    /**
     * Sets the margin of the biggest box in the borderpane.
     */
    @Override
    public void setMargin() {
        this.bp.setCenter(this.vb);

        this.bp.setMargin(this.vb, new Insets(30, 30, 30, 30));

    }

    /** Set scene on the stage.
     * @param stage the mainstage where we display the scene.
     */
    @Override
    public void setScene(Stage stage) {
        this.scene = new Scene(this.bp, 350, 350);
        stage.setScene(this.scene);
    }

    @Override
    public void build(Stage s){
        this.addHBox();
        this.addTextField();
        this.addButton();
        this.addVBox();
        this.setMargin();
        this.setSpacing();
        this.setScene(s);


    }
}
