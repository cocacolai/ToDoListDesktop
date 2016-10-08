package application;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class ListsView extends View{

    public ListsView(GridPane parent) {
        super(parent);
       
    }

    @Override
    public void initialise() {
        Label label1 = new Label("Content from lists view");
        super.getContent().getChildren().add(label1);
        
        super.getParent().add(super.getContent(), 1, 0);
        
    }

}
