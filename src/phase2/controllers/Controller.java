package phase2.controllers;

import javafx.stage.Stage;
import phase2.dataaccess.DataAccessInterface;

public class Controller {

    DataAccessInterface db; //the Data Access Interface.
    Stage stage; //the main stage.

    public Controller(DataAccessInterface db, Stage stage){
        this.db = db;
        this.stage = stage;
    }

    public Stage getStage(){
        return stage;
    }
}
