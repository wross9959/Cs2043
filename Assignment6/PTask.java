import java.util.ArrayList;

public class PTask{

    private String taskID;
    private int effort; //same units as startTime
    private int startTime; //initialize to -1, to be determined later by the scheduling algorithm
    private String status; //not_started, in_progress, completed
    private ArrayList<String> preconditions; //array with taskIDs

    //constructor
    public PTask(String taskID, int effort, ArrayList<String> preconditions ){
        this.taskID = taskID;
        this.effort = effort;
        this.preconditions = preconditions;
        this.status = "Not Started";
        this.startTime = -1;
    }

    //getters
    public String getTaskID(){
        return taskID;
    }
    public int getEffort(){
        return effort;
    }
    public ArrayList<String> getPreconditions(){
        return preconditions;
    }
    public String getStatus(){
        return status;
    }
    public int getStartTime(){
        return startTime;
    }

    //modifiers
    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }
    public void setEffort(int effort) {
        this.effort = effort;
    }
    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setPreconditions(ArrayList<String> preconditions) {
        this.preconditions = preconditions;
    }


}