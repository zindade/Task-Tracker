# 🧩 Task Tracker CLI
https://roadmap.sh/projects/task-tracker

A simple Java Command Line Interface (CLI) application to manage tasks.
It supports adding, listing, updating, deleting, and marking tasks as
in progress or done. Data is stored in a local JSON file (`tasks.json`)
so it persists between sessions.

---

## 🚀 Features

- ➕ Add tasks with a description
- 📋 List all tasks or filter by status (`todo`, `in-progress`, `done`)
- ✏️ Update a task description
- 🗑️ Delete tasks by ID
- ✅ Mark tasks as `in-progress` or `done`
- 💾 Persistent storage in `tasks.json`

---

## ✅ Requirements

- Java 17+
- Maven 3.8+

---

## ▶️ Running the app

```bash
mvn -q exec:java
```

You will enter an interactive prompt:

```text
Task Tracker CLI. Type 'help'.
>
```

---

## 🧪 Usage

```text
add "Read a book"
list
list todo
list in-progress
list done
update 2 "Read two books"
delete 3
mark-in-progress 2
mark-done 2
help
```

---

## 🗂️ Project Structure

```text
src/
  main/java/com/taskcli/
    Application.java           # Entry point
    cli/TaskApp.java           # Command parsing and routing
    model/Task.java            # Task entity
    domain/Status.java         # Task status enum
    repository/TaskRepository* # Storage interfaces and JSON impl
    service/TaskService*       # Business logic
tasks.json                     # Local storage (created/updated at runtime)
pom.xml                        # Maven config
```

---

## 📌 Notes

- `tasks.json` is created/updated in the project root when you run the CLI.
- Status values are stored as `TODO`, `IN_PROGRESS`, and `DONE` in JSON.
