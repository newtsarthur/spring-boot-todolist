package com.todo.todolist;

import com.todo.todolist.model.Task;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class TaskModelTest {

    @Test
    void testTaskCreation() {
        Task task = new Task();
        task.setId(UUID.randomUUID());
        task.setDescription("Testando a tarefa");
        task.setCompleted(true);

        assertNotNull(task.getId(), "ID não deve ser nulo");
        assertEquals("Testando a tarefa", task.getDescription(), "Descrição da tarefa está incorreta");
        assertTrue(task.isCompleted(), "A tarefa deve ser marcada como 'completed'");
    }

    @Test
    void testTaskWithNoData() {
        Task task = new Task();

        assertNull(task.getId(), "ID deve ser nulo inicialmente");
        assertNull(task.getDescription(), "Descrição deve ser nula inicialmente");
        assertFalse(task.isCompleted(), "A tarefa deve estar marcada como 'não completada' por padrão");
    }

    @Test
    void testSettersAndGetters() {
        Task task = new Task();
        UUID id = UUID.randomUUID();
        String description = "Tarefa de Teste";
        boolean completed = false;
        
        task.setId(id);
        task.setDescription(description);
        task.setCompleted(completed);

        assertEquals(id, task.getId(), "O ID da tarefa está incorreto");
        assertEquals(description, task.getDescription(), "A descrição da tarefa está incorreta");
        assertEquals(completed, task.isCompleted(), "O status da tarefa está incorreto");
    }

    @Test
    void testEquals() {
        Task task1 = new Task();
        task1.setId(UUID.randomUUID());
        task1.setDescription("Tarefa 1");
        task1.setCompleted(true);
    
        Task task2 = new Task();
        task2.setId(task1.getId());
        task2.setDescription("Tarefa 1");
        task2.setCompleted(true);
    
        Task task3 = new Task();
        task3.setId(UUID.randomUUID());
        task3.setDescription("Tarefa 3");
        task3.setCompleted(false);
    
        assertTrue(task1.equals(task2), "Tasks com os mesmos dados deveriam ser iguais");
        assertFalse(task1.equals(task3), "Tasks com dados diferentes deveriam ser diferentes");
    
        assertTrue(task1.canEqual(task2), "canEqual deveria retornar true para objetos do mesmo tipo");
        assertFalse(task1.canEqual(new Object()), "canEqual deveria retornar false para objetos de tipos diferentes");
    }
    

    @Test
    void testHashCode() {
        Task task1 = new Task();
        task1.setId(UUID.randomUUID());
        task1.setDescription("Tarefa 1");
        task1.setCompleted(true);
    
        Task task2 = new Task();
        task2.setId(task1.getId());
        task2.setDescription("Tarefa 1");
        task2.setCompleted(true);
    
        Task task3 = new Task();
        task3.setId(UUID.randomUUID());
        task3.setDescription("Tarefa 3");
        task3.setCompleted(false);
    
        assertEquals(task1.hashCode(), task2.hashCode(), "Tasks com os mesmos dados deveriam ter o mesmo hashCode");
        assertNotEquals(task1.hashCode(), task3.hashCode(), "Tasks com dados diferentes deveriam ter hashCodes diferentes");
    }
    
    @Test
    void testEqualsAndHashCode() {
        UUID id = UUID.randomUUID();

        Task task1 = new Task();
        task1.setId(id);
        task1.setDescription("Test Task");
        task1.setCompleted(true);

        Task task2 = new Task();
        task2.setId(id);
        task2.setDescription("Test Task");
        task2.setCompleted(true);

        assertEquals(task1, task2);
        assertEquals(task1.hashCode(), task2.hashCode());
    }

    @Test
    void testToString() {
        Task task = new Task();
        task.setId(UUID.randomUUID());
        task.setDescription("ToString Task");
        task.setCompleted(false);

        String expected = "Task{id=" + task.getId() + ", description='ToString Task', completed=false}";
        assertEquals(expected, task.toString());
    }
    

    @Test
    void testCanEqual() {
        Task task = new Task();
        assertTrue(task.canEqual(new Task()));
        assertFalse(task.canEqual("not a task"));
    }
}
