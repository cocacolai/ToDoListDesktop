package tasks;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import utilities.GUIUtils;

public class Task {
    
    private String taskNameStr;
    private String dateStr;
    private String timeStr;
    private String listStr;
    
    private Label taskName;
    private Label date;
    private Label time;
    private Label list;
    
    public Task(String taskNameStr, String dateStr, String timeStr, String listStr){
        this.taskNameStr = taskNameStr;
        this.dateStr = dateStr;
        this.timeStr = timeStr;
        this.listStr = listStr;
                
        this.taskName = new Label();
        this.date = new Label();
        this.time = new Label();
        this.list = new Label();
        
    }
    
    public String getTaskNameStr() {
        return taskNameStr;
    }

    public void setTaskNameStr(String taskNameStr) {
        this.taskNameStr = taskNameStr;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public String getTimeStr() {
        return timeStr;
    }

    public void setTimeStr(String timeStr) {
        this.timeStr = timeStr;
    }

    public String getListStr() {
        return listStr;
    }

    public void setListStr(String listStr) {
        this.listStr = listStr;
    }

    public Pane getPane(Pane parent){
        Pane pane = new Pane();
        pane.getStyleClass().add("taskPane");
        
        GridPane content = new GridPane();
        content = GUIUtils.setRowColumns(content,1,3, parent);
        content.setGridLinesVisible(true);
        content.getStyleClass().add("task");
        
        taskName.setText(taskNameStr);
        date.setText(dateStr);
        time.setText(timeStr);
        list.setText(listStr);
        
        content.add(taskName, 0,0);
        
        GridPane dateTimeContent = new GridPane();
        dateTimeContent = GUIUtils.setRowColumns(dateTimeContent,2,1, parent);
        dateTimeContent.setGridLinesVisible(true);
        
        dateTimeContent.add(date, 0,0);
        dateTimeContent.add(time,1,0);
        content.add(dateTimeContent, 0,1);
               
        content.add(list, 0,2);
        
        pane.getChildren().add(content);
        
        return pane;
    }
    

}
