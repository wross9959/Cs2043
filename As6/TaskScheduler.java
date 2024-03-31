import java.util.ArrayList;

public class TaskScheduler {
/* 
    public void scheduleTasks(ArrayList<PTask> tasks, int numberOfPersons) {
        ArrayList<PTask> scheduledTasks = new ArrayList<>();
        ArrayList<PTask> unscheduledTasks = new ArrayList<>(tasks);

        int currentTime = 0;
        while (!unscheduledTasks.isEmpty()) {
            ArrayList<PTask> readyTasks = findReadyTasks(unscheduledTasks, scheduledTasks);

            for (int i = 0; i < numberOfPersons && i < readyTasks.size(); i++) {
                PTask task = readyTasks.get(i);
                task.setStartTime(currentTime);
                task.setStatus("in_progress");
                scheduledTasks.add(task);
                unscheduledTasks.remove(task);

                int completionTime = currentTime + task.getEffort();
                // Update completion times for tasks in the future based on this task
                updateCompletionTimes(unscheduledTasks, task.getTaskID(), completionTime);
            }

            if (!scheduledTasks.isEmpty()) {
                // Find the next earliest completion time
                int nextStartTime = Integer.MAX_VALUE;
                for (PTask scheduledTask : scheduledTasks) {
                    if (scheduledTask.getStartTime() + scheduledTask.getEffort() < nextStartTime) {
                        nextStartTime = scheduledTask.getStartTime() + scheduledTask.getEffort();
                    }
                }
                currentTime = nextStartTime;
            }
        }
        printSchedule(scheduledTasks);
    }
*/
    public void scheduleTasks(ArrayList<PTask> tasks, int numberOfPersons) {
        ArrayList<PTask> scheduledTasks = new ArrayList<>();
        ArrayList<PTask> unscheduledTasks = new ArrayList<>(tasks);

        int currentTime = 0;
        while (!unscheduledTasks.isEmpty()) {
            ArrayList<PTask> readyTasks = findReadyTasks(unscheduledTasks, scheduledTasks);

            for (int i = 0; i < numberOfPersons && i < readyTasks.size(); i++) {
                PTask task = readyTasks.get(i);
                task.setStartTime(currentTime);
                task.setStatus("in_progress");
                scheduledTasks.add(task);
                unscheduledTasks.remove(task);

                int completionTime = currentTime + task.getEffort();
                updateCompletionTimes(unscheduledTasks, task.getTaskID(), completionTime);
            }

            if (!scheduledTasks.isEmpty()) {
                int nextStartTime = Integer.MAX_VALUE;
                for (PTask scheduledTask : scheduledTasks) {
                    int taskEndTime = scheduledTask.getStartTime() + scheduledTask.getEffort();
                    if (taskEndTime < nextStartTime) {
                        nextStartTime = taskEndTime;
                    }
                }
                currentTime = nextStartTime;
            }
        }

        printSchedule(scheduledTasks);
    }
    
    private ArrayList<PTask> findReadyTasks(ArrayList<PTask> tasks, ArrayList<PTask> scheduledTasks) {
        ArrayList<PTask> readyTasks = new ArrayList<>();
        for (PTask task : tasks) {
            boolean isReady = true;
            for (String precondition : task.getPreconditions()) {
                boolean found = false;
                for (PTask scheduledTask : scheduledTasks) {
                    if (scheduledTask.getTaskID().equals(precondition)) {
                        found = true;
                        if (scheduledTask.getStartTime() + scheduledTask.getEffort() > task.getStartTime()) {
                            isReady = false;
                            break;
                        }
                    }
                }
                if (!found) {
                    isReady = false;
                    break;
                }
            }
            if (isReady) {
                readyTasks.add(task);
            }
        }
        return readyTasks;
    }

    private void updateCompletionTimes(ArrayList<PTask> tasks, String taskId, int completionTime) {
        for (PTask task : tasks) {
            if (task.getPreconditions().contains(taskId)) {
                task.getPreconditions().remove(taskId);
            }
        }
    }
    

    private void printSchedule(ArrayList<PTask> scheduledTasks) {
        
        for(int i = 0; i < scheduledTasks.size() - 1; i++){
            for( int j = i + 1; j < scheduledTasks.size(); j++){

                if(scheduledTasks.get(i).getStartTime() > scheduledTasks.get(j).getStartTime()){

                    PTask currTask = scheduledTasks.get(i);
                    scheduledTasks.set(i, scheduledTasks.get(j));
                    scheduledTasks.set(j, currTask);
                }
            }
        }

        for(PTask task: scheduledTasks){
            int completedTime = task.getStartTime() + task.getEffort();
            System.out.println("Task: " + task.getTaskID() +
                ", Start Time: " + task.getStartTime() +
                ", Completion Time: " + completedTime);
        }
    }
}
