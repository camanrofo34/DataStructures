/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.model.guia;

import org.model.priorityQueue.list.PriorityQueue;
import org.model.util.iterator.Iterator;

/**
 *
 * @author PC 4060TI
 */
public class Main {

    public static void main(String[] args) {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(3);
        System.out.println(priorityQueue.size());
        priorityQueue.insert(0, "Miku");
        priorityQueue.insert(2, "Rin");
        priorityQueue.insert(1, "Len");

        System.out.println(priorityQueue.size());
        Iterator<String> iterator = priorityQueue.iterator();
        while (iterator.hasNext()) {
            String task = iterator.next();
            System.out.println(task);
        }
        System.out.println(priorityQueue.extract());
        System.out.println(priorityQueue.extract());
        System.out.println(priorityQueue.extract());
        System.out.println(priorityQueue.size());
        while (iterator.hasNext()) {
            String task = iterator.next();
            System.out.println(task);
        }

    }
}
