/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.model.priorityQueue.list;

import java.util.NoSuchElementException;
import java.util.function.Function;
import org.model.array.Array;
import org.model.queue.list.Queue;
import org.model.util.collection.Collection;
import org.model.util.iterator.Iterator;
import org.model.util.queue.AbstractPriorityQueue;

public class PriorityQueue<E> extends AbstractPriorityQueue<E> {

    Array<Queue<E>> prioridad;
    int prioridades;
    int size;

    public PriorityQueue(int n) {
        this.size = 0;
        this.prioridad = new Array<>(n);
        this.prioridades = n;
        for (int i = 0; i < n; i++) {
            prioridad.add(new Queue<>());
        }
    }

    @Override
    public boolean clear() {
        for (int i = 0; i < prioridades; i++) {
            prioridad.get(i).clear();
        }
        size = 0;
        return true;
    }

    @Override
    public boolean contains(E element) {
        for (int i = 0; i < prioridades; i++) {
            if (prioridad.get(i).contains(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(E[] array) {
        for (E element : array) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean contains(Collection<E> collection) {
        Iterator<E> iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (!contains(iterator.next())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean reverse() {

        for (int i = 0; i < prioridades; i++) {
            prioridad.get(i).reverse();
        }
        prioridad.reverse();
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void forEach(Function<E, Void> action) {
        for (int i = 0; i < prioridades; i++) {
            prioridad.get(i).forEach(action);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int i = 0;
            Iterator<E> iteradorElementos = prioridad.get(i).iterator();

            @Override
            public boolean hasNext() {
                while (!iteradorElementos.hasNext() && i < prioridad.size() - 1) {
                    iteradorElementos = prioridad.get(++i).iterator();
                }
                return iteradorElementos.hasNext();
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No hay más elementos");
                }
                return iteradorElementos.next();
            }

        };
    }

    @Override
    public boolean insert(E element) {
        prioridad.get(prioridades - 1).insert(element);
        size++;
        return true;
    }

    @Override
    public boolean insert(int index, E element) {
        prioridad.get(index).insert(element);
        size++;
        return true;
    }

    @Override
    public E peek() {
        for (int i = 0; i < prioridades; i++) {
            if (prioridad.get(i).size() != 0) {
                return prioridad.get(i).peek();
            }
        }
        return null;
    }

    @Override
    public E extract() {
        for (int i = 0; i < prioridades; i++) {
            if (prioridad.get(i).size() != 0) {
                size--;
                return prioridad.get(i).extract();
            }
        }
        return null;
    }

}
