package main.java.com.taskcli.cli;

import main.java.com.taskcli.service.TaskService;
// import main.java.com.taskcli.persistence.TaskRepository; // (removido por não usado)
// import main.java.com.taskcli.service.TaskServiceImpl;    // (removido por não usado)

import java.util.Scanner;

public class TaskApp {

    private TaskService taskService;
    private final Scanner scanner = new Scanner(System.in);

    public TaskApp() {
        // construtor vazio por agora
    }

    public static void main(String[] args) {
        TaskApp app = new TaskApp();

        Scanner sc = new Scanner(System.in);
        System.out.print("> ");
        String cmd = sc.nextLine().trim();

        try {
            switch (cmd) {
                case "add":

                    app.AddCommand(new String[]{});
                    break;
                case "list":
                    app.ListCommand();
                    break;
                default:
                    System.out.println("unknown command " + cmd);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }

    private void AddCommand(String[] args) {
        if (args == null || args.length < 2) {
            throw new IllegalArgumentException("Usage: task-cli add \"description\" [--assignee-id <id>]");
        }
        String description = args[1].trim();
        if (description.isEmpty()) {
            throw new IllegalArgumentException("Description cannot be empty.");
        }


    }

    private void ListCommand() {

    }

    private void UpdateCommand() {

    }
}
