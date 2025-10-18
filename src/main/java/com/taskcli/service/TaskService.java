package main.java.com.taskcli.service;

import main.java.com.taskcli.model.Task;
import main.java.com.taskcli.domain.Status;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskService {


    Task changeStatus(UUID taskId, Status newStatus);

    Task assign(UUID taskId, UUID userId);

    Optional<Task> getById(UUID taskId);



    void delete(UUID taskId);


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
