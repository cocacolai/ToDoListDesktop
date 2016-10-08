package utilities;



import application.View;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;

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
    
    public static GridPane setRowColumns(GridPane panel, int numCols, int numRows, Pane parent){
        GridPane pane = panel;
        for (int i = 0; i < numCols; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPrefWidth((parent.getPrefWidth()*0.88));
            pane.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < numRows; i++) {
            pane.getRowConstraints().add(new RowConstraints());         
        }
        return pane;
    }
    

}
