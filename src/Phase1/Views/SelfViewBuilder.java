package Phase1.Views;

import Phase1.Users.User;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Text;


import java.util.ArrayList;

public class SelfViewBuilder implements SceneBuilder{
    User u;
    Scene scene;
    BorderPane bp;
    HBox hb;
    javafx.scene.control.Button bt;
    javafx.scene.control.Button bt1;
    VBox vb;

    public SelfViewBuilder(User u){
        this.u = u;
        this.bp = new BorderPane();
    }

    @Override
    public void setScene(Stage stage) {
        this.scene = new Scene(this.bp, 450, 500);
        stage.setScene(this.scene);
    }

    @Override
    public void addButton() {
        this.bt = new Button("Back");
        this.bt1 = new Button("Save");
        this.hb.getChildren().add(this.bt);
        this.hb.getChildren().add(new Text("About"));
    }

    public Button getBack(){
        return this.bt;
    }

    public Button getSave(){
        return this.bt1;
    }

    @Override
    public void addHBox() {
        this.hb = new HBox();
    }

    @Override
    public void addVBox() {
        this.vb = new VBox();
        this.vb.getChildren().add(this.hb);
    }
    @Override
    public void addTextField() {
        Label l1 = new Label("First Name:");
        Label l2 = new Label("Last Name:");
        Label l3 = new Label("Birthdate:");
        Label l4 = new Label("Password:");

        TextField tf = new TextField(u.getfName());
        TextField tf1 = new TextField(u.getlName());
        TextField tf2 = new TextField(u.getBirthdate().toString().substring(3, 7) + "," +
                u.getBirthdate().toString().substring(8, 10) + "," +
                u.getBirthdate().toString().substring(u.getBirthdate().toString().length() - 4,
                        u.getBirthdate().toString().length()));
        TextField pw = new TextField(u.getPassword());
        this.vb.getChildren().addAll(l1, tf);
        this.vb.getChildren().addAll(l2, tf1);
        this.vb.getChildren().addAll(l3, tf2);
        this.vb.getChildren().addAll(l4, pw);
        this.vb.getChildren().add(this.bt1);

    }


    @Override
    public void setMargin() {
        this.bp.setCenter(this.vb);
        this.bp.setMargin(this.vb, new Insets(50, 50, 50, 50));

    }

    @Override
    public void setSpacing() {
        this.hb.setSpacing(30);
        this.vb.setSpacing(20);

    }

    @Override
    public void build(Stage s) {
        this.addHBox();
        this.addButton();
        this.addVBox();
        this.addTextField();
        this.setSpacing();
        this.setMargin();
        this.setScene(s);
    }
}
