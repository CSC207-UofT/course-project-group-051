package phase2.controllers;

import javafx.stage.Stage;
import phase2.dataaccess.DataAccessInterface;

public class Controller {

    Stage stage; //the main stage.
    DataAccessInterface db; //the Data Access Interface.

    public Controller(Stage stage, DataAccessInterface db){
        this.stage = stage;
        this.db = db;
    }

    public Stage getStage(){
        return stage;
    }
}
