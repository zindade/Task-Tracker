package main.java.com.taskcli.service;

import main.java.com.taskcli.model.Task;
import main.java.com.taskcli.domain.Status;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskService {


    Task addTask(String description, Integer assigneeId);
    List<Task> listTasks();
    List<Task> listByStatus(Status status);

    Task changeStatus(int taskId, Status newStatus);

    Task assign(int taskId, int userId);

    Optional<Task> getById(int taskId);



    void delete(int taskId);


    /*
    addTask(...)                 // cria uma nova tarefa
updateTask(...)              // altera título, prioridade, etc.
deleteTask(...)              // remove tarefa por ID
listTasks(...)               // lista todas as tarefas
findByStatus(...)            // filtra por status
findByPriority(...)          // filtra por prioridade
markAsDone(...)              // altera o estado para “DONE”
getOverdueTasks(...)         // devolve tarefas fora de prazo

     */
}
