package phase2.controllers;

import javafx.stage.Stage;
import phase2.dataaccess.DataAccessInterface;

/**
 * Base class for all Controllers.
 */
public class Controller {

    final DataAccessInterface db; //the Data Access Interface.
    final Stage stage; //the main stage.

    /**
     * Creates an instance of Controller.
     * @param db, the DataAccessInterface
     * @param stage, reference to stage where views are displayed
     */
    public Controller(DataAccessInterface db, Stage stage){
        this.db = db;
        this.stage = stage;
    }

    /**
     * Returns the current stage.
     * @return stage, a reference to where views are displayed
     */
    public Stage getStage(){
        return stage;
    }
}
