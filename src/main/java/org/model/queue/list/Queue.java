/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.model.queue.list;

import java.util.function.Function;
import org.model.LinkedList.singly.LinkedList;
import org.model.util.collection.AbstractCollection;
import org.model.util.collection.Collection;
import org.model.util.iterator.Iterator;
import org.model.util.queue.AbstractQueue;

/**
 *
 * @author admin
 */
public class Queue<E> extends AbstractQueue<E>{

    LinkedList<E> queue;

    public Queue() {
        this.queue = new LinkedList<>();
    }
    
    
    @Override
    public boolean clear() {
        return queue.clear();
    }

    @Override
    public boolean contains(E element) {
        return queue.contains(element);
    }

    @Override
    public boolean contains(E[] array) {
        return queue.contains(array);
    }

    @Override
    public boolean contains(Collection<E> collection) {
        return queue.contains(collection);
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public boolean reverse() {
        return queue.reverse();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public void forEach(Function<E, Void> action) {
        queue.forEach(action);
    }

    @Override
    public Iterator<E> iterator() {
        return queue.iterator();
    }

    @Override
    public E peek() {
        return queue.peekLast();
    }

    @Override
    public E extract() {
        return queue.pollLast();
    }

    @Override
    public boolean insert(E element) {
        return queue.add(element);
    }
    
}
