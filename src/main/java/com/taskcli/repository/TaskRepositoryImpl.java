package main.java.com.taskcli.repository;

import main.java.com.taskcli.model.Task;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class TaskRepositoryImpl implements  TaskRepository{



    private Map<Integer, Task> tasks = new HashMap<>();
    private int nextId = 1;

    public void addTask(Task task) {
        int taskId = nextId++;
        tasks.put(taskId,task);
        System.out.println("task added with ID: "+ taskId);
    }

    public getTask(int taskId) {
        tasks.remove(taskId);
    }

    public void displayAllTasks() {
        if(tasks.isEmpty()){
            System.out.println("no task to display ");
            return;
        }
        for(Map.Entry<Integer,Task> entry : tasks.entrySet()) {
            Integer taskId = entry.getKey();
            Task task = entry.getValue();
            System.out.println("Task ID" + taskId);
            System.out.println("Description: " + task.getDescription());
            System.out.println("Status: " + task.getStatus());
            System.out.println("Assignee: " + task.getAssignee());
            System.out.println("--------------------");
        }
    }
}
