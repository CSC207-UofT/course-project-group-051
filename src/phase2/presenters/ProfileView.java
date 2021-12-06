package phase2.presenters;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import phase2.controllers.ControllerFactory;
import phase2.controllers.ProfileController;
import phase2.dataaccess.DataAccessInterface;

import java.util.HashMap;
import java.util.Map;


/**
 * The view builder for the user's personal info
 */
public class ProfileView implements View {
    //ProfileUser u;
    int id;
    Scene scene;
    BorderPane bp;
    HBox hb;
    javafx.scene.control.Button back;
    javafx.scene.control.Button save;
    VBox vb;
    Label firstNameL;
    Label lastNameL;
    Label birthdayL;
    Label passwordL;
    Label imgPathL;
    Label genderL;
    Label genderPrefL;
    Label usernameL;
    Label bioL;
    TextField firstNameT;
    TextField lastNameT;
    TextField birthdayT;
    TextField imgPathT;
    TextField genderT;
    TextField genderPrefT;
    TextField usernameT;
    TextField bioT;
    TextField passwordT;
    Text fileError;
    Text dateError;
    ScrollPane sp;
    Stage stage;
    DataAccessInterface db;
    ProfileController controller;

    public ProfileView(Text errors){
        setJavaFX();
        controller = ControllerFactory.getInstance().getProfileController();
        stage = controller.getStage();
        setLabel();
        setText();
        setOnActions();
        this.vb.getChildren().add(errors);

    }

    public ProfileView(){
        setJavaFX();
        controller = ControllerFactory.getInstance().getProfileController();
        stage = controller.getStage();
        setLabel();
        setText();
        setOnActions();

    }

    private void setJavaFX(){
        this.bp = new BorderPane();
        this.sp = new ScrollPane();
        this.back = new Button("Back");
        this.save = new Button("Save");
        this.vb = new VBox();
        this.hb = new HBox();
    }

    private void setLabel(){
        firstNameL = new Label("First Name:");
        lastNameL = new Label("Last Name:");
        birthdayL = new Label("Age:");
        passwordL = new Label("Password:");
        imgPathL = new Label("Profile Image Path:");
        genderL = new Label("Gender:");
        genderPrefL = new Label("Gender Preference:");
        usernameL = new Label("UTorID:");
        bioL = new Label("Bio:");
    }

    private void setText(){
        Map<String, String> info = controller.getUserInfo();
        firstNameT = new TextField(info.get("firstName"));
        lastNameT = new TextField(info.get("lastName"));
        birthdayT = new TextField(info.get("age"));
        passwordT = new TextField(info.get("password"));
        imgPathT = new TextField(info.get("imgPath"));
        genderT = new TextField(info.get("gender"));
        genderPrefT = new TextField(info.get("genderPref"));
        usernameT = new TextField(info.get("UTorID"));
        bioT = new TextField(info.get("bio"));
    }

    /**
     * Sets the scroll pane to the scene
     */

    public void setSP(){
        this.sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        this.sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        this.bp.setCenter(this.sp);

    }

    private void setOnActions(){
        Map<String, TextInputControl> inputs = new HashMap<>();
        inputs.put("firstNameT", firstNameT);
        inputs.put("lastNameT", lastNameT);
        inputs.put("ageT", birthdayT);
        inputs.put("imgPathT", imgPathT);
        inputs.put("genderT", genderT);
        inputs.put("genderPrefT", genderPrefT);
        inputs.put("UtorIDT", usernameT);
        inputs.put("bioT", bioT);
        inputs.put("passwordT", passwordT);
        this.back.setOnAction(controller.back());
        this.save.setOnAction(controller.save(inputs));
    }


    /** Sets the scene on the stage
     * @param stage the main stage
     */
    public void setScene(Stage stage) {
        this.scene = new Scene(this.bp, 450, 500);
        stage.setScene(this.scene);
    }


    /**
     * Adds the buttons to the scene
     */
    public void addButton() {

        this.hb.getChildren().add(this.back);
        this.vb.getChildren().add(this.save);

    }

    /**
     * Adds the "About" text on the scene
     */
    public void addText(){
        this.hb.getChildren().add(new Text("About"));

    }

    /**
     * Adds the HBoxes necessary for the scene.
     */
    public void addHBox() {
        this.vb.getChildren().add(hb);
    }

    /** Adds the vboxes to the scene.
     */
    public void addVBox() {
        this.sp.setContent(this.vb);

    }

    /**
     * Adds all the textfields to the scene.
     */
    public void addTextField() {

        this.vb.getChildren().addAll(this.firstNameL, this.firstNameT);
        this.vb.getChildren().addAll(this.lastNameL, this.lastNameT);
        this.vb.getChildren().addAll(this.birthdayL, this.birthdayT);
        this.vb.getChildren().addAll(this.usernameL, this.usernameT);
        this.vb.getChildren().addAll(this.passwordL, this.passwordT);
        this.vb.getChildren().addAll(this.imgPathL, this.imgPathT);
        this.vb.getChildren().addAll(this.bioL, this.bioT);
        this.vb.getChildren().addAll(this.genderL, this.genderT);
        this.vb.getChildren().addAll(this.genderPrefL, this.genderPrefT);



    }


    /**
     * Sets the margin for the scene.
     */
    public void setMargin() {
        this.bp.setMargin(this.sp, new Insets(50, 50, 20,20));
        this.sp.setBorder(Border.EMPTY);
        this.bp.setBorder(Border.EMPTY);


    }

    /**
     * Sets the internal spacing for each box.
     */
    public void setSpacing() {
        this.hb.setSpacing(90);
        this.vb.setSpacing(20);

    }

    /** Builds the view on given stage
     */
    public void build() {
        this.addVBox();
        this.addHBox();
        this.setSP();
        this.addTextField();
        this.addButton();
        this.addText();
        this.setSpacing();
        this.setMargin();
        this.setScene(stage);
    }
}