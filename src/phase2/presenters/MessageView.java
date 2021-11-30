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
import phase2.controllers.MessageController;
import phase2.dataaccess.DataAccessInterface;
import java.util.ArrayList;

/**
 * The view displaying the messages between the primary user and secondary user.
 */
public class MessageView implements View{
    DataAccessInterface db; // the data access interface.
    Stage s; // the main stage.
    int primaryUser; // the primary user's ID.
    int secondaryUser; // the secondary user's ID.
    HBox hb; // the top HBox.
    TextField tf; // the textfield that stores the message.
    Button back; // the Back button.
    ScrollPane scrollPane; // the scroll pane that stores the messages.
    VBox vb; // the vbox that stores the messages.
    BorderPane bp; //the main border pane.
    Button send; // the send button.
    ArrayList<Integer> threads; // the arraylist consisting of the threads for the given primary user.
    HBox hb1; //the bottom HBox.


    /**
     * Creates the MessageView object.
     * @param db Data Access interface.
     * @param s the main stage.
     * @param primaryUser the primary user's ID.
     * @param secondaryUser the secondary user's ID.
     */
    public MessageView(DataAccessInterface db, Stage s, int primaryUser, int secondaryUser){
        this.db = db;
        this.s = s;
        this.primaryUser = primaryUser;
        this.secondaryUser = secondaryUser;
        this.scrollPane = new ScrollPane();
        this.bp = new BorderPane();
        this.vb = new VBox();
        this.back = new Button("Back");
        this.hb = new HBox();
        this.hb1 = new HBox();
        this.send = new Button("Send");
        this.threads = db.getThreads(primaryUser);
        this.tf = new TextField();
    }

    /**
     * @return the input message in the textfield.
     */
    private String getMessage(){
        String message = this.tf.getText();
        return message;
    }

    /**
     * Delegates the tasks to the controller.
     */
    private void setOnActions(){

        MessageController controller = new MessageController(db, s, primaryUser, secondaryUser);
        this.back.setOnAction(controller.back());;
        this.send.setOnAction(controller.send(this.getMessage()));;
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
            ArrayList thread = db.getThreads(primaryUser);
            if (thread.size() > 0){
            Integer tid = (Integer) thread.get(0);
            ArrayList<String> x = db.getThread(tid);
            for(String i: x){
            Integer sender = new Integer(i.split(",")[1]);
            Integer receiver = new Integer(i.split(",")[2]);
            String msg = i.split(",")[0];

            if(sender.equals(primaryUser) && receiver.equals(secondaryUser)){
                Label l = new Label(msg);
                l.setMinWidth(Region.USE_PREF_SIZE);
                l.setFont(new Font(20));
                l.setStyle("-fx-background-color: lightblue; -fx-background-radius: 10;"
                );

                this.vb.getChildren().add(l);
            }
            else if(sender.equals(secondaryUser) && receiver.equals(primaryUser)){
                Label l = new Label(msg);
                l.setMinWidth(Region.USE_PREF_SIZE);
                l.setFont(new Font(20));
                l.setStyle("-fx-background-color: palegreen; -fx-background-radius: 10;"
                );
                this.vb.getChildren().add(l);
            }}}

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
        this.hb.getChildren().add(this.back);
        this.hb.getChildren().add(this.send);
    }

    /**
     * Adds the Matches title to the scene
     */
    public void addText(){
        this.hb.getChildren().add(new Text(db.getFirstName(secondaryUser)));
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
        this.setOnActions();
        this.setScene(s);
    }
}
