package com.todo.todolist.service;

import com.todo.todolist.model.Task;
import com.todo.todolist.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task createTask(Task task) {
        return repository.save(task);
    }

    public void deleteTask(UUID id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Tarefa não encontrada para exclusão.");
        }
        repository.deleteById(id);
    }
}