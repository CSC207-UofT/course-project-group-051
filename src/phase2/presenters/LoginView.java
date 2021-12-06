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
import phase2.constants.States;
import phase2.controllers.ControllerFactory;
import phase2.controllers.LogInController;
import phase2.dataaccess.DataAccessInterface;

public class LoginView implements View{

    Scene scene;
    HBox hb1;
    Button createAccount;
    Button loginButton;
    BorderPane bp;
    VBox v;
    VBox v1;
    TextField username;
    PasswordField password;
    Label usernameLabel;
    Label passwordLabel;
    Stage stage;
    LogInController controller;

    public LoginView(Text error){
        controller = ControllerFactory.getInstance().getLogInController();
        this.bp = new BorderPane();
        this.createAccount = new Button("Create new account");
        this.loginButton = new Button("Log In");
        this.usernameLabel = new Label("UTorID:");
        this.passwordLabel = new Label("Password:");
        this.username = new TextField ();
        this.password = new PasswordField();
        this.v = new VBox();
        this.v1 = new VBox();
        v1.getChildren().add(error);
        this.hb1 = new HBox();
    }

    public LoginView(){
        controller = ControllerFactory.getInstance().getLogInController();
        this.bp = new BorderPane();
        this.createAccount = new Button("Create new account");
        this.loginButton = new Button("Log In");
        this.usernameLabel = new Label("UTorID:");
        this.passwordLabel = new Label("Password:");
        this.username = new TextField ();
        this.password = new PasswordField();
        this.v = new VBox();
        this.v1 = new VBox();
        this.hb1 = new HBox();
    }

    @Override
    public void build() {
        this.addButton();
        this.addVBox();
        this.addTextField();
        this.addHBox();
        this.setSpacing();
        this.setMargin();
        this.setOnActions();
        this.setScene(controller.getStage());
    }

    private void setOnActions(){
        controller.setTextField(username, password);
        createAccount.setOnAction(controller.register());
        loginButton.setOnAction(controller.login());
    }


    /**
     * Creates the HBoxes necessary for the scene.
     */
    public void addHBox() {
        this.v1.getChildren().add(this.hb1);

    }


    /** Maps each button to its corresponding EventHandler.
     */

    public void addButton() {
        this.hb1.getChildren().add(this.createAccount);
        this.hb1.getChildren().add(this.loginButton);

    }


    /**
     * Creates all the VBoxes necessary for the scene.
     */
    public void addVBox() {

        this.v1.getChildren().add(this.v);
        this.bp.setCenter(v1);
    }


    /**
     * Adds TextField to the corresponding box.
     */
    public void addTextField() {

        this.v.getChildren().addAll(this.usernameLabel, this.username);
        this.v.getChildren().addAll(this.passwordLabel, this.password);
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

        BorderPane.setMargin(this.v1, new Insets(50, 50, 50, 50));

    }

    /** Set scene on the stage.
     * @param stage the MainStage where we display the scene.
     */
    public void setScene(Stage stage) {
        this.scene = new Scene(this.bp, 450, 350);
        stage.setScene(scene);
    }
}
