/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.model.LinkedList.TaskManager;

import java.util.function.ToIntFunction;
import org.model.LinkedList.singly.LinkedList;
import org.model.array.Array;
import org.model.util.iterator.Iterator;

/**
 *
 * @author PC 4060TI
 */
public class TaskManagerImpl implements TaskManagerInterface{
    LinkedList<Task> tasks = new LinkedList<>();

    @Override
    public boolean addTask(String taskName, int priority) {
        if (searchByName(taskName)== null){
            tasks.add(new Task(taskName,priority));
            tasks.sort(e -> e.getPriority());
            return true;
        }
        return false;
    }

    @Override
    public boolean removeTask(String taskName) {
        Task task =searchByName(taskName);
        if (task!=null){
            return tasks.remove(task);
        }
        return false;
    }

    @Override
    public boolean markComplete(String taskName) {
        Task task =searchByName(taskName);
        if (task!=null){
            task.setCompletion(true);
            return true;
        }
        return false;
    }

    @Override
    public Array displayTasks() {
        Array<Task> displayedTasks = new Array<>(tasks.size());
        displayedTasks.add(0, tasks);
        return displayedTasks;
    }

    @Override
    public boolean removeCompletedTasks() {
        return tasks.remove(e -> e.isCompletion());
    }

    @Override
    public Array sortTasksByName() {
        Array<Task> displayedTasks = new Array<>(tasks.size());
        displayedTasks.add(0, tasks);
        int i, j;
        Task aux;
        for (i = 0; i < displayedTasks.size() - 1; i++) {
            for (j = 0; j < displayedTasks.size() - i - 1; j++) {   
                String firstName = displayedTasks.get(j + 1).getTaskName().toLowerCase();
                String secondName = displayedTasks.get(j).getTaskName().toLowerCase();
                if (firstName.compareToIgnoreCase(secondName)<0) {
                    aux = displayedTasks.get(j+1);
                    displayedTasks.set(j+1, displayedTasks.get(j));
                    displayedTasks.set(j, aux);
                }
            }
        }
        return displayedTasks;
    }
    
    private Task searchByName(String taskName){
        Iterator<Task> iterator = tasks.iterator();
        while(iterator.hasNext()){
            Task task = iterator.next();
            if (task.getTaskName().equals(taskName)){
                return task;
            }
        }
        return null;
    }
    
}
