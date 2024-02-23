/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.model.LinkedList.TaskManager;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.model.array.Array;

/**
 *
 * @author PC 4060TI
 */
public class TaskManagerImplTest {

    TaskManagerImpl tasks = new TaskManagerImpl();

    @Test
    void addTest() {
        tasks.addTask("Alcacelcer", 56);
        tasks.addTask("Adsds", 51);
        tasks.addTask("Camanrofo", 1);
        Task[] expected = {new Task("Camanrofo", 1), new Task("Adsds", 51), new Task("Alcacelcer", 56)};
        Array<Task> devolved = tasks.displayTasks();
        for (int i = 0; i < devolved.size(); i++) {
            assertEquals(devolved.get(i).getTaskName(), expected[i].getTaskName());
        }
    }

    @Test
    void removeTask() {
        tasks.addTask("Alcacelcer", 56);
        tasks.addTask("Adsds", 51);
        tasks.addTask("Camanrofo", 1);
        assertTrue(tasks.removeTask("Camanrofo"));
        Task[] expected = {new Task("Adsds", 51), new Task("Alcacelcer", 56)};
        Array<Task> devolved = tasks.displayTasks();
        for (int i = 0; i < devolved.size(); i++) {
            assertEquals(devolved.get(i).getTaskName(), expected[i].getTaskName());
        }
    }

    @Test
    void markAsComplete() {
        tasks.addTask("Alcacelcer", 56);
        tasks.addTask("Adsds", 51);
        tasks.addTask("Camanrofo", 1);
        assertTrue(tasks.markComplete("Camanrofo"));
        Task task = new Task("Camanrofo", 1);
        task.setCompletion(true);
        Task[] expected = {task, new Task("Adsds", 51), new Task("Alcacelcer", 56)};
        Array<Task> devolved = tasks.displayTasks();
        for (int i = 0; i < devolved.size(); i++) {
            assertEquals(devolved.get(i).getTaskName(), expected[i].getTaskName());
            assertEquals(devolved.get(i).isCompletion(), expected[i].isCompletion());
        }
    }

    @Test
    void removeCompletedTasks() {
        tasks.addTask("Alcacelcer", 56);
        tasks.addTask("Adsds", 51);
        tasks.addTask("Camanrofo", 1);
        assertTrue(tasks.markComplete("Camanrofo"));
        Task task = new Task("Camanrofo", 1);
        task.setCompletion(true);
        assertTrue(tasks.removeCompletedTasks());
        Task[] expected = {new Task("Adsds", 51), new Task("Alcacelcer", 56)};
        Array<Task> devolved = tasks.displayTasks();
        for (int i = 0; i < devolved.size(); i++) {
            assertEquals(devolved.get(i).getTaskName(), expected[i].getTaskName());
        }
    }

    @Test
    void sortByName() {
        tasks.addTask("dadadada", 56);
        tasks.addTask("Zzz", 51);
        tasks.addTask("Camanrofo", 1);
        Array<Task> array = tasks.sortTasksByName();
        Task[] expected = { new Task("Camanrofo", 1), new Task("dadadada", 56), new Task("Zzz", 51) };
        for (int i = 0; i < array.size(); i++) {
            assertEquals(array.get(i).getTaskName(), expected[i].getTaskName());
        }
    }
    
    @Test
    void sortByNameInMinuscula() {
        tasks.addTask("dadadada", 56);
        tasks.addTask("zzz", 51);
        tasks.addTask("camanrofo", 1);
        Array<Task> array = tasks.sortTasksByName();
        Task[] expected = { new Task("camanrofo", 1), new Task("dadadada", 56), new Task("zzz", 51) };
        for (int i = 0; i < array.size(); i++) {
            assertEquals(array.get(i).getTaskName(), expected[i].getTaskName());
        }
    }
    
    @Test
    void sortByNameInMayusculas() {
        tasks.addTask("Dadadada", 56);
        tasks.addTask("Zzz", 51);
        tasks.addTask("Camanrofo", 1);
        Array<Task> array = tasks.sortTasksByName();
        Task[] expected = { new Task("Camanrofo", 1), new Task("Dadadada", 56), new Task("Zzz", 51) };
        for (int i = 0; i < array.size(); i++) {
            assertEquals(array.get(i).getTaskName(), expected[i].getTaskName());
        }
    }
    
    @Test
    void sortByAlmostSameNameInMayusculas() {
        tasks.addTask("Dadadada", 56);
        tasks.addTask("Cailou", 51);
        tasks.addTask("Camanrofo", 1);
        Array<Task> array = tasks.sortTasksByName();
        Task[] expected = { new Task("Cailou", 51), new Task("Camanrofo", 1), new Task("Dadadada", 56) };
        for (int i = 0; i < array.size(); i++) {
            assertEquals(array.get(i).getTaskName(), expected[i].getTaskName());
        }
    }
    
    @Test
    void sortBNameWithNumbers() {
        tasks.addTask("C1", 56);
        tasks.addTask("C2", 51);
        tasks.addTask("C3", 1);
        Array<Task> array = tasks.sortTasksByName();
        Task[] expected = { new Task("C1", 56), new Task("C2", 51), new Task("C3", 1) };
        for (int i = 0; i < array.size(); i++) {
            assertEquals(array.get(i).getTaskName(), expected[i].getTaskName());
        }
    }
}