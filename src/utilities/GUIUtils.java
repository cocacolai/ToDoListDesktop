package utilities;



import application.View;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public abstract class GUIUtils {
    
    public static Button initialiseMenuButton(String text, GridPane parent){
        Button btn = new Button(text);
        btn.setPrefWidth(parent.getPrefWidth());
        btn.getStyleClass().add("custom-menu-button");
        return btn;
    }
    
    public static void setMenuAction(Button btn, View view){
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                view.removePreviousAddMenu();
                view.initialise();
            }
        });
    }
    
    public static void removeContent( GridPane parent){
         parent.getChildren().remove(1);
    }

}
