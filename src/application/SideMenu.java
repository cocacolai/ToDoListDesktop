package application;

import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import utilities.GUIUtils;

public class SideMenu {
    
    private GridPane parent;
    private  Button todayBtn;
    private Button allBtn;
    private Button listBtn;
    private Button finishedBtn;
    private Button settingsBtn;
    private VBox menu;
    

    public SideMenu(GridPane pane){
        this.parent = pane;
        this.todayBtn = GUIUtils.initialiseMenuButton("Today's tasks", parent);
        this.allBtn = GUIUtils.initialiseMenuButton("All tasks", parent);
        this.listBtn = GUIUtils.initialiseMenuButton("Lists", parent);
        this.finishedBtn = GUIUtils.initialiseMenuButton("Finished tasks", parent);
        this.settingsBtn = GUIUtils.initialiseMenuButton("Settings", parent);
    }
    
    public void initialise(){
        menu = new VBox();
        menu.getStyleClass().add("menu");
        menu.getChildren().addAll(todayBtn, allBtn, listBtn, finishedBtn, settingsBtn);
        menu.setPrefWidth(parent.getPrefWidth());
        
        parent.add(menu, 0, 0);
    }

}
