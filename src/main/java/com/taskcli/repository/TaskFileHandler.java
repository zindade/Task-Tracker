package com.taskcli.repository;

import com.taskcli.domain.Status;
import com.taskcli.model.Task;

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
                System.err.println("Error creating JSON file: " + e.getMessage());
            }
            return tasks;
        }

        try {
            String raw = Files.readString(FILE_PATH);
            String jsonContent = raw == null ? "" : raw.trim();


            if (jsonContent.isEmpty() || jsonContent.equals("[]")) {
                return tasks; // lista vazia
            }


            if (jsonContent.startsWith("[") && jsonContent.endsWith("]") && jsonContent.length() > 2) {
                jsonContent = jsonContent.substring(1, jsonContent.length() - 1).trim();
            } else {

                System.err.println("Warning: tasks.json format is not an array. Skipping load.");
                return tasks;
            }


            String[] jsonObjects = jsonContent.split("},\\s*\\{");

            for (int i = 0; i < jsonObjects.length; i++) {
                String taskJson = jsonObjects[i].trim();


                if (!taskJson.startsWith("{")) {
                    taskJson = "{" + taskJson;
                }
                if (!taskJson.endsWith("}")) {
                    taskJson = taskJson + "}";
                }

                if (!taskJson.isBlank()) {
                    Task t = fromJsonString(taskJson);
                    if (t != null) {
                        tasks.add(t);
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading JSON: " + e.getMessage());
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
            System.err.println("Error writing JSON: " + e.getMessage());
        }
    }

    // Converte um Task -> JSON manual
    public static String toJsonString(Task task) {
        String createdAtStr = task.getCreatedAt().format(Task.FORMATTER);
        String updatedAtStr = task.getUpdatedAt().format(Task.FORMATTER);

        return String.format(
                "{ \"id\": %d, \"description\": \"%s\", \"status\": \"%s\", \"createdAt\": \"%s\", \"updatedAt\": \"%s\" }",
                task.getId(),
                task.getDescription().replace("\"", "\\\""),
                task.getStatus().name(),
                createdAtStr,
                updatedAtStr
        );
    }

    public static Task fromJsonString(String json) {
        if (json == null) {
            return null;
        }

        String clean = json.trim();


        if (clean.length() < 2 || !clean.startsWith("{") || !clean.endsWith("}")) {
            System.err.println("Skipping invalid task JSON: " + clean);
            return null;
        }


        clean = clean.substring(1, clean.length() - 1).trim();


        String[] parts = clean.split(",\\s*");

        int id = 0;
        String description = "";
        Status status = Status.TODO;
        LocalDateTime createdAt = null;
        LocalDateTime updatedAt = null;

        for (String part : parts) {
            String[] keyValue = part.split(":\\s*", 2);
            if (keyValue.length < 2) continue;

            String key = keyValue[0].replaceAll("\"", "").trim();
            String value = keyValue[1].trim();


            value = value.replaceAll("^\"|\"$", "");
            value = value.replace("\\\"", "\"");

            switch (key) {
                case "id":
                    try {
                        id = Integer.parseInt(value);
                    } catch (NumberFormatException ignored) {}
                    break;
                case "description":
                    description = value;
                    break;
                case "status":
                    try {
                        status = Status.valueOf(value.toUpperCase());
                    } catch (IllegalArgumentException ignored) {
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
