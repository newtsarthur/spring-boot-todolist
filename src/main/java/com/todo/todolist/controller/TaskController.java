package com.todo.todolist.controller;

import com.todo.todolist.model.Task;
import com.todo.todolist.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
  private final TaskService service;

  public TaskController(TaskService service) {
      this.service = service;
  }

  @GetMapping
  public List<Task> getAll() {
    return service.getAllTasks();
  }

  @PostMapping
  public Task create(@RequestBody Task task) {
    return service.createTask(task);
  }
  
  @DeleteMapping("/{id}")
  public void delete(@PathVariable UUID id) {
      service.deleteTask(id);
  }
}