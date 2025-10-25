package com.taskcli;

import java.util.Scanner;
import com.taskcli.cli.TaskApp;

public class Application {

    public static void main(String[] args) {
        TaskApp app = new TaskApp();

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Task Tracker CLI. Type 'help'.");
            while (true) {
                System.out.print("> ");
                String cmd = sc.nextLine().trim();
                app.dispatch(cmd);
            }
        }
    }
}
