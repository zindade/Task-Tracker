package com.taskcli.cli;
import com.taskcli.model.Task;
import com.taskcli.service.TaskService;
import com.taskcli.service.TaskServiceImpl;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    Task add(Task task);                 // guarda a task e devolve a mesma já com ID
    boolean delete(int taskId);         // true se apagou, false se não existia
    List<Task> findAll();               // listar todas
    Optional<Task> findById(int taskId);// procurar uma específica
}
