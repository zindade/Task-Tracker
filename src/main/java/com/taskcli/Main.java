package main.java.com.taskcli;


public class Main {
    public static void main(String[] args) {
        System.out.println("Task CLI up! Args: " + String.join(" ", args));
    }
}

/*
cli - interprect args and call service or instance commands and run
task - taskdone , tasktodo

taskStore- I/o tasks.json
domain.task
domain.status
store.taskstore - read/write task.json
taskService -add/update /delete /mark /list
commands - command.java , addcommand.java ,updateCommand ,deleteCommand,Markcommand.java
 */


/*
src/main/java/com/daniel/taskcli/
  Main.java                // arranque da app
  Cli.java                 // parsing de argumentos + dispatch
  domain/
    Task.java              // modelo
    Status.java            // enum: TODO, IN_PROGRESS, DONE
  service/
    TaskService.java       // regras de negócio
  store/
    TaskStore.java         // I/O do tasks.json
  util/
    JsonUtil.java          // (opcional) serialização simples
    IdGenerator.java       // (opcional) próximo ID
    Printer.java           // (opcional) formatação de listas
  errors/
    TaskNotFoundException.java
    ValidationException.java
  commands/                // (opcional) se quiseres “Command Pattern”
    Command.java
    AddCommand.java
    UpdateCommand.java
    DeleteCommand.java
    MarkCommand.java
    ListCommand.java

 */