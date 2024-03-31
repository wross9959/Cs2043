/*
 * To compile: javac -cp junit3.8.1.jar ScheduleDriverTest.java Schedule.java PTask.java
 * To run: java -cp .:junit3.8.1.jar ScheduleDriverTest.java
 * to get Junit Terminal text: junit.textui.TestRunner.run(ScheduleDriverTest.class);
 * To get Junit GUI:  junit.swingui.TestRunner.run(ScheduleDriverTest.class);
 */
import junit.framework.TestCase;
import java.util.ArrayList;

public class ScheduleDriverTest extends TestCase {
    
    public void testVerifyScheduleEmpty() {
        ArrayList<PTask> tasks = new ArrayList<>();
        boolean scheduleVerified = Schedule.verifySchedule(tasks);
        assertTrue(scheduleVerified);
    }

    public void testVerifyScheduleSingleTask() {
        ArrayList<PTask> tasks = new ArrayList<>();
        PTask task1 = new PTask("Task1", 5, new ArrayList<>());
        tasks.add(task1);
        boolean scheduleVerified = Schedule.verifySchedule(tasks);
        assertTrue(scheduleVerified);
    }

    public void testVerifyScheduleIndependentTasks() {
        ArrayList<PTask> tasks = new ArrayList<>();
        PTask task1 = new PTask("Task1", 5, new ArrayList<>());
        PTask task2 = new PTask("Task2", 3, new ArrayList<>());
        tasks.add(task1);
        tasks.add(task2);
        boolean scheduleVerified = Schedule.verifySchedule(tasks);
        assertTrue(scheduleVerified);
    }

    public void testVerifyScheduleDependentTasks() {
        ArrayList<PTask> tasks = new ArrayList<>();
        PTask task1 = new PTask("Task1", 5, new ArrayList<>());
        PTask task2 = new PTask("Task2", 3, new ArrayList<>());
        ArrayList<String> task2Preconditions = new ArrayList<>();
        task2Preconditions.add("Task1");
        task2.setPreconditions(task2Preconditions);
        tasks.add(task1);
        tasks.add(task2);
        boolean scheduleVerified = Schedule.verifySchedule(tasks);
        assertFalse(scheduleVerified);
    }

    public void testVerifyScheduleIncorrectDependency() {
        ArrayList<PTask> tasks = new ArrayList<>();
        ArrayList<String> emptyList = new ArrayList<>(); // Empty precondition list for Task1
        PTask task1 = new PTask("Task1", 5, emptyList);
        PTask task2 = new PTask("Task2", 3, new ArrayList<>());
        task2.getPreconditions().add("Task3"); // Correcting dependency to an existing task
        PTask task3 = new PTask("Task3", 2, emptyList); // Adding Task3
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        boolean scheduleVerified = Schedule.verifySchedule(tasks);
        assertFalse(scheduleVerified);
    }
    

    public static void main(String[] args) {
        junit.textui.TestRunner.run(ScheduleDriverTest.class);
        //junit.swingui.TestRunner.run(ScheduleDriverTest.class);
    }

}
