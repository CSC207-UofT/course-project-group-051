package phase2.presenters;

import phase2.controllers.ControllerFactory;
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

/**
 * Represents the view when swiping on other people.
 */
public class SwipeView implements View{

    //TODO: rename boxes.
    private SwipeController controller;
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
     * Creates an instance of the view, and accepts a SwipeController so that we do not need to create a new one.
     * Accepting the SwipeController allows us to keep track of the same swipeList between view updates.
     * @param swipeController an instance of swipeController.
     */
    public SwipeView(SwipeController swipeController){

        controller = swipeController;
        labelButtons();
        hb = new HBox();
        hb2 = new HBox();
        v = new VBox();
        sp = new StackPane();
        bp = new BorderPane();
    }


    /**
     * Creates an instance of swipeview and a new SwipeController and displays it.
     */
    public SwipeView() {

        controller = ControllerFactory.getInstance().getSwipeController();
        labelButtons();
        hb = new HBox();
        hb2 = new HBox();
        v = new VBox();
        sp = new StackPane();
        bp = new BorderPane();
    }


    /**
     * Labels the buttons.
     */
    private void labelButtons() {

        noButton = new Button("No");
        yesButton = new Button("Yes");
        matchesButton = new Button("Matches");
        logoutButton = new Button("Log Out");
        myProfileButton = new Button("My Profile");
    }

    @Override
    public void build() {

        setUserData();
        setOnActions();
        addButton();
        addHBox();
        addVBox();
        setSpacing();
        addsp();
        setMargin();
        setScene(controller.getStage());

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
        sp.getChildren().add(fNameAge);
        sp.getChildren().add(bio);

    }


    /**
     * Adds the HBoxes to the BorderPane.
     */
    private void addHBox() {
        bp.setTop(hb);
        bp.setBottom(hb2);
    }


    /**
     * Adds the VBoxes to the BorderPane.
     */
    private void addVBox() {
        bp.setCenter(v);

    }


    /**
     * Adds the buttons to the scene.
     */
    private void addButton() {
        bp.setLeft(noButton);
        bp.setRight(yesButton);
        hb.getChildren().add(matchesButton);
        hb.getChildren().add(logoutButton);
        hb.getChildren().add(myProfileButton);

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

        BorderPane.setMargin(hb, Positioner.BUTTON_POSITION);

        BorderPane.setMargin(noButton, Positioner.NO_POSITION);

        BorderPane.setMargin(yesButton, Positioner.YES_POSITION);

        BorderPane.setMargin(v, Positioner.VBOX_POSITION);

        StackPane.setMargin(fNameAge, Positioner.namePositioner(image));

        StackPane.setMargin(bio, Positioner.bioPositioner(image));

        hb2.setAlignment(Pos.BASELINE_LEFT);


    }


    /**
     * Set scene on the stage.
     * @param stage the mainstage where we display the scene.
     */
    private void setScene(Stage stage) {
        Scene scene = new Scene(this.bp, this.image.getFitWidth() + 300, this.image.getFitHeight() + 250);
        stage.setScene(scene);
    }

}
