package tasks;

import consts.FilePathResource;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import utilities.GUIUtils;
import utilities.ResourceUtil;

public class Task {
    
    private String taskNameStr;
    private String dateStr;
    private String timeStr;
    private String listStr;
    private String notesStr;
    
    private Label taskName;
    private Label date;
    private Label time;
    private Label list;
    private CheckBox taskDone;
    
    public Task(String taskNameStr, String dateStr, String timeStr, String listStr, String notesStr){
        this.taskNameStr = taskNameStr;
        this.dateStr = dateStr;
        this.timeStr = timeStr;
        this.listStr = listStr;
        this.notesStr = notesStr;
                
        this.taskName = new Label();
        this.date = new Label();
        this.time = new Label();
        this.list = new Label();
        this.taskDone = new CheckBox();
        
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

    public String getNotesStr() {
        return notesStr;
    }

    public void setNotesStr(String notesStr) {
        this.notesStr = notesStr;
    }

    public Pane getPane(Pane parent){
        Pane pane = new Pane();
        pane.getStyleClass().add("taskPane");
        
        GridPane content = new GridPane();
        content = GUIUtils.setRowColumns(content, 1, 2, parent,GUIUtils.taskDetailPercentageWidth);
        content.getStyleClass().add("task");   
        
        GridPane innerContent = new GridPane();
        innerContent = GUIUtils.setRowColumns(innerContent, 4, 1, parent,GUIUtils.taskDetailPercentageWidth, new Double[]{0.05,0.9,0.05,0.05});
        innerContent.add(taskDone, 0, 0);
        
        GridPane taskContent = new GridPane();
        taskContent = GUIUtils.setRowColumns(taskContent,1,3, parent,GUIUtils.taskDetailPercentageWidth);
        
        taskName.setText(taskNameStr);
        
        date.setText(dateStr);
        time.setText(timeStr);
        list.setText(listStr);
        
        taskContent.add(taskName, 0,0);
        
        GridPane dateTimeContent = new GridPane();
        dateTimeContent = GUIUtils.setRowColumns(dateTimeContent,2,1, parent,GUIUtils.taskDetailPercentageWidth);
        dateTimeContent.getStyleClass().add("taskDateTime");
        
        dateTimeContent.add(date,0,0);
        dateTimeContent.add(time,1,0);
        taskContent.add(dateTimeContent, 0,1);
               
        taskContent.add(list, 0,2);
        innerContent.add(taskContent,1,0);
        
        Button editBtn = new Button();
        editBtn.setGraphic(GUIUtils.getIconImageAndView(FilePathResource.EDIT_ICON));
        innerContent.add(editBtn, 2, 0);
        
        Button deleteBtn = new Button();
        deleteBtn.setGraphic(GUIUtils.getIconImageAndView(FilePathResource.DELETE_ICON));
        innerContent.add(deleteBtn, 3, 0);
                       
        final TitledPane notesPane = new TitledPane();
        notesPane.setText(GUIUtils.UNEXPANDED_TASK_NOTES);
        TextArea notesArea = new TextArea(notesStr);
        notesArea.setEditable(false);
        notesPane.setContent(notesArea);
        notesPane.setExpanded(false);
        notesPane.setOnMouseClicked(new EventHandler<MouseEvent>(){

            public void handle(MouseEvent event) {
                if(notesPane.getText().equals(GUIUtils.UNEXPANDED_TASK_NOTES)){
                    notesPane.setText(GUIUtils.EXPANDED_TASK_NOTES);
                }
                else{
                    notesPane.setText(GUIUtils.UNEXPANDED_TASK_NOTES);
                }
                
            }
            
        });
        
        content.add(innerContent,0,0);
        content.add(notesPane,0,1);
        
        pane.getChildren().add(content);
        
        return pane;
    }
    

}
