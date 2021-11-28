package phase2.presenters;

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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import phase2.controllers.LogInController;
import phase2.dataaccess.DataAccessInterface;

public class LoginView implements View{

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
    Text message;
    boolean error;
    DataAccessInterface db;
    Stage stage;

    public LoginView(boolean error, DataAccessInterface db,Stage stage){
        this.db = db;
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
        this.message = new Text();
        this.error = error;
        this.stage = stage;
    }

    @Override
    public void build() {
        if(error){
            this.invalidCredential();
        }
        this.addButton();
        this.addVBox();
        this.addTextField();
        this.addText();
        this.addHBox();
        this.setSpacing();
        this.setMargin();
        this.setScene(stage);
        this.setOnActions();
    }

    private void setOnActions(){
        LogInController controller = new LogInController(db, stage, tf1, pf1);
        bt1.setOnAction(controller.login());
        bt2.setOnAction(controller.register());
    }

    /**
     * Sets the invalid credential message when the credential is invalid.
     */
    public void invalidCredential(){
        this.message.setFill(Color.RED);
        this.message.setText("Invalid Credential. Please try again.");
    }

    /**
     * adds the message to the scene.
     */

    public void addText(){
        this.v1.getChildren().add(this.message);
    }

    /** returns the username inputted in the textfield.
     * @return the username in String.
     */
    public TextField getUserName(){
        return this.tf1;
    }

    /** returns the inputted password in passwordfield.
     * @return the password in String.
     */
    public TextField getPassword(){
        return this.pf1;
    }

    /**
     * Creates the HBoxes necessary for the scene.
     */
    public void addHBox() {
        this.v1.getChildren().add(this.hb1);

    }


    /** Maps each button to its corresponding eventhandler.
     */

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
    public void addVBox() {
        this.v1.getChildren().add(this.v);

        this.bp.setCenter(v1);
    }


    /**
     * Adds textfield to the corresponding box.
     */
    public void addTextField() {
        this.v.getChildren().addAll(this.label1,
                this.tf1);
        this.v.getChildren().addAll(this.label2, this.pf1);
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

        this.bp.setMargin(this.v1, new Insets(50, 50, 50, 50));

    }

    /** Set scene on the stage.
     * @param stage the mainstage where we display the scene.
     */
    public void setScene(Stage stage) {
        this.scene = new Scene(this.bp, 450, 300);
        stage.setScene(this.scene);
    }
}
