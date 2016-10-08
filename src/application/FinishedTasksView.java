package application;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class FinishedTasksView extends View{

    public FinishedTasksView(GridPane parent) {
        super(parent);
        
    }

    @Override
    public void initialise() {
        super.initialise();
        Label label1 = new Label("Content from finished tasks view");
        super.getContent().getChildren().add(label1);
        
        super.getParent().add(super.getContent(), 1, 0);
        
    }

}
