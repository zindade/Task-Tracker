package com.taskcli.repository;

import com.taskcli.domain.Status;
import com.taskcli.model.Task;
import java.util.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TaskRepositoryImpl implements TaskRepository {


    private final Map<Integer, Task> tasks = new HashMap<>();
    private int nextId = 1;
    private static final String FILE_PATH ="tasks.json";
    private final Gson gson ;


    public  TaskRepositoryImpl() {
        this.gson = new GsonBuilder()
                .setPrettyPrinting();
        .create();

    }


    @Override
    public Task add(Task task) {
        int id = nextId++;
        task.setId(id);
        tasks.put(id, task);
        return task;
    }

    @Override
    public boolean delete(int taskId) {
        return tasks.remove(taskId) != null;
    }

    @Override
    public boolean update(int taskId, String args) {
        Task task = tasks.get(taskId);
        if (task == null || args == null) {
            return false;
        }

        task.setDescription(args);
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
}
