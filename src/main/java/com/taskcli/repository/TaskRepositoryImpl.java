package com.taskcli.repository;


import com.taskcli.model.Task;
import java.util.*;

public class TaskRepositoryImpl implements TaskRepository {

    private final Map<Integer, Task> tasks;
    private int nextId = 1;

    public TaskRepositoryImpl() {

        List<Task> loadedTasks = TaskFileHandler.readTasks();
        this.tasks = new HashMap<>();

        if (!loadedTasks.isEmpty()) {
            int maxId = 0;
            for (Task task : loadedTasks) {
                this.tasks.put(task.getId(), task);
                if (task.getId() > maxId) {
                    maxId = task.getId();
                }
            }
            this.nextId = maxId + 1;
        }
    }

    @Override
    public Task add(Task task) {
        task.setId(nextId++);
        tasks.put(task.getId(), task);
        TaskFileHandler.writeTasks(new ArrayList<>(tasks.values()));
        return task;
    }

    @Override
    public boolean delete(int taskId) {
        boolean removed = tasks.remove(taskId) != null;
        if (removed) {
            TaskFileHandler.writeTasks(new ArrayList<>(tasks.values()));
        }
        return removed;
    }

    @Override
    public boolean update(int taskId, String args) {
        Task task = tasks.get(taskId);
        if (task == null || args == null) {
            return false;
        }
        task.setDescription(args);
        task.setUpdatedAt();
        TaskFileHandler.writeTasks(new ArrayList<>(tasks.values()));
        return true;
    }


    @Override
    public List<Task> findAll(String args) {

        if (args == null || args.isEmpty()) {
            return new ArrayList<>(tasks.values());
        }

        List<Task> result = new ArrayList<>();

        for (Task task : tasks.values()) {

            System.out.println("args: " + args);
            System.out.println("status: " + task.getStatus().toString().toLowerCase().replace("_", "-"));

            System.out.println();
            if (args.equals(task.getStatus().toString().toLowerCase().replace("_", "-"))) {

                result.add(task);
            }
        }
        return result;
    }
    @Override
    public Task getTaskById(int taskId) {
        return tasks.get(taskId);
    }

    @Override
    public Optional<Task> findById(int taskId) {
        return Optional.ofNullable(tasks.get(taskId));
    }

    @Override
    public boolean updateStatus(Task task) {
        if (tasks.containsKey(task.getId())) {
            TaskFileHandler.writeTasks(new ArrayList<>(tasks.values()));
            return true;
        }
        return false;
    }
}
