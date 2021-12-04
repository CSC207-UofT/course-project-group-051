package phase2.presenters;

import phase2.users.User;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import phase2.controllers.SwipeController;
import phase2.dataaccess.DataAccessInterface;

/**
 * The view being displayed when the user reaches the end of swipe list.
 */
public class EmptySwipeView implements View{

    User primary; // the primary user.
    HBox hb; // the hbox containing the buttons.
    StackPane sp; // the scroll pane.
    Button btn1; // the matches button.
    Button btn2; // the self view button.
    Button btn3; // the log out button.
    Button btn4; // the refresh button.
    BorderPane bp; // the main borderpane.
    VBox v; // the main vbox.
    Scene scene; // the scene corresponding to this view.
    Text text; // the message on the view.
    Stage s; // the main stage.
    DataAccessInterface db; // the data access interface.

    /**
     * @param user the current user
     * @param s the main stage
     * @param db the data access interface
     */
    public EmptySwipeView(User user, Stage s, DataAccessInterface db){
        this.primary = user;
        this.bp = new BorderPane();
        this.sp = new StackPane();
        this.btn1 = new Button("Matches");
        this.btn2 = new Button("Me");
        this.btn3 = new Button("Log Out");
        this.btn4 = new Button("Refresh");
        this.hb = new HBox();
        this.v = new VBox();
        this.text = new Text("There is no user to swipe at the moment,\n" +
                " please refresh or try again later");
        this.s = s;
        this.db = db;
    }

    /**
     * Delegates the task to each button.
     */
    public void setOnAction(){
        SwipeController sp = new SwipeController(db, s, primary.getId(), db.getSwipeList(primary.getId()));
        this.btn4.setOnAction(sp.refresh());
        this.btn3.setOnAction(sp.logOut());
        this.btn2.setOnAction(sp.selfView());
        this.btn1.setOnAction(sp.matches());

    }

    /**
     * Creates the HBoxes necessary for the scene.
     */
    public void addHBox() {
        this.bp.setTop(this.hb);
    }


    /** Maps each button to its corresponding eventhandler.
     */


    public void addButton() {
        this.v.getChildren().add(btn4);
        this.hb.getChildren().add(btn1);
        this.hb.getChildren().add(btn2);
        this.hb.getChildren().add(btn3);


    }

    /**
     * @return the Matches button
     */
    public Button getMatches(){
        return this.btn1;
    }

    /**
     * @return the LogOut button
     */
    public Button getLogOut(){
        return this.btn3;
    }

    /**
     * @return the Me button.
     */
    public Button getMe(){
        return this.btn2;
    }

    /**
     * @return the refresh button.
     */
    public Button getRefresh(){
        return this.btn4;
    }

    /**
     * Creates all the VBoxes necessary for the scene.
     */
    public void addVBox() {
        this.bp.setCenter(v);

    }



    /**
     * Adds textfield to the corresponding box.
     */
    public void addTextField() {
    }


    /**
     * Sets the spacing for each box.
     */
    public void setSpacing() {
        this.v.setSpacing(30);
        this.hb.setSpacing(30);

    }

    /**
     * Adds the border pane to the stack pane.
     */
    public void addbp(){
        this.sp.getChildren().add(this.bp);

    }

    /**
     * Sets the margin of the biggest box in the borderpane.
     */
    public void setMargin() {
        this.bp.setMargin(this.hb, new Insets(40, 20, 0, 70));
        this.bp.setMargin(this.btn1, new Insets(320, 10, 50, 50));
        this.bp.setMargin(this.btn2, new Insets(320, 50, 50, 10));
        this.v.setMargin(this.btn4, new Insets(0, 50, 0, 140));
        this.v.setMargin(this.text, new Insets(150, 50, 0, 65));



    }

    /** Set scene on the stage.
     * @param stage the mainstage where we display the scene.
     */
    public void setScene(Stage stage) {
        this.scene = new Scene(this.sp, 350, 490);
        stage.setScene(this.scene);
    }

    /**
     * Adds the title to the scene
     */
    public void setText(){
        this.v.getChildren().add(this.text);

    }


    /**
     * Builds the scene on given stage
     */

    @Override
    public void build() {
        this.setText();
        this.addButton();
        this.addHBox();
        this.addVBox();
        this.setSpacing();
        this.addbp();
        this.setMargin();
        this.setScene(s);

    }
}



