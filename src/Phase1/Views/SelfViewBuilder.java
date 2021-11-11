package Phase1.Views;

import Phase1.Users.ProfileUser;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.text.Text;


import java.io.FileInputStream;
import java.util.ArrayList;

public class SelfViewBuilder implements SceneBuilder{
    ProfileUser u;
    Scene scene;
    BorderPane bp;
    HBox hb;
    javafx.scene.control.Button bt;
    javafx.scene.control.Button bt1;
    VBox vb;
    Label l1;
    Label l2;
    Label l3;
    Label l4;
    Label l5;
    Label l6;
    Label l7;
    TextField tf1;
    TextField tf;
    TextField tf2;
    TextField tf3;
    TextField tf4;
    TextField tf5;
    TextField pw;
    Text message;


    public SelfViewBuilder(ProfileUser u){
        this.u = u;
        this.bp = new BorderPane();
        this.bt = new Button("Back");
        this.bt1 = new Button("Save");
        this.l1 = new Label("First Name:");
        this.l2 = new Label("Last Name:");
        this.l3 = new Label("Birthdate:");
        this.l4 = new Label("Password:");
        this.l5 = new Label("Profile Image Path:");
        this.l6 = new Label("Gender:");
        this.l7 = new Label("Preference:");

        this.tf = new TextField(u.getfName());
        this.tf1 = new TextField(u.getlName());
        this.tf2 = new TextField(u.getBirthdate().toString().substring(3, 7) + "," +
                u.getBirthdate().toString().substring(8, 10) + "," +
                u.getBirthdate().toString().substring(u.getBirthdate().toString().length() - 4,
                        u.getBirthdate().toString().length()));
        this.pw = new TextField(u.getPassword());
        this.tf3 = new TextField(u.getImagePath());
        this.tf4 = new TextField(u.getGender());
        this.tf5 = new TextField(u.getPreference());
        this.vb = new VBox();
        this.hb = new HBox();
        this.message = new Text();
        this.message.setFill(Color.RED);
        this.message.setFont(new Font(15));


    }


    public TextField getGender(){
        return this.tf4;
    }

    public TextField getPreference(){
        return this.tf5;
    }

    @Override
    public void setScene(Stage stage) {
        this.scene = new Scene(this.bp, 450, 500);
        stage.setScene(this.scene);
    }

    public void invalidPath(){
        this.message.setText("Invalid file path. Please try again.");
    }

    @Override
    public void addButton() {

        this.hb.getChildren().add(this.bt);
        this.vb.getChildren().add(this.bt1);

    }

    public void addText(){
        this.hb.getChildren().add(new Text("About"));

    }
    public TextField getImagePath(){
        return this.tf3;
    }
    public TextField getfName(){
        return this.tf;
    }

    public TextField getlName(){
        return this.tf1;
    }

    public TextField getBirthday(){
        return this.tf2;
    }

    public TextField getPW(){
        return this.pw;
    }

    public Button getBack(){
        return this.bt;
    }

    public Button getSave(){
        return this.bt1;
    }

    @Override
    public void addHBox() {
        this.vb.getChildren().add(hb);
    }

    @Override
    public void addVBox() {
        this.bp.setCenter(this.vb);

    }
    @Override
    public void addTextField() {

        this.vb.getChildren().addAll(this.l1, this.tf);
        this.vb.getChildren().addAll(this.l2, this.tf1);
        this.vb.getChildren().addAll(this.l3, this.tf2);
        this.vb.getChildren().addAll(this.l4, this.pw);
        this.vb.getChildren().addAll(this.l5, this.tf3);
        this.vb.getChildren().add(this.message);

    }



    @Override
    public void setMargin() {
        this.bp.setMargin(this.vb, new Insets(50, 50, 50, 50));

    }

    @Override
    public void setSpacing() {
        this.hb.setSpacing(90);
        this.vb.setSpacing(20);

    }

    @Override
    public void build(Stage s) {
        this.addVBox();
        this.addHBox();
        this.addTextField();
        this.addButton();
        this.addText();
        this.setSpacing();
        this.setMargin();
        this.setScene(s);
    }
}
