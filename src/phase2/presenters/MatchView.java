package phase2.presenters;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import phase2.controllers.MatchController;
import phase2.dataaccess.DataAccessInterface;

import java.util.ArrayList;

public class MatchView implements View{
    HBox hb;
    Button back;
    ScrollPane scrollPane;
    VBox vb;
    BorderPane bp;
    DataAccessInterface db;
    Stage stage;
    int userID;

    public MatchView(DataAccessInterface db, Stage stage, int userID){
        this.db = db;
        this.stage = stage;
        this.scrollPane = new ScrollPane();
        this.bp = new BorderPane();
        this.vb = new VBox();
        this.back = new Button("Back");
        this.hb = new HBox();
        this.userID = userID;

    }


    private void setOnActions(){

        MatchController controller = new MatchController(db, stage, userID);
        ArrayList<Integer> matches = controller.getMatches();
//        for(Integer i: matches){
//            Button b = new Button(controller.getFirstName(i));
//            this.vb.getChildren().add(b);
//            b.setOnAction(controller.switchMessage(i));
//        }
        Button b = new Button("controller.getFirstName(i)");
        this.vb.getChildren().add(b);
        Button d = new Button("controller.sdagetFirstName(i)");
        this.vb.getChildren().add(d);
        //b.setOnAction(controller.switchMessage(i));

        back.setOnAction(controller.back());
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
    }

    /**
     * Adds the Matches title to the scene
     */
    public void addText(){
        this.hb.getChildren().add(new Text("Matches"));
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


    }

    /**
     * Adds the HBox to the scene
     */
    public void addHBox() {
        this.bp.setTop(this.hb);


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

    }

    /**
     * Sets the spacing inside the HBox and VBox
     */
    public void setSpacing() {
        this.hb.setSpacing(150);
        this.vb.setSpacing(20);

    }
    @Override
    public void build() {
        this.addVBox();
        this.addButton();
        this.addText();
        this.addScrollPane();
        this.orientScrollPane();
        this.addHBox();
        this.setMargin();
        this.setSpacing();
        this.setOnActions();
        this.setScene(stage);
    }
}
