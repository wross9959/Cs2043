/*
 * To compile: javac -cp junit3.8.1.jar PTaskDriverTest.java PTask.java
 * To run: java -cp .:junit3.8.1.jar PTaskDriverTest.java
 * to get Junit Terminal text: junit.textui.TestRunner.run(PTaskDriverTest.class);
 * To get Junit GUI:  junit.swingui.TestRunner.run(PTaskDriverTest.class);
 */


import junit.framework.TestCase;

import java.util.ArrayList;

public class PTaskDriverTest extends TestCase{

    public void testConstructor() {
        ArrayList<String> preconditions = new ArrayList<>();
        preconditions.add("Preconditions 1");
        preconditions.add("Preconditions 2");

        PTask task = new PTask("Preconditions 1", 5, preconditions);

        assertEquals("Preconditions 1", task.getTaskID());
        assertEquals(5, task.getEffort());
        assertEquals(-1, task.getStartTime());
        assertEquals("Not Started", task.getStatus());
        assertEquals(preconditions, task.getPreconditions());
    }

    public void testSettersAndGetters() {
        PTask task = new PTask("Task3", 5, new ArrayList<>());

        task.setStatus("In progress");
        assertEquals("In Progress", task.getStatus());

        task.setStartTime(10);
        assertEquals(10, task.getStartTime());
    }

    public void testPreconditions() {
        ArrayList<String> preconditions = new ArrayList<>();
        preconditions.add("Preconditions 1");
        preconditions.add("Preconditions 1");

        PTask task = new PTask("Task3", 5, preconditions);

        assertEquals(preconditions, task.getPreconditions());

        // Modify preconditions and check if it reflects changes
        ArrayList<String> newPreconditions = new ArrayList<>();
        newPreconditions.add("Task4");
        task.setPreconditions(newPreconditions);

        assertEquals(newPreconditions, task.getPreconditions());
    }

    public static void main(String[] args) {
        //junit.textui.TestRunner.run(PTaskDriverTest.class);
        junit.swingui.TestRunner.run(PTaskDriverTest.class);
    }
    
}
