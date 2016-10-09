package application;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import tasks.Task;
import utilities.GUIUtils;

public class TodayView extends View{
    
    private ScrollPane scrollPane;
    private List<Task> todaysTasks;
    
    public TodayView(GridPane pane){
       super(pane);
       scrollPane = new ScrollPane();
       todaysTasks = new ArrayList<Task>();
    }
    
    public TodayView(GridPane pane,List<Task> todaysTasks){
        super(pane);
        scrollPane = new ScrollPane();
        this.todaysTasks = todaysTasks;
     }
    
    @Override
    public void initialise(){   
        super.initialise();
        scrollPane.setPrefHeight(super.getContent().getPrefHeight());
        scrollPane.setPrefWidth(super.getContent().getPrefWidth());
        
        Task temp = new Task("a","b","c","d");
        Task temp1 = new Task("e","f","g","h");
        todaysTasks.add(temp);
        todaysTasks.add(temp1);
        
        GridPane allTasks = new GridPane();
        allTasks = GUIUtils.setRowColumns(allTasks, 1, todaysTasks.size(), super.getContent(),GUIUtils.taskPercentageWidth);
        
        int row =0;
        for(Task t: todaysTasks){
            Pane tempPane = t.getPane(super.getContent());
            tempPane.setPadding(new Insets(10, 10, 10, 10));
            allTasks.add(tempPane, 0, row);
            row++;
        }
        scrollPane.setContent(allTasks);
        
        super.getContent().getChildren().add(scrollPane);
        
        super.getParent().add(super.getContent(), 1, 0);
        
    }

}
