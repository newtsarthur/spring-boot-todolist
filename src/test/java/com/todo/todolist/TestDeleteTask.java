package com.todo.todolist;

import com.todo.todolist.repository.TaskRepository;
import com.todo.todolist.service.TaskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class TestDeleteTask {

    @Mock
    private TaskRepository repository;

    @InjectMocks
    private TaskService service;

    @Test
    void testDeleteTaskSuccess() {
        UUID taskId = UUID.randomUUID();

        Mockito.when(repository.existsById(taskId)).thenReturn(true);

        service.deleteTask(taskId);

        Mockito.verify(repository).deleteById(taskId);
    }

    @Test
    void testDeleteTaskNotFound() {
        UUID taskId = UUID.randomUUID();

        Mockito.when(repository.existsById(taskId)).thenReturn(false);

        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteTask(taskId);
        });

        Mockito.verify(repository, Mockito.never()).deleteById(taskId);
    }
}
