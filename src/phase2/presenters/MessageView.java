package phase2.presenters;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import phase2.controllers.ControllerFactory;
import phase2.controllers.MessageController;

import java.util.ArrayList;
import java.util.List;

/**
 * The view displaying the messages between the primary user and secondary user.
 */
public class MessageView implements View{

    private MessageController controller;
    private HBox hb; // the top HBox.
    private TextField tf; // the textfield that stores the message.
    private Button backButton; // the Back button.
    private ScrollPane scrollPane; // the scroll pane that stores the messages.
    private VBox vb; // the vbox that stores the messages.
    private BorderPane bp; //the main border pane.
    private Button sendButton; // the send button.
    private ArrayList<Integer> threads; // the arraylist consisting of the threads for the given primary user.
    private HBox hb1; //the bottom HBox.


    public MessageView(int receiver){

        controller = ControllerFactory.getInstance().getMessageController(receiver);
        this.scrollPane = new ScrollPane();
        this.bp = new BorderPane();
        this.vb = new VBox();
        this.backButton = new Button("Back");
        this.sendButton = new Button("Send");
        this.hb = new HBox();
        this.hb1 = new HBox();
        this.tf = new TextField();
    }


    /**
     * Builds the scene on the stage.
     */
    @Override
    public void build() {
        this.addVBox();

        this.addText();
        this.addScrollPane();
        this.orientScrollPane();
        this.loadThread();
        this.addHBox();
        this.addButton();
        this.setMargin();
        this.setSpacing();
        addTextField();
        this.setOnActions();
        this.setScene(controller.getStage());
    }


    /**
     * Delegates the tasks to the controller.
     */
    private void setOnActions(){

        this.backButton.setOnAction(controller.back());
        this.sendButton.setOnAction(controller.send(tf));
    }


    /**
     * Adds the textfield to the scene.
     */
    public void addTextField(){
        this.hb1.getChildren().add(this.tf);
    }


    /**
     * Loads the threads to the scene if any.
     */
    public void loadThread(){

        List<String[]> messages = controller.getThread();
        for (String[] message: messages) {

            String content = message[0];

            String colour = controller.determineSender(message[1]);


            Label l = new Label(content);
            l.setMinWidth(Region.USE_PREF_SIZE);
            l.setFont(new Font(20));
            l.setStyle(colour);
            this.vb.getChildren().add(l);

        }


    }


    /**
     * Adds the vboxes to the scene
     */
    public void addVBox() {

        this.scrollPane.setContent(this.vb);

    }

    /**
     * Adds the Back button to the view
     */
    public void addButton() {
        this.hb.getChildren().add(this.backButton);
        this.hb.getChildren().add(this.sendButton);
    }


    /**
     * Adds the Matches title to the scene
     */
    public void addText(){
        this.hb.getChildren().add(new Text(controller.getReciever()));
    }


    /**
     * Adds the scroll pane to the scene
     */
    public void addScrollPane(){
        this.bp.setCenter(this.scrollPane);

    }


    /**
     * Orients the scroll pane
     */
    public void orientScrollPane(){
        this.scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        this.scrollPane.setVmax(440);
        this.scrollPane.setPrefSize(115, 150);
        this.scrollPane.setVvalue(1.0);
    }


    /**
     * Adds the HBox to the scene
     */
    public void addHBox() {
        this.bp.setTop(this.hb);
        this.bp.setBottom(this.hb1);


    }


    /** Sets the scene on the main stage
     * @param stage the main stage
     */
    public void setScene(Stage stage) {
        stage.setScene(new Scene(this.bp));
    }


    /**
     * Sets the margins for the scene
     */
    public void setMargin() {
        BorderPane.setMargin(this.hb, new Insets(10,20, 20, 20));
        BorderPane.setMargin(this.scrollPane, new Insets(10,20, 20, 20));
        this.hb.setAlignment(Pos.BASELINE_RIGHT);
    }


    /**
     * Sets the spacing inside the HBox and VBox
     */
    public void setSpacing() {
        this.hb.setSpacing(150);
        this.vb.setSpacing(20);

    }
}
