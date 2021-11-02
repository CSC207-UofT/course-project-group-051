package Phase1.Views;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

interface SceneBuilder {
void setScene(Stage stage);
void addTextField(TextField textfield, Label label);
void addHBox(HBox hbox);
void addVBox(VBox vbox);
void setMargin(Insets inset);
void setSpacing(HBox hbox, VBox vbox, int spacing);
void mapEventHandler(Button button, EventHandler handler);
}
