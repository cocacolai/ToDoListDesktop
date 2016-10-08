package application;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class AllView extends View{
    
    private Pane content;

    public AllView(GridPane parent) {
        super(parent);
       
    }

    @Override
    public void initialise() {
        
        Label label1 = new Label("Content from all view");
        super.getContent().getChildren().add(label1);
        
        super.getParent().add(super.getContent(), 1, 0);
        
    }

}
