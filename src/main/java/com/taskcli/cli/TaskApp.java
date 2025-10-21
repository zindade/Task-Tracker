package main.java.com.taskcli.cli;

import main.java.com.taskcli.service.TaskService; // ajusta ao teu package real se precisares
import java.util.Scanner;

public class TaskApp {

    private TaskService taskService;         // instanciar mais tarde
    private final Scanner scanner = new Scanner(System.in);

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
                    addCommand(args);           // ← agora aceita: add "levar lixo"
                    break;
                case "list":
                    listCommand();              // mock
                    break;
                case "delete":
                    DeleteCommand(args);     // mock
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

        // TODO: quando tiveres o service: taskService.add(new Task(description));
        System.out.println("OK (mock): task would be added -> " + description);
    }

    // --- mocks (só para compilar por enquanto) ---
    private void DeleteCommand(String args) {
        String description = stripQuotes(args).trim();
        if (description.isEmpty()) {
            System.out.println("Error: description is required. Usage: delete \"your task\"");
        }
    }

    private void listCommand() {
        System.out.println("Only these commands are available:");
        System.out.println("delete");
        System.out.println("add");
        System.out.println("list");
        System.out.println("update");
        System.out.println("findByStatus");
        System.out.println("findById");
    }


    private void UpdateCommand(String args) {
        String description = stripQuotes(args).trim();

    }
    private void findByStatus(String args) {

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

/*
findByStatus(...)            // filtra por status
findByPriority(...)          // filtra por prioridade
markAsDone(...)              // altera o estado para “DONE”
getOverdueTasks(...)
 */