package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import utilities.GUIUtils;


public class SideMenu extends View{
    
    private Button todayBtn;
    private Button allBtn;
    private Button listBtn;
    private Button finishedBtn;
    private Button settingsBtn;
    private VBox menu;
    
    private TodayView todayView;
    private AllView allView;
    private ListsView listsView;
    private FinishedTasksView finishedTasksView;
    private SettingsView settingsView;
    
   

    public SideMenu(GridPane pane){
        super(pane);
        
        this.todayBtn = GUIUtils.initialiseMenuButton("Today's tasks", super.getParent());
        this.allBtn = GUIUtils.initialiseMenuButton("All tasks", super.getParent());
        this.listBtn = GUIUtils.initialiseMenuButton("Lists", super.getParent());
        this.finishedBtn = GUIUtils.initialiseMenuButton("Finished tasks", super.getParent());
        this.settingsBtn = GUIUtils.initialiseMenuButton("Settings", super.getParent());
        
        this.todayView = new TodayView(super.getParent());
        this.allView = new AllView(super.getParent());
        this.listsView = new ListsView(super.getParent());
        this.finishedTasksView = new FinishedTasksView(super.getParent());
        this.settingsView = new SettingsView(super.getParent());
    }
    
    public void initialise(boolean firstOpen){
        initialise();
        
        if(firstOpen){
            todayView.initialise();
            firstOpen = false;
        }
    }

    @Override
    public void initialise() {
        menu = new VBox();
        menu.getStyleClass().add("menu");
        
        GUIUtils.setMenuAction(todayBtn, todayView);
        GUIUtils.setMenuAction(allBtn, allView);
        GUIUtils.setMenuAction(listBtn, listsView);
        GUIUtils.setMenuAction(finishedBtn, finishedTasksView);
        GUIUtils.setMenuAction(settingsBtn, settingsView);
        
        menu.getChildren().addAll(todayBtn, allBtn, listBtn, finishedBtn, settingsBtn);
        menu.setPrefWidth(super.getParent().getPrefWidth());
        
        super.getParent().add(menu, 0, 0);
        
    }

}
