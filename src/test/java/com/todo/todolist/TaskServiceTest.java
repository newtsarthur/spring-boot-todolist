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

import java.util.List;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    @Mock
    private TaskRepository repository;

    @InjectMocks
    private TaskService service;

    @Test
    void testGetAllTasks() {
        Task task = new Task();
        task.setId(UUID.randomUUID());
        task.setDescription("Estudar JaCoCo");
        task.setCompleted(false);

        Mockito.when(repository.findAll()).thenReturn(List.of(task));

        List<Task> result = service.getAllTasks();

        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals("Estudar JaCoCo", result.get(0).getDescription());
    }
}
