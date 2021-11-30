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

    private SwipeController controller;// the primary user.
    HBox hb; // the hbox containing the buttons.
    StackPane sp; // the scroll pane.
    Button matchesButton; // the matches button.
    Button myProfileButton; // the self view button.
    Button logoutButton; // the log out button.
    Button refreshButton; // the refresh button.
    BorderPane bp; // the main borderpane.
    VBox v; // the main vbox.
    Scene scene; // the scene corresponding to this view.
    Text text; // the message on the view.
    Stage s; // the main stage.
    DataAccessInterface db; // the data access interface.

    /**
     * @param stage the main stage
     * @param db the data access interface
     * @param id the current user's ID
     */
    public EmptySwipeView( Stage stage, DataAccessInterface db, int id){


        controller = new SwipeController(stage, db, id);
        this.bp = new BorderPane();
        this.sp = new StackPane();
        this.matchesButton = new Button("Matches");
        this.myProfileButton = new Button("Me");
        this.logoutButton = new Button("Log Out");
        this.refreshButton = new Button("Refresh");
        this.hb = new HBox();
        this.v = new VBox();
        this.text = new Text("There is no user to swipe at the moment,\n" +
                " please refresh or try again later");
        this.s = stage;
        this.db = db;
    }

    /**
     * Delegates the task to each button.
     */
    public void setOnAction(){
        this.refreshButton.setOnAction(controller.refresh());
        this.logoutButton.setOnAction(controller.logOut());
        this.myProfileButton.setOnAction(controller.changeProfileView());
        this.matchesButton.setOnAction(controller.changeMatchView());

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
        this.v.getChildren().add(refreshButton);
        this.hb.getChildren().add(matchesButton);
        this.hb.getChildren().add(myProfileButton);
        this.hb.getChildren().add(logoutButton);


    }

    /**
     * @return the Matches button
     */
    public Button getMatches(){
        return this.matchesButton;
    }

    /**
     * @return the LogOut button
     */
    public Button getLogOut(){
        return this.logoutButton;
    }

    /**
     * @return the Me button.
     */
    public Button getMe(){
        return this.myProfileButton;
    }

    /**
     * @return the refresh button.
     */
    public Button getRefresh(){
        return this.refreshButton;
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
        BorderPane.setMargin(this.hb, new Insets(40, 20, 0, 70));
        BorderPane.setMargin(this.matchesButton, new Insets(320, 10, 50, 50));
        BorderPane.setMargin(this.myProfileButton, new Insets(320, 50, 50, 10));
        VBox.setMargin(this.refreshButton, new Insets(0, 50, 0, 140));
        VBox.setMargin(this.text, new Insets(150, 50, 0, 65));



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
        this.setOnAction();
        this.addButton();
        this.addHBox();
        this.addVBox();
        this.setSpacing();
        this.addbp();
        this.setMargin();
        this.setScene(s);

    }
}


