package phase2.presenters;

import javafx.stage.Stage;

public interface View {


    void addVBox();

    void addButton();

    void addHBox();

    void setScene(Stage stage);

    void setMargin();

    void setSpacing();

    /**
     * Builds the view on the given stage and displays it.
     * @param stage The main stage.
     */
    void build();
}
