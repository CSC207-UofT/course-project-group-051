package phase2.presenters;

import javafx.scene.text.Font;
import phase2.constants.Positioner;
import phase2.constants.UserInfoConstants;
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

    private final SwipeController controller;
    private final HBox hb;// The HBox containing the buttons.
    private final HBox hb1;
    private final VBox v; // The VBox containing the scroll pane.
    private final StackPane sp;// The stack pane for the photo, first name and bio.
    private final BorderPane bp;// The borderpane containing the VBox.
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
        hb = new HBox();
        hb1 = new HBox();
        v = new VBox();
        sp = new StackPane();
        bp = new BorderPane();
    }


    /**
     * Creates an instance of SwipeView and a new SwipeController and displays it.
     */
    public SwipeView() {

        controller = ControllerFactory.getInstance().getSwipeController();
        hb = new HBox();
        hb1 = new HBox();
        v = new VBox();
        sp = new StackPane();
        bp = new BorderPane();
    }


    @Override
    public void build() {


        if (!controller.isEmpty()) {
            setUserData();
            this.imageSizer();
            this.setMargin();
        }
        else{
            BorderPane.setMargin(this.hb, Positioner.BUTTON_POSITION);
            this.hb.setAlignment(Pos.TOP_CENTER);
        }
        this.addVBox();
        this.addSP();
        this.setOnActions();
        this.addHBox();
        this.setSpacing();
        this.setScene(controller.getStage());
    }


    /**
     * Set the actions to the buttons of this view.
     */
    private void setOnActions() {

        //Instantiate buttons
        Button noButton = new Button("No");
        Button yesButton = new Button("Yes");
        Button matchesButton = new Button("Matches");
        Button logoutButton = new Button("Log Out");
        Button myProfileButton = new Button("My Profile");
        Button refreshButton = new Button("Refresh");
        BorderPane.setMargin(noButton, Positioner.NO_POSITION);

        BorderPane.setMargin(yesButton, Positioner.YES_POSITION);

        //Set the buttons to their positions and add their actions
        if (controller.isEmpty()){
            this.bp.setCenter(refreshButton);
            refreshButton.setOnAction(controller.refresh());
        } else {
            bp.setLeft(noButton);
            bp.setRight(yesButton);
            noButton.setOnAction(controller.swipeLeft());
            yesButton.setOnAction(controller.swipeRight());
        }
        hb.getChildren().add(matchesButton);
        hb.getChildren().add(logoutButton);
        hb.getChildren().add(myProfileButton);
        matchesButton.setOnAction(controller.changeMatchView());
        logoutButton.setOnAction(controller.logOut());
        myProfileButton.setOnAction(controller.changeProfileView());

    }


    /**
     * Gets the data of the user to be swiped on, so that we can display it.
     */
    private void setUserData() {
        Map<String, String> userData = controller.getUserData();
        this.image = ImageMaker.getImage(controller.getCurrentImage());
        fNameAge = new Label(userData.get(UserInfoConstants.FIRST_NAME) + ", " +
                userData.get(UserInfoConstants.AGE));
        fNameAge.setFont(new Font(20));
        fNameAge.setStyle("-fx-background-color: lightblue; -fx-background-radius: 10;");
        bio = new Label(userData.get(UserInfoConstants.BIO));
        bio.setFont(new Font(20));
        bio.setStyle("-fx-background-color: lightblue; -fx-background-radius: 10;");

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
     * Sets the spacing for each box.
     */
    private void setSpacing() {
        hb.setSpacing(270);
        //hb.setSpacing(this.image.getFitWidth() / 4);
        hb1.setSpacing(10);
    }


    /**
     * Adds the text elements to the ScrollPane.
     */
    private void addText(){
        this.sp.getChildren().add(fNameAge);
        this.sp.getChildren().add(bio);

    }


    /**
     * Adds the HBoxes to the BorderPane.
     */
    private void addHBox() {
        this.bp.setTop(this.hb);
        this.bp.setBottom(hb1);
        if(!controller.isEmpty()){
            setSpacing();
        }
    }

    /**
     * Sizes the image dimension to a default.
     */
    private void imageSizer(){
        this.image.setFitWidth(600);
        this.image.setFitHeight(600);
    }


    /**
     * Adds the VBoxes to the BorderPane.
     */
    private void addVBox() {
        bp.setCenter(this.v);

    }


    /**
     * Sets the margin of the biggest box in the borderpane.
     */
    private void addSP(){
        this.v.getChildren().add(this.sp);

    }


    /**
     * Sets the margin for the view.
     */
    private void setMargin() {

        BorderPane.setMargin(hb, Positioner.BUTTON_POSITION);

        BorderPane.setMargin(v, Positioner.VBOX_POSITION);

        StackPane.setMargin(fNameAge, Positioner.NAME_POSITION);

        StackPane.setMargin(bio, Positioner.BIO_POSITION);

    }


    /**
     * Set scene on the stage.
     * @param stage the main stage where we display the scene.
     */
    private void setScene(Stage stage) {

        Scene scene;


        scene = new Scene(this.bp, 800, 800);


        stage.setScene(scene);
    }

}
