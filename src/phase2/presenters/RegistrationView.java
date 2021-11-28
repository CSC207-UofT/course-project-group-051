package phase2.presenters;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import phase2.controllers.RegistrationController;
import phase2.dataaccess.DataAccessInterface;

import java.util.HashMap;
import java.util.Map;

public class RegistrationView implements View{

    DataAccessInterface db;
    Stage stage;
    HBox hb1;
    Button login;
    Button createAccount;
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
    Label label9;
    TextField tf9;
    ScrollPane sp;


    public RegistrationView(DataAccessInterface db, Stage stage){
        this.db = db;
        this.stage = stage;
        this.bp = new BorderPane();
        this.message = new Text();
        this.hb1 = new HBox();
        this.login = new Button("Log In");
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
        this.label9 = new Label("Bio:");
        this.tf = new TextField (); //BD
        this.tf1 = new TextField (); //userbname
        this.message = new Text();
        this.message.setFont(new Font(15));
        this.sp = new ScrollPane();
        this.tf2 = new PasswordField();//pw
        this.tf3 = new PasswordField();
        this.tf4 = new TextField ();
        this.tf5 = new TextField ();
        this.tf6 = new TextField ();
        this.tf7 = new TextField ();
        this.tf8 = new TextField ();
        this.tf9 = new TextField();
        this.createAccount = new Button("Create Account");
    }

    private void setOnActions(){
        Map<String, TextInputControl> inputs = new HashMap<>();
        inputs.put("birthday", tf);
        inputs.put("username", tf);
        inputs.put("password", tf);
        inputs.put("passwordC", tf);
        inputs.put("profilePic", tf);
        inputs.put("fName", tf);
        inputs.put("lName", tf);
        inputs.put("gender", tf);
        inputs.put("genderPref", tf);
        inputs.put("bio", tf);
        RegistrationController controller = new RegistrationController(db, stage, inputs);
        createAccount.setOnAction(controller.createAccount());
        login.setOnAction(controller.login());
    }

    /**
     * Sets the Vbar policy for the scroll pane.
     */
    public void setSP(){
        this.sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
    }

    /**
     * Creates the HBoxes necessary for the scene.
     */
    public void addHBox() {
        this.v1.getChildren().add(this.hb1);

    }

    public void addButton() {
        this.hb1.getChildren().add(this.login);
        this.hb1.getChildren().add(this.createAccount);

    }

    public void addVBox() {
        this.v1.getChildren().add(this.v);
        this.sp.setContent(this.v1);

    }

    /**
     * Adds textfield to the corresponding box.
     */
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
        this.v.getChildren().addAll(label9, this.tf9);

    }

    /**
     * Adds the message board to the scene
     */
    public void addMessage(){
        this.v1.getChildren().add(this.message);

    }

    /**
     * Sets the message font for the scene
     */
    public void setMessageFont(){
        this.message.setFont(new Font(15));
    }

    /**
     * Sets the message color for the scene
     */
    public void setMessageFill(){
        this.message.setFill(Color.RED);

    }

    /**
     * Sets the spacing for each box.
     */
    public void setSpacing() {

        v.setSpacing(20);
        hb1.setSpacing(50);
        v1.setSpacing(20);
    }

    /**
     * Sets the margin of the biggest box in the borderpane.
     */
    public void setMargin() {
        this.bp.setCenter(this.sp);
        BorderPane.setMargin(this.sp, new Insets(50, 50, 50, 50));

    }

    /** Set scene on the stage.
     */
    public void setScene() {
        Scene scene = new Scene(this.bp, 550, 500);
        stage.setScene(scene);
    }

    /** Displays the success message
     * @param id the ID of the user
     */

    public void success(int id){
        this.message.setFill(Color.GREEN);
        this.message.setText("Sucess! ID: " + Integer.toString(id));
    }

    @Override
    public void build() {
        this.addButton();
        this.addVBox();
        this.addMessage();
        this.addHBox();
        this.setSP();
        this.setMessageFill();
        this.setMessageFont();
        this.addTextField();
        this.setSpacing();
        this.setMargin();
        this.setScene();
    }
}
