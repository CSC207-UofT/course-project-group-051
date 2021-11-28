package phase2.presenters;

import Phase1.DataAccess.DataAccessInterface;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import phase2.controllers.ProfileController;


/**
 * The view builder for the user's personal info
 */
public class ProfileView implements View {
    ProfileUser u;
    Scene scene;
    BorderPane bp;
    HBox hb;
    javafx.scene.control.Button bt;
    javafx.scene.control.Button bt1;
    VBox vb;
    Label l1;
    Label l2;
    Label l3;
    Label l4;
    Label l5;
    Label l6;
    Label l7;
    Label l8;
    Label l9;
    TextField tf1;
    TextField tf;
    TextField tf2;
    TextField tf3;
    TextField tf4;
    TextField tf5;
    TextField tf6;
    TextField tf7;
    TextField pw;
    Text message;
    ScrollPane sp;
    Stage s;
    DataAccessInterface d;

    /**
     * Creates a SelfViewBuilder object
     * @param u
     */
    public ProfileView(ProfileUser u, DataAccessInterface dm, Stage s){
        this.d = dm;
        this.u = u;
        this.bp = new BorderPane();
        this.sp = new ScrollPane();
        this.bt = new Button("Back");
        this.bt1 = new Button("Save");
        this.l1 = new Label("First Name:");
        this.l2 = new Label("Last Name:");
        this.l3 = new Label("Birthdate:");
        this.l4 = new Label("Password:");
        this.l5 = new Label("Profile Image Path:");
        this.l6 = new Label("Gender:");
        this.l7 = new Label("Preference:");
        this.l8 = new Label("Username:");
        this.l9 = new Label("Bio:");
        this.tf = new TextField(u.getfName());
        this.tf1 = new TextField(u.getlName());
        this.tf2 = new TextField(u.getBirthdate().toString().substring(3, 7) + "," +
                u.getBirthdate().toString().substring(8, 10) + "," +
                u.getBirthdate().toString().substring(u.getBirthdate().toString().length() - 4,
                        u.getBirthdate().toString().length()));
        this.pw = new TextField(u.getPassword());
        this.tf3 = new TextField(u.getImagePath());
        this.tf4 = new TextField(u.getGender());
        this.tf5 = new TextField(u.getPreference());
        this.tf6 = new TextField(u.getUsername());
        this.tf7 = new TextField(u.getBio());
        this.vb = new VBox();
        this.hb = new HBox();
        this.message = new Text();
        this.message.setFill(Color.RED);
        this.message.setFont(new Font(15));
        this.s = s;


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

        ProfileController controller = new ProfileController(dm, s, u);
        this.bt.setOnAction(controller.back());
        this.bt1.setOnAction(controller.save());
    }


    /**
     * @return the username textfield
     */
    public TextField getUsername(){
        return this.tf6;
    }

    /**
     * @return the bio textfield
     */
    public TextField getBio(){
        return this.tf7;
    }

    /**
     * @return the gender textfield
     */
    public TextField getGender(){
        return this.tf4;
    }

    /**
     * @return the gender preference textfield
     */
    public TextField getPreference(){
        return this.tf5;
    }

    /** Sets the scene on the stage
     * @param stage the main stage
     */
    public void setScene(Stage stage) {
        this.scene = new Scene(this.bp, 450, 500);
        stage.setScene(this.scene);
    }

    /**
     * Displays the invalid path message
     */
    public void invalidPath(){
        this.message.setText("Invalid file path. Please try again.");
    }

    /**
     * Adds the buttons to the scene
     */
    public void addButton() {

        this.hb.getChildren().add(this.bt);
        this.vb.getChildren().add(this.bt1);

    }

    /**
     * Adds the "About" text on the scene
     */
    public void addText(){
        this.hb.getChildren().add(new Text("About"));

    }

    /**
     * @return the image path textfield
     */
    public TextField getImagePath(){
        return this.tf3;
    }

    /**
     * @return the first name textfield
     */
    public TextField getfName(){
        return this.tf;
    }

    /**
     * @return the last name textfield
     */
    public TextField getlName(){
        return this.tf1;
    }

    /**
     * @return the birthday textfield
     */
    public TextField getBirthday(){
        return this.tf2;
    }

    /**
     * @return the password textfield
     */
    public TextField getPW(){
        return this.pw;
    }

    /**
     * @return the Back button
     */
    public Button getBack(){
        return this.bt;
    }

    /**
     * @return the Save button
     */
    public Button getSave(){
        return this.bt1;
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

        this.vb.getChildren().addAll(this.l1, this.tf);
        this.vb.getChildren().addAll(this.l2, this.tf1);
        this.vb.getChildren().addAll(this.l3, this.tf2);
        this.vb.getChildren().addAll(this.l8, this.tf6);
        this.vb.getChildren().addAll(this.l4, this.pw);
        this.vb.getChildren().addAll(this.l5, this.tf3);
        this.vb.getChildren().addAll(this.l9, this.tf7);
        this.vb.getChildren().addAll(this.l6, this.tf4);
        this.vb.getChildren().addAll(this.l7, this.tf5);
        this.vb.getChildren().add(this.message);

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
     * @param s main stage
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
        this.setScene(s);
    }
}