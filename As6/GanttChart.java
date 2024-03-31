/* 
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.BarChart;
import javafx.stage.Stage;
import java.util.ArrayList;

public class GanttChart extends Application {

    @Override
    public void start(Stage stage) {
        // Create sample tasks (you can replace this with your actual tasks)
        ArrayList<PTask> tasks = createTasks();

        // Create axes for the Gantt Chart
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();

        // Create a Gantt Chart
        final BarChart<String, Number> ganttChart = new BarChart<>(xAxis, yAxis);
        ganttChart.setTitle("Task Schedule");

        // Set labels for axes
        xAxis.setLabel("Tasks");
        yAxis.setLabel("Time");

        // Create series for tasks
        for (PTask task : tasks) {
            BarChart.Series<String, Number> series = new BarChart.Series<>();
            series.setName(task.getTaskID());
            series.getData().add(new BarChart.Data<>("", task.getEffort()));
            ganttChart.getData().add(series);
        }

        Scene scene = new Scene(ganttChart, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Gantt Chart Example");
        stage.show();
    }

    // Method to create sample tasks
    private ArrayList<PTask> createTasks() {
        ArrayList<PTask> tasks = new ArrayList<>();
    
        ArrayList<String> task1Preconditions = new ArrayList<>();
        PTask task1 = new PTask("Task1", 05, task1Preconditions); // Start time: 0, Duration: 5
        tasks.add(task1);
    
        ArrayList<String> task2Preconditions = new ArrayList<>();
        task2Preconditions.add("Task1"); // Task2 depends on Task1
        PTask task2 = new PTask("Task2", 4, task2Preconditions); // Start time: 5, Duration: 4
        tasks.add(task2);
    
        ArrayList<String> task3Preconditions = new ArrayList<>();
        task3Preconditions.add("Task1"); // Task3 depends on Task1
        PTask task3 = new PTask("Task3", 7, task3Preconditions); // Start time: 5, Duration: 7
        tasks.add(task3);
    
        return tasks;
    }
    

    public static void main(String[] args) {
        launch(args);
    }
}

private ArrayList<PTask> createTasks() {
        ArrayList<PTask> tasks = new ArrayList<>();
    
        // Define your tasks here as per your test scenarios
        PTask task1 = new PTask("Task1", 3, new ArrayList<>());
        PTask task2 = new PTask("Task2", 4, new ArrayList<>());
        PTask task3 = new PTask("Task3", 2, new ArrayList<>());
        PTask task4 = new PTask("Task4", 5, new ArrayList<>());
    
        // Set task dependencies (preconditions)
        ArrayList<String> task2Preconditions = new ArrayList<>();
        task2Preconditions.add("Task1"); // Task2 depends on Task1
        task2.setPreconditions(task2Preconditions);
    
        ArrayList<String> task3Preconditions = new ArrayList<>();
        task3Preconditions.add("Task2"); // Task3 depends on Task2
        task3.setPreconditions(task3Preconditions);
    
        ArrayList<String> task4Preconditions = new ArrayList<>();
        task4Preconditions.add("Task1"); // Task4 depends on Task1
        task4.setPreconditions(task4Preconditions);
    
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);
    
        return tasks;
    }
*/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.util.ArrayList;

public class GanttChart extends Application {
    private teamMembers[] team; 
    
    @Override
    public void start(Stage stage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, 800, 400);

        ArrayList<PTask> tasks = createTasks();
        int startX = 50;
        int startY = 50;
        int taskHeight = 30;
        int ySpacing = 30; // Vertical spacing between tasks

        int currentX = startX;
        int currentY = startY;

        for (PTask task : tasks) {
            int teamMembers = getTeamMembersForTask(task.getTaskID()); // Get team members for the task
            int taskEndX = currentX + task.getEffort() * 10; // Calculate task end x-coordinate

            Rectangle taskRectangle = new Rectangle(currentX, currentY, task.getEffort() * 10, taskHeight);
            taskRectangle.setFill(Color.GREEN); // Set completed task color

            if (!task.getStatus().equals("completed")) {
                taskRectangle.setFill(Color.WHITE); // Set incomplete task color to white
            }

            root.getChildren().add(taskRectangle);

            // Display task label (Task ID and Team Members)
            // Modify or add appropriate labels as per your requirements
            String taskLabel = task.getTaskID() + " (Team: " + teamMembers + ")";
            javafx.scene.text.Text label = new javafx.scene.text.Text(currentX, currentY - 5, taskLabel);
            root.getChildren().add(label);

            // Move to the next task position
            currentX += task.getEffort() * 10 + 20; // Considering effort as x-axis units and 20 as spacing
            currentY += ySpacing; // Move down for the next task
        }

        stage.setScene(scene);
        stage.setTitle("Gantt Chart Example");
        stage.show();
    }

    private ArrayList<PTask> createTasks() {
        ArrayList<PTask> tasks = new ArrayList<>();
    
        // Define your tasks here as per your test scenarios
        PTask task1 = new PTask("Task1", 3, new ArrayList<>());
        PTask task2 = new PTask("Task2", 4, new ArrayList<>());
        PTask task3 = new PTask("Task3", 2, new ArrayList<>());
        PTask task4 = new PTask("Task4", 5, new ArrayList<>());
    
        // Set task dependencies (preconditions)
        ArrayList<String> task2Preconditions = new ArrayList<>();
        task2Preconditions.add("Task1"); // Task2 depends on Task1
        task2.setPreconditions(task2Preconditions);
    
        ArrayList<String> task3Preconditions = new ArrayList<>();
        task3Preconditions.add("Task2"); // Task3 depends on Task2
        task3.setPreconditions(task3Preconditions);
    
        ArrayList<String> task4Preconditions = new ArrayList<>();
        task4Preconditions.add("Task1"); // Task4 depends on Task1
        task4.setPreconditions(task4Preconditions);
    
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);
    
        return tasks;
    }

    public int getTeamMembersForTask(PTask task) {
        int teamMembersCount = 0;
        if (task != null && team.getTeamMembers() != null) {
            teamMembersCount = team.getTeamMembers();
        }
        return teamMembersCount;
    }
    

    public static void main(String[] args) {
        launch(args);
    }
}

class teamMembers {
    String taskID;
    int teamMembers[];

    public teamMembers(String taskId, int teamMembersCount) {
        this.taskID = taskId;
        this.teamMembers = new int[teamMembersCount];
    }

    public String getTaskID() {
        return taskID;
    }

    public int getTeamMembers() {
        return teamMembers.length;
    }
}


