package com.todo.todolist;

import com.todo.todolist.model.Task;
import com.todo.todolist.repository.TaskRepository;
import com.todo.todolist.service.TaskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Assertions;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class TestCreateTask {

    @Mock
    private TaskRepository repository;

    @InjectMocks
    private TaskService service;

    @Test
    void testCreateTask() {
        Task task = new Task();
        task.setId(UUID.randomUUID());
        task.setDescription("Nova Tarefa");
        task.setCompleted(false);

        Mockito.when(repository.save(Mockito.any(Task.class))).thenReturn(task);

        Task result = service.createTask(task);

        Assertions.assertNotNull(result);
        Assertions.assertEquals("Nova Tarefa", result.getDescription());
        Assertions.assertFalse(result.isCompleted());
    }
}
