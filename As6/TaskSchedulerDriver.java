import java.util.*;

public class TaskSchedulerDriver {

    static ArrayList<PTask> tasks = new ArrayList<>();
    static TaskScheduler taskScheduler = new TaskScheduler();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Welcome to Task Manager! ");
        String choice = null;

        while(!"Q".equals(choice) ){

            System.out.println(
                "\nPress N: Creation of a new task"+
                "\nPress P: To add a precondtion to a previously made task"+
                "\nPress I: To retreave a task's information" +
                "\nPress D: To delete a task" +
                "\nPress C: To see task schedule" +
                "\nPress Q: To quit"
            );
            System.out.print("\nInput: ");

            choice = (sc.nextLine()).toUpperCase();
            if((!choice.equals("N")) && tasks == null){
                
                System.out.println("There are currently no tasks to do this function with");
            }
            else{

                chooseOption(choice);
            }
        }
        sc.close();
    }

    public static void chooseOption(String choice){

        String requestedID = null;

        switch (choice) {
            case "N":

                tasks.addAll(createTasks());
                break;

            case "P":

                System.out.println("What task would you like to add a precondition to?");
                printTasks(tasks);
                System.out.print("Input: ");

                requestedID = sc.nextLine();
                addPreconditions(tasks, requestedID);
                break;

            case "I":

                System.out.println("What task would you like to access?");
                printTasks(tasks);
                System.out.print("Input: ");

                requestedID = sc.nextLine();
                printATask(tasks, requestedID);
                break;

            case "D":

                System.out.println("What task would you like to access?");
                printTasks(tasks);
                System.out.print("Input: ");

                requestedID = sc.nextLine();
                deleteATask(tasks, requestedID);
                break;

            case "C":

                System.out.println("Enter the number of team members for this project: ");
                System.out.print("Input: ");

                int numTeamMembers = sc.nextInt();
                sc.nextLine();
                displayTaskSchedule(tasks, numTeamMembers);
                break;

            case "Q":

                System.out.println("Quitting the Task Manager");
                break;

            default:

                System.out.println("Invalid option. Please select a valid option.");
                break;

        }
        
    }

    public static ArrayList<PTask> createTasks() {
        ArrayList<PTask> tasksToAdd = new ArrayList<>();

        System.out.println("How many tasks do you want to create?");
        int numTasks = sc.nextInt();
        sc.nextLine();  

        for (int i = 0; i < numTasks; i++) {
            System.out.println("Enter task ID for Task: " + (i + 1));
            String taskID = sc.nextLine();

            System.out.println("Enter task effort for Task: " + (i + 1));
            int effort = sc.nextInt();
            sc.nextLine(); 

            tasksToAdd.add(new PTask(taskID, effort, new ArrayList<>()));
        }
        return tasksToAdd;
    }

    public static void addPreconditions(ArrayList<PTask> tasks, String taskID) {

        for (PTask task : tasks) {

            if (task.getTaskID().equals(taskID)) {

                System.out.println("Enter preconditions for Task: " + taskID);
                System.out.println("Enter 'done' to finish adding preconditions.");
                
                ArrayList<String> preconditions = new ArrayList<>();
                while (true) {

                    System.out.print("Enter precondition (or 'done' to finish): ");
                    String precondition = sc.nextLine();
                    
                    if (precondition.equalsIgnoreCase("done")) {

                        break;
                    }
                    
                    preconditions.add(precondition);
                }
                
                ArrayList<String> currentPreconditions = task.getPreconditions();
                currentPreconditions.addAll(preconditions);
                task.setPreconditions(currentPreconditions);
                break;
            }
        }
    }
    

    public static void printTasks(ArrayList<PTask> tasks) {
        for (PTask task : tasks) {

            System.out.println("Task ID: " + task.getTaskID());
        }
    }

    public static void printATask(ArrayList<PTask> tasks, String TaskID) {
        
        for (PTask task : tasks) {

            if(TaskID.equals(task.getTaskID())){

                System.out.println("Task ID: " + task.getTaskID());
                System.out.println("Effort: " + task.getEffort());
                System.out.println("Preconditions: " + task.getPreconditions() + "\n");
            }
        }
    }

    public static void deleteATask(ArrayList<PTask> tasks, String TaskID) {
        Iterator<PTask> iterator = tasks.iterator();
        while (iterator.hasNext()) {

            PTask task = iterator.next();
            if (task.getTaskID().equals(TaskID)) {

                iterator.remove(); 
                System.out.println("Task " + TaskID + " removed.");
                break;
            }
        }
    }

    public static void displayTaskSchedule(ArrayList<PTask> tasks, int numTeamMembers) {

        System.out.println("Displaying task schedule for " + numTeamMembers + " team members:");
        taskScheduler.scheduleTasks(new ArrayList<>(tasks), numTeamMembers);
    }
}
