package com.taskcli.service;

import com.taskcli.domain.Status;
import com.taskcli.model.Task;
import com.taskcli.repository.TaskFileHandler;
import com.taskcli.repository.TaskRepository;
import com.taskcli.repository.TaskRepositoryImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class TaskServiceImpl implements TaskService {

    private final TaskRepository repo;

    public TaskServiceImpl() {
        this.repo = new TaskRepositoryImpl();
    }

    @Override
    public Task addTask(String description) {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("description cannot be empty");
        }
        Task t = new Task(description);
        return repo.add(t);
    }

    @Override
    public List<Task> listTasks(String args) {
        return repo.findAll(args);
    }

    @Override
    public boolean deleteTask(int taskId) {
        return repo.delete(taskId);
    }

    @Override
    public boolean updateTask(int taskId,String args) {

        return repo.update(taskId, args);
    }

    @Override
    public Optional<Task> getById(int taskId) {
        return repo.findById(taskId);
    }

    @Override
    public boolean markUpdate(String s, int taskId) {
        Task t = repo.getTaskById(taskId);
        if (t == null) return false;

        boolean updated = false;
        Status newStatus = null; // Use uma variável para o novo status

        if (s.equals("in-progress")){
            newStatus = Status.IN_PROGRESS;
            updated = true;
        } else if (s.equals("done")){
            newStatus = Status.DONE;
            updated = true;
        }

        if (updated) {
            // 1. Atualiza o status e a data (feita pela Task)
            t.setStatus(newStatus);

            // 2. PEDE AO REPOSITÓRIO para salvar (persistir a mudança).
            // Isso é mais limpo do que chamar a persistência diretamente no Service.
            // Já que TaskRepositoryImpl.update não é ideal para status,
            // crie um método específico no TaskRepository.

            // Assumindo que você adiciona um método 'updateStatus' no TaskRepository
            return repo.updateStatus(t);

            // Alternativa Rápida (Mas menos limpa):
            // A sua Task já foi modificada via referência.
            // Chame um método simples no Repo para persistir o Map atual.
            // return repo.persistCurrentState();

            // POR ENQUANTO, para manter o que você tem, adicione o método `updateStatus` ao Repositório.
            // return repo.updateStatus(t); // Melhor
        }

        return updated;
    }
}
