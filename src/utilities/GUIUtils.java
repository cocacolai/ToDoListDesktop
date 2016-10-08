package utilities;



import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public abstract class GUIUtils {
    
    public static Button initialiseMenuButton(String text, GridPane parent){
        Button btn = new Button(text);
        btn.setPrefWidth(parent.getPrefWidth());
        btn.getStyleClass().add("custom-menu-button");
        return btn;
    }

}
