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
    TextField tf7;
    TextField tf8;

    Text message;
    Label label;
    Label label1;

    Label label2;

    Label label3;
    Label label4;
    Label label5;
    Label label6;
    Label label7;
    Label label8;
    Button btn2;



    public RegistrationViewBuilder(){
        this.bp = new BorderPane();
        this.message = new Text();
        this.hb1 = new HBox();
        this.bt1 = new Button("Log In");
        this.v = new VBox();
        this.v1 = new VBox();
        this.label = new Label("Date of Birth(e.g. Dec,06,1999):");
        this.label1 = new Label("Username:");
        this.label2 = new Label("Password:");
        this.label3 = new Label("Confirm Password:");
        this.label4 = new Label("Please enter your profile picture path(use double backslash as separator):");
        this.label5 = new Label("First Name:");
        this.label6 = new Label("Last Name:");
        this.label7 = new Label("Gender(Male or Female):");
        this.label8 = new Label("Gender Preference:");
        this.tf = new TextField ();
        this.tf1 = new TextField ();

        this.tf2 = new PasswordField();
        this.tf3 = new PasswordField();
        this.tf4 = new TextField ();
        this.tf5 = new TextField ();
        this.tf6 = new TextField ();
        this.tf7 = new TextField ();
        this.tf8 = new TextField ();
        this.btn2 = new Button("Create Account");

    }
    public void pathInvalid(){
        this.message.setFill(Color.RED);
        this.message.setText("Image path invalid. Please try again.");
    }
    /**
     * Creates the HBoxes necessary for the scene.
     */
    @Override
    public void addHBox() {
        this.v1.getChildren().add(this.hb1);

    }
    public void fillIn(){
        this.message.setFill(Color.RED);
        this.message.setText("Please fill in every blank");
    }

    public Button createAccount(){
        return this.btn2;
    }

    /** Maps each button to its corresponding eventhandler.
     */
    @Override
    public void addButton() {
        this.hb1.getChildren().add(this.bt1);
        this.hb1.getChildren().add(this.btn2);

    }

    public Button getLogIn(){
        return this.bt1;
    }

    /**
     * Creates all the VBoxes necessary for the scene.
     */
    @Override
    public void addVBox() {
        this.v1.getChildren().add(this.v);

    }

    /**
     * Adds textfield to the corresponding box.
     */
    @Override
    public void addTextField() {

        this.v.getChildren().addAll(label,
                this.tf);
        this.v.getChildren().addAll(label5, this.tf5);
        this.v.getChildren().addAll(label6, this.tf6);
        this.v.getChildren().addAll(label1,
                this.tf1);
        this.v.getChildren().addAll(label2,
                this.tf2);
        this.v.getChildren().addAll(label3, this.tf3);
        this.v.getChildren().addAll(label4, this.tf4);
        this.v.getChildren().addAll(label7, this.tf7);
        this.v.getChildren().addAll(label8, this.tf8);

    }

    public void addMessage(){
        this.v1.getChildren().add(this.message);

    }

    public void setMessageFont(){
        this.message.setFont(new Font(15));
    }

    public void setMessageFill(){
        this.message.setFill(Color.RED);

    }

    public TextField getDOB(){
        return this.tf;
    }

    public TextField userName(){
        return this.tf1;
    }

    public TextField getPassword(){
        return this.tf2;
    }

    public TextField getPassword1(){
        return this.tf3;
    }

    public TextField getPicturePath(){
        return this.tf4;
    }

    public TextField getFirstName(){
        return this.tf5;
    }

    public TextField getLastName(){
        return this.tf6;
    }

    public TextField getGender(){
        return this.tf7;
    }

    public TextField getPreference   (){
        return this.tf8;
    }

    public void passwordDontMatch(){
        this.message.setFill(Color.RED);
        this.message.setText("Your passwords don't match, please try again");

    }

    public void accountExists(){
        this.message.setFill(Color.RED);
        this.message.setText("Your account already exists in our system. Please log in.");
    }

    /**
     * Sets the spacing for each box.
     */
    @Override
    public void setSpacing() {

        v.setSpacing(20);
        hb1.setSpacing(50);
        v1.setSpacing(20);
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
        this.scene = new Scene(this.bp, 450, 900);
        stage.setScene(this.scene);
    }



    public void success(int id){
        this.message.setFill(Color.GREEN);
        this.message.setText("Sucess! ID: " + Integer.toString(id));
    }

    /** Completes the build of the scene.
     * @param s Primary stage
     */
    @Override
    public void build(Stage s){
        this.addButton();
        this.addVBox();
        this.addMessage();
        this.addHBox();
        this.setMessageFill();
        this.setMessageFont();
        this.addTextField();
        this.setSpacing();
        this.setMargin();
        this.setScene(s);
    }
}
