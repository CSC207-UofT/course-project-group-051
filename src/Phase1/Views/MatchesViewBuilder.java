package Phase1.Views;

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

public class MatchesViewBuilder implements SceneBuilder{
    ProfileUser user;
    HBox hb;
    Button back;
    ScrollPane scrollPane;
    VBox vb;
    BorderPane bp;
    ArrayList<ProfileUser> matches;
    public MatchesViewBuilder(ProfileUser primaryUser, ArrayList<ProfileUser> matches){
        this.user = primaryUser;
        this.matches = matches;
        this.scrollPane = new ScrollPane();
        this.bp = new BorderPane();
        this.vb = new VBox();
        this.back = new Button("Back");
        this.hb = new HBox();

    }

    public Button getBack(){
        return this.back;
    }
    public ArrayList getMatches(){
        return this.matches;
    }


    @Override
    public void addVBox() {

        this.scrollPane.setContent(this.vb);

    }
    @Override
    public void addButton() {
        this.hb.getChildren().add(this.back);
    }
    public void addText(){
        this.hb.getChildren().add(new Text("Matches"));
    }

    public ArrayList<Button> matchButtons(){
        ArrayList a = new ArrayList();
        for(ProfileUser i: this.matches){
            Button b = new Button(i.getfName());
            this.vb.getChildren().add(b);
            a.add(b);
        }
        return a;
    }

    public void addScrollPane(){
        this.bp.setCenter(this.scrollPane);

    }
    public void orientScrollPane(){
        this.scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        this.scrollPane.setVmax(440);
        this.scrollPane.setPrefSize(115, 150);


    }

    @Override
    public void addHBox() {
        this.bp.setTop(this.hb);


    }


    @Override
    public void setScene(Stage stage) {
        stage.setScene(new Scene(this.bp));
    }

    @Override
    public void addTextField() {

    }




    @Override
    public void setMargin() {
        this.bp.setMargin(this.hb, new Insets(10,20, 20, 20));
        this.bp.setMargin(this.scrollPane, new Insets(10,20, 20, 20));

    }

    @Override
    public void setSpacing() {
        this.hb.setSpacing(150);
        this.vb.setSpacing(20);

    }



    @Override
    public void build(Stage s) {
        this.addVBox();
        this.addButton();
        this.addText();
        this.matchButtons();
        this.addScrollPane();
        this.orientScrollPane();
        this.addHBox();
        this.setMargin();
        this.setSpacing();
        this.setScene(s);


    }
}
