package main.java.com.taskcli;

import java.util.Scanner;

import main.java.com.taskcli.cli.TaskApp;

public class Application {

    public static void main(String[] args) {
        TaskApp app = new TaskApp();
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("> ");
            String cmd = sc.nextLine().trim();
            app.dispatch(cmd);
        }
    }
}
