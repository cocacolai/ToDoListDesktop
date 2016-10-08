package application;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public abstract class View {
    private GridPane parent;
    private Pane content;
    
    public View(GridPane parent){
        this.setParent(parent);
        this.content = new Pane();
        
    }

    public GridPane getParent() {
        return parent;
    }

    public void setParent(GridPane parent) {
        this.parent = parent;
    }
    
    public Pane getContent() {
        return content;
    }

    public void setContent(Pane content) {
        this.content = content;
    }
    
    public abstract void initialise();
    
    public void removePreviousAddMenu(){
        parent.getChildren().clear();
        
        SideMenu menu = new SideMenu(parent);
        menu.initialise(false);
    }
}


