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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class RegistrationViewBuilder implements SceneBuilder{
    Scene scene;
    HBox hb1;
    Button bt1;
    BorderPane bp;
    VBox v;
    VBox v1;
    TextField tf;
    TextField tf1;
    PasswordField tf2;
    PasswordField tf3;
    TextField tf4;
    TextField tf5;
    TextField tf6;
    Text message;
    public RegistrationViewBuilder(){
        this.bp = new BorderPane();
        this.message = new Text();
    }

    /**
     * Creates the HBoxes necessary for the scene.
     */
    @Override
    public void addHBox() {
        this.hb1 = new HBox();
    }

    /** Maps each button to its corresponding eventhandler.
     */
    @Override
    public void addButton() {
        this.bt1 = new Button("Log In");
        this.hb1.getChildren().add(bt1);

    }

    public Button getLogIn(){
        return this.bt1;
    }

    /**
     * Creates all the VBoxes necessary for the scene.
     */
    @Override
    public void addVBox() {
        this.v = new VBox();
        this.v1 = new VBox();
    }

    /**
     * Adds textfield to the corresponding box.
     */
    @Override
    public void addTextField() {
        Label label = new Label("Date of Birth(e.g. Dec,6,1999):");
        Label label1 = new Label("Username:");
        Label label2 = new Label("Password:");
        Label label3 = new Label("Confirm Password:");
        Label label4 = new Label("Please enter your profile picture path:");
        Label label5 = new Label("First Name:");
        Label label6 = new Label("Last Name:");
        this.tf = new TextField ();
        this.tf1 = new TextField ();
        this.v.getChildren().addAll(label,
                this.tf);
        this.tf2 = new PasswordField();
        this.tf3 = new PasswordField();
        this.tf4 = new TextField ();
        this.tf5 = new TextField ();
        this.tf6 = new TextField ();
        this.v.getChildren().addAll(label5, this.tf5);
        this.v.getChildren().addAll(label6, this.tf6);
        this.v.getChildren().addAll(label1,
                this.tf1);
        this.v.getChildren().addAll(label2,
                this.tf2);
        this.v.getChildren().addAll(label3, this.tf3);
        this.v.getChildren().addAll(label4, this.tf4);
        this.v1.getChildren().add(this.v);
        this.v1.getChildren().add(this.message);
        this.message.setFont(new Font(20));
        this.message.setFill(Color.RED);
        this.v1.getChildren().add(this.hb1);
    }

    public void editMessage(boolean passwordMessage, boolean accountExists) {
    if (passwordMessage){
        this.message.setText("Your passwords don't match, please try again");
    }
    if (accountExists){
        this.message.setText("Your account already exists in our system. Please log in.");
    }

    }

    public String getDOB(){
        return this.tf.getText();
    }

    public String userName(){
        return this.tf1.getText();
    }

    public String getPassword(){
        return this.tf2.getText();
    }

    public String getPassword1(){
        return this.tf3.getText();
    }

    public String getPicturePath(){
        return this.tf4.getText();
    }

    public String getFirstName(){
        return this.tf5.getText();
    }

    public String getLastName(){
        return this.tf6.getText();
    }

    public void passwordDontMatch(){

        this.editMessage(true, false);
    }

    public void accountExists(){

        this.editMessage(false, true);
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
        this.bp.setCenter(v1);
        this.bp.setMargin(this.v1, new Insets(50, 50, 50, 50));

    }

    /** Set scene on the stage.
     * @param stage the mainstage where we display the scene.
     */
    @Override
    public void setScene(Stage stage) {
        this.scene = new Scene(this.bp, 450, 700);
        stage.setScene(this.scene);
    }

    /** Completes the build of the scene.
     * @param s Primary stage
     */
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
