package Phase1.Views;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 *
 */
public class LogInViewBuilder implements SceneBuilder{
    Scene scene;
    HBox hb1;
    Button bt1;
    Button bt2;
    BorderPane bp;
    VBox v;
    VBox v1;
    TextField tf1;
    PasswordField pf1;
    Label label1;
    Label label2;
    public LogInViewBuilder(){
        this.bp = new BorderPane();
        this.bt1 = new Button("Create new account");
        this.bt2 = new Button("Log In");
        this.label1 = new Label("Username:");
        this.label2 = new Label("Password:");
        this.tf1 = new TextField ();
        this.pf1 = new PasswordField();
        this.v = new VBox();
        this.v1 = new VBox();
        this.hb1 = new HBox();

    }

    /**
     * Creates the HBoxes necessary for the scene.
     */
    @Override
    public void addHBox() {
        this.v1.getChildren().add(this.hb1);

    }


    /** Maps each button to its corresponding eventhandler.
     */

    @Override
    public void addButton() {
        this.hb1.getChildren().add(this.bt1);
        this.hb1.getChildren().add(this.bt2);

    }

    public Button getCreateAccount(){
        return this.bt1;
    }

    public Button getLogIn(){
        return this.bt2;
    }


    /**
     * Creates all the VBoxes necessary for the scene.
     */
    @Override
    public void addVBox() {
        this.v1.getChildren().add(this.v);

        this.bp.setCenter(v1);
    }


    /**
     * Adds textfield to the corresponding box.
     */
    @Override
    public void addTextField() {
        this.v.getChildren().addAll(this.label1,
                this.tf1);
        this.v.getChildren().addAll(this.label2, this.pf1);
    }

    /**
     * Sets the spacing for each box.
     */
    @Override
    public void setSpacing() {

        v.setSpacing(20);
        hb1.setSpacing(50);
        v1.setSpacing(50);
    }

    /**
     * Sets the margin of the biggest box in the borderpane.
     */
    @Override
    public void setMargin() {

        this.bp.setMargin(this.v1, new Insets(50, 50, 50, 50));

    }

    /** Set scene on the stage.
     * @param stage the mainstage where we display the scene.
     */
    @Override
    public void setScene(Stage stage) {
        this.scene = new Scene(this.bp, 450, 300);
        stage.setScene(this.scene);
    }

    @Override
    public void build(Stage s){
        this.addButton();
        this.addVBox();
        this.addTextField();
        this.addHBox();
        this.setSpacing();
        this.setMargin();
        this.setScene(s);
    }

    public TextField getTextbox(){
        return this.tf1;
    }

    public PasswordField getPasswordbox(){
        return this.pf1;
    }

}
