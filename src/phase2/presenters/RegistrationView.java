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
import phase2.constants.UserInfoConstants;
import phase2.controllers.ControllerFactory;
import phase2.controllers.RegistrationController;

import java.util.HashMap;
import java.util.Map;

public class RegistrationView implements View{

    final HBox hb1;
    final Button back;
    final Button createAccount;
    final BorderPane bp;
    final VBox v;
    final VBox v1;
    final TextField tf;
    final TextField tf1;
    final PasswordField tf2;
    final PasswordField tf3;
    final TextField tf5;
    final TextField tf6;
    final TextField tf7;
    final TextField tf8;
    Text message;
    final Label label;
    final Label label1;
    final Label label2;
    final Label label3;
    final Label label5;
    final Label label6;
    final Label label7;
    final Label label8;
    final ScrollPane sp;
    final RegistrationController controller;


    public RegistrationView(Text error){
        controller = ControllerFactory.getInstance().getRegistrationController();
        this.bp = new BorderPane();
        this.message = new Text();
        this.hb1 = new HBox();
        this.back = new Button("Back");
        this.v = new VBox();
        this.v1 = new VBox();
        this.label = new Label("Age");
        this.label1 = new Label("UTorID:");
        this.label2 = new Label("Password:");
        this.label3 = new Label("Confirm Password:");
        this.label5 = new Label("First Name:");
        this.label6 = new Label("Last Name:");
        this.label7 = new Label("Gender:");
        this.label8 = new Label("Gender Preference:");
        this.tf = new TextField (); //BD
        this.tf1 = new TextField (); //username
        this.message = new Text();
        this.message.setFont(new Font(15));
        this.sp = new ScrollPane();
        this.tf2 = new PasswordField();//pw
        this.tf3 = new PasswordField();
        this.tf5 = new TextField ();
        this.tf6 = new TextField ();
        this.tf7 = new TextField ();
        this.tf8 = new TextField ();
        this.createAccount = new Button("Create Account");
        this.v1.getChildren().add(error);
    }


    public RegistrationView(){
        controller = ControllerFactory.getInstance().getRegistrationController();
        this.bp = new BorderPane();
        this.message = new Text();
        this.hb1 = new HBox();
        this.back = new Button("Back");
        this.v = new VBox();
        this.v1 = new VBox();
        this.label = new Label("Age");
        this.label1 = new Label("UTorID:");
        this.label2 = new Label("Password:");
        this.label3 = new Label("Confirm Password:");
        this.label5 = new Label("First Name:");
        this.label6 = new Label("Last Name:");
        this.label7 = new Label("Gender:");
        this.label8 = new Label("Gender Preference:");
        this.tf = new TextField (); //BD
        this.tf1 = new TextField (); //username
        this.message = new Text();
        this.message.setFont(new Font(15));
        this.sp = new ScrollPane();
        this.tf2 = new PasswordField();//pw
        this.tf3 = new PasswordField();
        this.tf5 = new TextField ();
        this.tf6 = new TextField ();
        this.tf7 = new TextField ();
        this.tf8 = new TextField ();
        this.createAccount = new Button("Create Account");

    }


    /**
     * Names the TextFields and sets the button actions.
     */
    private void setOnActions(){
        Map<String, TextInputControl> inputs = new HashMap<>();
        inputs.put(UserInfoConstants.AGE, tf);
        inputs.put(UserInfoConstants.UT_ID, tf1);
        inputs.put(UserInfoConstants.PASSWORD, tf2);
        inputs.put(UserInfoConstants.PASSWORD_C, tf3);
        inputs.put(UserInfoConstants.FIRST_NAME, tf5);
        inputs.put(UserInfoConstants.LAST_NAME, tf6);
        inputs.put(UserInfoConstants.GENDER, tf7);
        inputs.put(UserInfoConstants.GENDER_PREFERENCE, tf8);
        createAccount.setOnAction(controller.createAccount(inputs));
        back.setOnAction(controller.back());

    }


    /**
     * Sets the VBar policy for the scroll pane.
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
        this.hb1.getChildren().add(this.back);
        this.hb1.getChildren().add(this.createAccount);

    }


    public void addVBox() {
        this.v1.getChildren().add(this.v);
        this.sp.setContent(this.v1);

    }


    /**
     * Adds TextField to the corresponding box.
     */
    public void addTextField() {

        this.v.getChildren().addAll(label, this.tf);
        this.v.getChildren().addAll(label1, this.tf1);
        this.v.getChildren().addAll(label2, this.tf2);
        this.v.getChildren().addAll(label3, this.tf3);
        this.v.getChildren().addAll(label5, this.tf5);
        this.v.getChildren().addAll(label6, this.tf6);
        this.v.getChildren().addAll(label7, this.tf7);
        this.v.getChildren().addAll(label8, this.tf8);

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

    /**
     * Set scene on the stage.
     */
    public void setScene() {
        Scene scene = new Scene(this.bp, 550, 500);
        controller.getStage().setScene(scene);
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
        setOnActions();
        this.setScene();
    }
}
