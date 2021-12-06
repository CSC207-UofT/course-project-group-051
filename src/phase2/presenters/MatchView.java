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
import phase2.controllers.ControllerFactory;
import phase2.controllers.MatchController;

import java.util.Map;

public class MatchView implements View{

    MatchController controller;
    HBox hb;
    ScrollPane scrollPane;
    VBox vb;
    BorderPane bp;


    public MatchView(){

        controller = ControllerFactory.getInstance().getMatchController();
        this.scrollPane = new ScrollPane();
        this.bp = new BorderPane();
        this.vb = new VBox();
        this.hb = new HBox();

    }


    @Override
    public void build() {
        this.addVBox();
        this.addText();
        this.addScrollPane();
        this.orientScrollPane();
        this.addHBox();
        this.setMargin();
        this.setSpacing();
        this.setOnActions();
        this.setScene(controller.getStage());
    }


    /**
     * Defines the actions for each button.
     */
    private void setOnActions(){

        Map<String, Integer> matches = controller.getMatches();
        for (String name: matches.keySet()) {
            Button b = new Button(name);
            vb.getChildren().add(b);
            b.setOnAction(controller.switchMessageView(matches.get(name)));
        }

        Button back = new Button("Back");
        vb.getChildren().add(back);
        back.setOnAction(controller.back());

    }


    /**
     * Adds the VBoxes to the scene
     */
    public void addVBox() {

        this.scrollPane.setContent(vb);

    }


//    /**
//     * Adds the Back button to the view
//     */
//    public void addButton() {
//        this.hb.getChildren().add(this.backButton);
//    }
//
//
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

}
