import java.util.ArrayList;

public class Schedule {
    ArrayList<PTask> schedule;
    /* 
    public static boolean verifySchedule(ArrayList<PTask> schedule){
        for (PTask currPTask : schedule){
            int currentStartTime = currPTask.getStartTime();
            //int taskCompletion = currentStartTime + currPTask.getEffort();

            for(String preconditions : currPTask.getPreconditions()){
                PTask preConditionTask = findTask(schedule, preconditions);
                if(preConditionTask == null){
                    return false;
                }
                int preconditionsCompleteTime = preConditionTask.getStartTime() + preConditionTask.getEffort();
                if(currentStartTime < preconditionsCompleteTime){
                    return false;
                }
                
                else{
                    return false;
                }
            }
        }
        return true;
    }

    public static PTask findTask(ArrayList<PTask> schedule, String taskID){
        for(PTask currPTask: schedule){
            if(currPTask.getTaskID() == taskID){
                return currPTask;
            }
        }
        return null;
    }
    */
    public static boolean verifySchedule(ArrayList<PTask> schedule) {
        for (PTask task : schedule) {
            for (String precondition : task.getPreconditions()) {
                for (PTask scheduledTask : schedule) {
                    if (scheduledTask.getTaskID().equals(precondition)) {
                        if (scheduledTask.getStartTime() + scheduledTask.getEffort() > task.getStartTime()) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
