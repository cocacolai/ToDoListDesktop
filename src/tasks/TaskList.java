package tasks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskList {
    private List<Task> tasks = null;
    
    public TaskList(){
        this.tasks = new ArrayList<Task>();
    }
    
    public TaskList(List<Task> tasks){
        this.tasks = tasks;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public TaskList getTodayTasks() {
        TaskList todayTasks = new TaskList();
        if(!this.getTasks().isEmpty()){
            //Date today = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            //Date today = sdf.parse(sdf.format(new Date()));
            for(Task t: this.getTasks()){
                try {
                    Date today = sdf.parse(sdf.format(new Date()));
                    Date taskDate = sdf.parse(t.getDateStr());
                    if(today.equals(taskDate)){
                        todayTasks.getTasks().add(t);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        
        return todayTasks;
    }
}
