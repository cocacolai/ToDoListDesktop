package application;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class TodayView extends View{
    
    
    public TodayView(GridPane pane){
       super(pane);
    }
    
    @Override
    public void initialise(){
        Label label1 = new Label("Content from today view");
        super.getContent().getChildren().add(label1);
        
        super.getParent().add(super.getContent(), 1, 0);
        
    }

}
