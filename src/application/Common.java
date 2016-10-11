package application;

import tasks.TaskList;
import utilities.XMLUtil;

public class Common {
    private TaskList tasks;
    
    public Common(){
        tasks = XMLUtil.getTasks();
    }

    public TaskList getTasks() {
        return tasks;
    }
    
    public static TaskList getTodaysTasks(){
        Common common = new Common();
        TaskList tasks = common.getTasks();
        return tasks.getTodayTasks();
    }
}
