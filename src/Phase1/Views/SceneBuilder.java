package Phase1.Views;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

interface SceneBuilder {
    void setScene(Stage stage);
    void addTextField();
    void addHBox();
    void addVBox();
    void setMargin();
    void setSpacing();
    void mapEventHandler(ArrayList<EventHandler> e);
    void build(Stage s, ArrayList<EventHandler> e);
}
