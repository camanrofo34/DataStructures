/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.model.LinkedList.TaskManager;

import org.model.array.Array;

/**
 *
 * @author PC 4060TI
 */
public interface TaskManagerInterface {
    public boolean addTask(String taskName, int priority);
    public boolean removeTask(String taskName);
    public boolean markComplete(String taskName);
    public Array displayTasks();
    public boolean removeCompletedTasks();
    public Array sortTasksByName();
}
