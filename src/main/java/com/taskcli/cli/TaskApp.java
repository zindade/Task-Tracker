package com.taskcli.cli;



import com.taskcli.model.Task;
import com.taskcli.service.TaskService;
import com.taskcli.service.TaskServiceImpl;

import java.util.List;
import java.util.Scanner;

public class TaskApp {

    private final TaskService taskService = new TaskServiceImpl();

    public TaskApp() {}


    public void dispatch(String line) {
        if (line == null) {
            System.out.println("unknown command");
            return;
        }
        line = line.trim();
        if (line.isEmpty()) {
            System.out.println("unknown command");
            return;
        }

        int i = line.indexOf(' ');
        String cmd  = (i == -1) ? line.toLowerCase() : line.substring(0, i).toLowerCase();
        String args = (i == -1) ? ""                 : line.substring(i + 1).trim();

        try {
            switch (cmd) {
                case "add":
                    addCommand(args);           // add "levar lixo"
                    break;
                case "list":
                    listCommand();
                    break;
                case "delete":
                    deleteCommand(args);        // delete 3
                    break;
                case "help":
                    helpCommand();
                    break;
                case "exit":
                    System.out.println("bye");
                    System.exit(0);
                    break;

                default:
                    System.out.println("unknown command " + cmd);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void addCommand(String args) {
        String description = stripQuotes(args).trim();
        if (description.isEmpty()) {
            System.out.println("Error: description is required. Usage: add \"your task\"");
            return;
        }

        Task t = taskService.addTask(description);
        System.out.println("OK: created task " + t.getId() + " -> " + t.getDescription());
    }

    private void deleteCommand(String args) {
        if (args.isBlank()) {
            System.out.println("Error: id is required. Usage: delete 3");
            return;
        }
        int id;
        try {
            id = Integer.parseInt(args);
        } catch (NumberFormatException e) {
            System.out.println("Error: id must be a number. Usage: delete 3");
            return;
        }

        boolean removed = taskService.deleteTask(id);
        if (removed) {
            System.out.println("OK: task " + id + " deleted");
        } else {
            System.out.println("Task " + id + " not found");
        }
    }

    private void listCommand() {
        List<Task> tasks = taskService.listTasks();
        if (tasks.isEmpty()) {
            System.out.println("no tasks to display");
            return;
        }

        System.out.println("Task list:");
        for (Task t : tasks) {
            System.out.println("[" + t.getId() + "] " + t.getDescription() + " (" + t.getStatus() + ")");
        }
    }

    private void helpCommand() {
        System.out.println("Commands:");
        System.out.println("  add \"description\"   -> add new task");
        System.out.println("  list                  -> list tasks");
        System.out.println("  delete <id>           -> delete task by id");
        System.out.println("  help                  -> show this help");
    }

    private String stripQuotes(String s) {
        if (s == null) return "";
        s = s.trim();
        if (s.length() >= 2) {
            char first = s.charAt(0);
            char last  = s.charAt(s.length() - 1);
            if ((first == '"' && last == '"') || (first == '\'' && last == '\'')) {
                return s.substring(1, s.length() - 1).trim();
            }
        }
        return s;
    }
}
