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

/**
 * The SceneBuilder interface
 */
interface SceneBuilder {
    /**
     * Sets the scene on given stage
     * @param stage the mainstage
     */
    void setScene(Stage stage);

    /**
     * Adds all the textfields necessary for the scene
     */
    void addTextField();

    /**
     * Adds all the HBoxes necessary for the scene
     */
    void addHBox();

    /**
     * Adds all the VBoxes necessary for the scene
     */
    void addVBox();

    /**
     * Sets the margin for the scene
     */
    void setMargin();

    /**
     * Sets the spacing inside of the V/Hboxes
     */
    void setSpacing();

    /**
     * Adds all the buttons to the scene
     */
    void addButton();

    /**
     * Builds the view on the given stage
     * @param s the main stage
     */
    void build(Stage s);
}
