package utilities;



import application.View;
import consts.FilePathResource;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public abstract class GUIUtils {
    
    public static final double taskDetailPercentageWidth = 0.88;
    public static final double taskPercentageWidth = 1;
    public static final int iconWidth = 40;
    public static final int iconHeight = 40;
    
    public static final String EXPANDED_TASK_NOTES="Click to hide notes";
    public static final String UNEXPANDED_TASK_NOTES="Click to view notes";
    
    public static Button initialiseMenuButton(String text, GridPane parent){
        Button btn = new Button(text);
        btn.setPrefWidth(parent.getPrefWidth());
        btn.getStyleClass().add("custom-menu-button");
        return btn;
    }
    
    public static void setMenuAction(Button btn, final View view){
        btn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                view.removePreviousAddMenu();
                view.initialise();
            }
        });
    }
    
    public static GridPane setRowColumns(GridPane panel, int numCols, int numRows, Pane parent, double percentageParentWidth){
        return setRowColumns(panel, numCols, numRows, parent, percentageParentWidth, null);
    }
    
    
    public static ColumnConstraints getColumnConstraint(Pane parent, double percentageParentWidth, Double colPercentageWidth){
        ColumnConstraints colConst = new ColumnConstraints();
        colConst.setPrefWidth((parent.getPrefWidth()*percentageParentWidth));
        colConst.setFillWidth(true);
        colConst.setHgrow(Priority.ALWAYS) ;
        if(colPercentageWidth != null){
            colConst.setPercentWidth(colPercentageWidth);
        }
        return colConst;
    }
    
    public static ImageView getIconImageAndView(String imageFilePath){
        return new ImageView(new Image(imageFilePath, GUIUtils.iconHeight, GUIUtils.iconWidth, false, false));
    }

    public static GridPane setRowColumns(GridPane panel, int numCols, int numRows, Pane parent, double percentageParentWidth, Double[] colWidths) {
        GridPane pane = panel;
        for (int i = 0; i < numCols; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPrefWidth((parent.getPrefWidth()*percentageParentWidth));
            colConst.setFillWidth(true);
            colConst.setHgrow(Priority.ALWAYS) ;
            if(colWidths != null){
                colConst.setPercentWidth(colWidths[i]*100);
            }
            pane.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < numRows; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setFillHeight(true);
            rowConst.setVgrow(Priority.ALWAYS) ;
            pane.getRowConstraints().add(rowConst);         
        }
        return panel;
    }

}
