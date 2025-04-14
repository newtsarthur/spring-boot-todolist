package com.todo.todolist;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.todo.todolist.controller.TaskController;
import com.todo.todolist.model.Task;
import com.todo.todolist.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAllTasks() throws Exception {
        when(service.getAllTasks()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/tasks"))
            .andExpect(status().isOk())
            .andExpect(content().json("[]"));
    }

    @Test
    void testCreateTask() throws Exception {
        Task task = new Task();
        task.setId(UUID.randomUUID());
        task.setDescription("Nova Tarefa");
        task.setCompleted(false);
    
        when(service.createTask(any(Task.class))).thenReturn(task);
    
        mockMvc.perform(post("/api/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(task)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.description").value("Nova Tarefa")); // Corrigido aqui
    }
    
    @Test
    void testDeleteTask() throws Exception {
        UUID taskId = UUID.randomUUID();

        doNothing().when(service).deleteTask(taskId);

        mockMvc.perform(delete("/api/tasks/" + taskId))
            .andExpect(status().isOk());
    }
}
