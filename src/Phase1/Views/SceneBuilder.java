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
    public void setMargin();

    public void setScene(Stage stage);
    public void addTextField();
    public void addHBox();
    public void addVBox();
    public void setMargin(Insets inset);
    public void setSpacing();
    public void mapEventHandler(ArrayList<EventHandler> e);
    public void build(Stage s, ArrayList<EventHandler> e);
}
