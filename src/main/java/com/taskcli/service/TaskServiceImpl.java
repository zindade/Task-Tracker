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
        Status newStatus = null;

        if (s.equals("in-progress")){
            newStatus = Status.IN_PROGRESS;
            updated = true;
        } else if (s.equals("done")){
            newStatus = Status.DONE;
            updated = true;
        }

        if (updated) {

            t.setStatus(newStatus);



            return repo.updateStatus(t);








        }

        return updated;
    }
}
