package application;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import tasks.Task;
import tasks.TaskList;
import utilities.GUIUtils;

public class TodayView extends View{
    
    private ScrollPane scrollPane;
    //private List<Task> todaysTasks;
    private TaskList todaysTasks;
    
    public TodayView(GridPane pane){
       super(pane);
       scrollPane = new ScrollPane();
       this.todaysTasks = Common.getTodaysTasks();
       
    }
    
    
    @Override
    public void initialise(){   
        super.initialise();
        scrollPane.setPrefHeight(super.getContent().getPrefHeight());
        scrollPane.setPrefWidth(super.getContent().getPrefWidth());
        
        this.todaysTasks.getTasks().add(new Task("a","b","c","d","notes1","false"));
        this.todaysTasks.getTasks().add(new Task("e","f","g","h","notes2","false"));
        
        GridPane allTasks = new GridPane();
        allTasks = GUIUtils.setRowColumns(allTasks, 1, todaysTasks.getTasks().size(), super.getContent(),GUIUtils.taskPercentageWidth);
        
        int row =0;
        for(Task t: todaysTasks.getTasks()){
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
