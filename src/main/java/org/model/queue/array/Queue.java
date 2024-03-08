/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.model.queue.array;

import java.util.function.Function;
import org.model.array.Array;
import org.model.util.collection.Collection;
import org.model.util.iterator.Iterator;
import org.model.util.queue.AbstractQueue;

/**
 *
 * @author admin
 */
public class Queue<E> extends AbstractQueue<E> {
    Array<E> queue;
    int dimension;
    int head;
    int tail;

    public Queue(int dimension) {
        this.dimension = dimension;
        this.queue = new Array<>(dimension);
        this.head=0;
        this.tail=0;
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
        return new Iterator<>(){
            int count = 0;
            @Override
            public boolean hasNext() {
                return count++<queue.size();
            }

            @Override
            public E next() {
                if (head<dimension) return 
            }   
        };
    }

    @Override
    public E peek() {
        return queue.get(head);
    }

    @Override
    public E extract() {
        E element = peek();
        queue.remove(head++);
        return element;
    }

    @Override
    public boolean insert(E element) {
        queue.set(tail++, element);
        tail = tail%dimension;
        return true;
    }
}
