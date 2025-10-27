package com.taskcli.repository;

import com.taskcli.domain.Status;
import com.taskcli.model.Task;
import com.taskcli.service.TaskServiceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskFileHandler {

    private static final String FILENAME = "tasks.json";
    private static final Path FILE_PATH = Path.of(FILENAME);



    public static List<Task> readTasks() {
        List<Task> tasks = new ArrayList<>();

        if (!Files.exists(FILE_PATH)) {
            try {
                Files.writeString(FILE_PATH, "[]");
            } catch (IOException e) {
                System.err.println("Erro ao criar o arquivo JSON: " + e.getMessage());
            }
            return tasks;
        }

        try {
            String jsonContent = Files.readString(FILE_PATH);


            if (jsonContent.trim().length() > 2) {
                String contentWithoutBrackets = jsonContent.trim().substring(1, jsonContent.length() - 1);


                String[] jsonObjects = contentWithoutBrackets.split("},\\s*\\{");

                for (int i = 0; i < jsonObjects.length; i++) {
                    String taskJson = jsonObjects[i];
                    if (i > 0) {
                        taskJson = "{" + taskJson;
                    }
                    if (i < jsonObjects.length - 1) {

                        taskJson = taskJson + "}";
                    }

                    if (!taskJson.trim().isEmpty()) {

                        tasks.add(fromJsonString(taskJson));
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo JSON: " + e.getMessage());
        }

        return tasks;
    }

    public static void writeTasks(List<Task> tasks) {
        List<String> jsonStrings = new ArrayList<>();

        for (Task task : tasks) {
            jsonStrings.add(toJsonString(task));
        }


        String innerContent = String.join(",\n  ", jsonStrings);


        String finalJson = "[\n  " + innerContent + "\n]";

        try {

            Files.writeString(FILE_PATH, finalJson);
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo JSON: " + e.getMessage());
        }
    }

    public static String toJsonString(Task task) {
        String createdAtStr = task.getCreatedAt().format(Task.FORMATTER);
        String updatedAtStr = task.getUpdatedAt().format(Task.FORMATTER);

        return String.format(
                "{\"id\": %d, \"description\": \"%s\", \"status\": \"%s\", \"createdAt\": \"%s\", \"updatedAt\": \"%s\"}",
                task.getId(),
                task.getDescription().replace("\"", "\\\""),
                task.getStatus().name(),
                createdAtStr,
                updatedAtStr
        );
    }


    public static Task fromJsonString(String json) {
        json = json.trim().substring(1, json.length() - 1);

        String[] parts = json.split(",\\s*");
        int id = 0;
        String description = "";
        Status status = null;
        LocalDateTime createdAt = null;
        LocalDateTime updatedAt = null;

        for (String part : parts) {
            String[] keyValue = part.split(":\\s*", 2);
            if (keyValue.length < 2) continue;

            String key = keyValue[0].replaceAll("\"", "").trim();
            String value = keyValue[1].replaceAll("\"", "").trim();

            switch (key) {
                case "id":
                    try {
                        id = Integer.parseInt(value);
                    } catch (NumberFormatException ignored) {}
                    break;
                case "description":
                    description = value.replace("\\\"", "\"");
                    break;
                case "status":
                    try {
                        status = Status.valueOf(value.toUpperCase());
                    } catch (IllegalArgumentException e) {
                        status = Status.TODO;
                    }
                    break;
                case "createdAt":
                    try {
                        createdAt = LocalDateTime.parse(value, Task.FORMATTER);
                    } catch (Exception ignored) {}
                    break;
                case "updatedAt":
                    try {
                        updatedAt = LocalDateTime.parse(value, Task.FORMATTER);
                    } catch (Exception ignored) {}
                    break;
            }
        }

        return new Task(id, description, status, createdAt, updatedAt);

    }

}
