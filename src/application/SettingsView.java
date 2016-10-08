package application;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class SettingsView extends View{

    public SettingsView(GridPane parent) {
        super(parent);
        
    }

    @Override
    public void initialise() {
        super.initialise();
        Label label1 = new Label("Content from settings view");
        super.getContent().getChildren().add(label1);
        
        super.getParent().add(super.getContent(), 1, 0);
        
    }

}
