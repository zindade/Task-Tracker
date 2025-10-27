package com.taskcli.cli;



import com.taskcli.model.Task;
import com.taskcli.service.TaskService;
import com.taskcli.service.TaskServiceImpl;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskApp {

    private final TaskService taskService = new TaskServiceImpl();
    private final Scanner scanner = new Scanner(System.in);

    public TaskApp() {}


    public void dispatch(String line) {
        if (line == null) {
            System.out.println("unknown command");
            return;
        }
        line = line.trim().toLowerCase();
        if (line.isEmpty()) {
            System.out.println("unknown command");
            return;
        }
        String cmd = "";
        String args = "";

        if (line.startsWith("mark")) {

            cmd = line.split("-")[0];
            args = line;

        }else {
            int i = line.indexOf(' ');

            cmd = (i == -1) ? line.toLowerCase() : line.substring(0, i).toLowerCase();
            args = (i == -1) ? "" : line.substring(i + 1).trim();
        }

        try {
            switch (cmd) {
                case "add":
                    addCommand(args);
                    break;
                case "list":
                    listCommand(args);
                    break;
                case "delete":
                    deleteCommand(args);
                    break;
                case "help":
                    helpCommand();
                    break;
                case "update":
                    updateCommand(args);
                    break;
                case "mark":
                    markCommand(args);
                    break;
                default:
                    System.out.println("unknown command " + cmd);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void markCommand(String args) {

        if (args.isEmpty()) {
            System.out.println("Not a valid mark command");
            return;
        }

        int taskId = Integer.parseInt(args.split(" ")[1]);

        boolean t = false;
        if (args.startsWith("mark-in-progress")) {

            t = taskService.markUpdate("in-progress", taskId);
        }

        if (args.startsWith("mark-done")) {

            t = taskService.markUpdate("done", taskId);
        }

        if (t) {
            System.out.println("Mark updated successfully");
            return;
        }
        System.out.println("Mark update failed");

    }

    private void updateCommand(String args) {
        int taskId = Integer.parseInt(args.split(" ")[0]);
        String description = strip(args);
        if (Objects.equals(description, "Error")) {
            System.out.println("Description is invalid");
            return;
        }
        boolean t = taskService.updateTask(taskId, description);

        if (t) {
            System.out.println("Task updated successfully");
            return;
        }
        System.out.println("Task update failed");
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

    private void listCommand(String args) {
        List<Task> tasks = taskService.listTasks(args);
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

    private String strip(String str) {
        if (str == null) return "";
        String regex = "\"([^\"]*)\"";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        if (matcher.find()) {
            return matcher.group(1);
        } else  {
            return "Error";
        }

    }
}
