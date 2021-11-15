package Phase1.Views;

import Phase1.DataAccess.DataAccessInterface;
import javafx.geometry.Insets;
import Phase1.Users.ProfileUser;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * The builder for the Matches view
 */
public class MatchesViewBuilder implements SceneBuilder{
    ProfileUser user;
    HBox hb;
    Button back;
    ScrollPane scrollPane;
    VBox vb;
    BorderPane bp;
    ArrayList<Integer> matches;
    int secondary;
    DataAccessInterface dm;

    /**
     * Creates a MatchViewBuilder object
     * @param primaryUser the primary user
     * @param matches the list of matches the user has
     * @param dm dataacess interface
     */
    public MatchesViewBuilder(ProfileUser primaryUser, ArrayList<Integer> matches, DataAccessInterface dm){
        this.user = primaryUser;
        this.matches = matches;
        this.scrollPane = new ScrollPane();
        this.bp = new BorderPane();
        this.vb = new VBox();
        this.back = new Button("Back");
        this.hb = new HBox();
        this.dm = dm;

    }

    /**
     * Removes the ID if it's in the matches
     * @param secondary the ID of secondary user
     */
    public void pop(int secondary){
        if (this.matches.contains(secondary)){
            this.matches.remove(this.matches.indexOf(secondary));
        }
    }

    /**
     * @return the matches this user has
     */
    public ArrayList<Integer> getMatches(){
        return this.matches;
    }

    /**
     * @return the Back button
     */
    public Button getBack(){
        return this.back;
    }

    /**
     * Adds the vboxes to the scene
     */
    @Override
    public void addVBox() {

        this.scrollPane.setContent(this.vb);

    }

    /**
     * Adds the Back button to the view
     */
    @Override
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
     * adds the matches to their corresponding buttons and return them as a list
     * @param dm database interface
     * @return the list of buttons that each maps to the matches
     */
    public ArrayList<Button> matchButtons(DataAccessInterface dm){
        ArrayList a = new ArrayList();
        for(Integer i: this.matches){
            Button b = new Button(dm.getFirstName(i));
            this.vb.getChildren().add(b);
            a.add(b);
        }
        return a;
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
    @Override
    public void addHBox() {
        this.bp.setTop(this.hb);


    }

    /** Sets the scene on the main stage
     * @param stage the main stage
     */
    @Override
    public void setScene(Stage stage) {
        stage.setScene(new Scene(this.bp));
    }

    /**
     * Adds the textfields necessary for the scene
     */
    @Override
    public void addTextField() {

    }


    /**
     * Sets the margins for the scene
     */
    @Override
    public void setMargin() {
        this.bp.setMargin(this.hb, new Insets(10,20, 20, 20));
        this.bp.setMargin(this.scrollPane, new Insets(10,20, 20, 20));

    }

    /**
     * Sets the spacing inside the HBox and VBox
     */
    @Override
    public void setSpacing() {
        this.hb.setSpacing(150);
        this.vb.setSpacing(20);

    }


    /**
     * Builds the view on stage
     * @param s the main stage
     */
    @Override
    public void build(Stage s) {
        this.addVBox();
        this.addButton();
        this.addText();
        this.addScrollPane();
        this.orientScrollPane();
        this.addHBox();
        this.setMargin();
        this.setSpacing();
        this.setScene(s);


    }
}
