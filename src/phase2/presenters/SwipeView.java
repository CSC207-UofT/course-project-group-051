package phase2.presenters;

import Phase1.DataAccess.DataAccessInterface;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import phase2.controllers.SwipeController;

import java.util.Map;
import java.util.Queue;

/**
 * Represents the view when swiping on other people.
 */
public class SwipeView implements View{

    //TODO: rename boxes.
    private SwipeController controller;
    private Stage stage;
    private Scene scene;
    private Button noButton;
    private Button yesButton;
    private Button matchesButton;
    private Button logoutButton;
    private Button myProfileButton;
    private HBox hb;// The HBox containing the buttons.
    private HBox hb2;
    private VBox v; // The VBox containing the scroll pane.
    private StackPane sp;// The stack pane for the photo, first name and bio.
    private BorderPane bp;// The borderpane containing the VBox.
    private ImageView image;// The profile ImageView of the user to be swiped on.
    private Label fNameAge;
    private Label bio;



    /**
     * @param db A reference to our database.
     * @param stage the main stage where we display the scene.
     * @param id Id of the currently logged-in User.
     * @param swipeList List of people this user can swipe on.
     */
    public SwipeView(DataAccessInterface db, Stage stage, int id, Queue<Integer> swipeList) {

        controller = new SwipeController(db, stage, id, swipeList);
        this.stage = stage;

        noButton = new Button("No");
        yesButton = new Button("Yes");
        matchesButton = new Button("Matches");
        logoutButton = new Button("Log Out");
        myProfileButton = new Button("My Profile");
        hb = new HBox();
        hb2 = new HBox();
        v = new VBox();
        sp = new StackPane();
        bp = new BorderPane();

        build();
    }

    @Override
    public void build() {

        addButton();
        addHBox();
        addVBox();
        addTextField();
        setSpacing();
        addsp();
        setOnActions();
        setUserData();
        setMargin();
        setScene(stage);

    }

    //Why is this here?
    private void addTextField() {
    }

    /**
     * Set the actions to the buttons of this view.
     */
    private void setOnActions() {
        noButton.setOnAction(controller.swipeLeft());
        yesButton.setOnAction(controller.swipeRight());
        matchesButton.setOnAction(controller.changeMatchView());
        logoutButton.setOnAction(controller.logOut());
        myProfileButton.setOnAction(controller.changeProfileView());
    }

    /**
     * Gets the data of the user to be swiped on, so that we can display it.
     */
    private void setUserData() {

        Map<String, String> userData = controller.getUserData();
        image = controller.getCurrentImage();

        fNameAge = new Label(userData.get("fNameAge"));
        bio = new Label(userData.get("bio"));

        addImage();
        addText();

    }

    /**
     * Adds the imageview to the view.
     */
    private void addImage(){
        sp.getChildren().add(image);
    }

    /**
     * Adds the text elements to the Scrollpane.
     */
    private void addText(){
        this.sp.getChildren().add(this.fNameAge);
        this.sp.getChildren().add(this.bio);

    }

    /**
     * Creates the HBoxes necessary for the scene.
     */
    private void addHBox() {
        this.bp.setTop(this.hb);
        this.bp.setBottom(this.hb2);
    }

    /**
     * Creates all the VBoxes necessary for the scene.
     */
    private void addVBox() {
        this.bp.setCenter(v);

    }

    /**
     * Adds the buttons to the scene
     */
    private void addButton() {
        this.bp.setLeft(noButton);
        this.bp.setRight(yesButton);
        this.hb.getChildren().add(matchesButton);
        this.hb.getChildren().add(logoutButton);
        this.hb.getChildren().add(myProfileButton);

    }

    /**
     * Sets the spacing for each box.
     */
    private void setSpacing() {

        hb.setSpacing(this.image.getFitWidth() / 4);
    }

    /**
     * Sets the margin of the biggest box in the borderpane.
     */
    private void addsp(){
        this.bp.setCenter(this.sp);

    }

    /**
     * Sets the margin for the view.
     */
    private void setMargin() {

        BorderPane.setMargin(this.hb, Positioner.BUTTON_POSITION);

        BorderPane.setMargin(this.noButton, Positioner.NO_POSITION);

        BorderPane.setMargin(this.yesButton, Positioner.YES_POSITION);

        BorderPane.setMargin(this.v, Positioner.VBOX_POSITION);

        StackPane.setMargin(this.fNameAge, Positioner.namePositioner(image));

        StackPane.setMargin(this.bio, Positioner.bioPositioner(image));

        this.hb2.setAlignment(Pos.BASELINE_LEFT);


    }

    /** Set scene on the stage.
     * @param stage the mainstage where we display the scene.
     */
    private void setScene(Stage stage) {
        this.scene = new Scene(this.bp, this.image.getFitWidth() + 300, this.image.getFitHeight() + 250);
        stage.setScene(this.scene);
    }

}
