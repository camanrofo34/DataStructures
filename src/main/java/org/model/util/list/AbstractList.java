/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.model.util.list;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.model.util.collection.Collection;
import org.model.util.iterator.Iterator;

/**
 *
 * @author admin
 * @param <E>
 */
public abstract class AbstractList<E> implements List<E>, Collection<E>, Cloneable {

    protected int size;

    protected AbstractList() {
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E[] toArray() {
        Iterator<E> iterator = this.iterator();
        E[] toArray = (E[]) new Object[size];
        int i = 0;
        while (iterator.hasNext()) {
            toArray[i] = iterator.next();
            i++;
        }
        return toArray;
    }

    @Override
    public boolean add(E[] array) {
        try {
            for (E elemento : array) {
                add(elemento);
            }
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean add(Collection<E> collection) {
        try {
            Iterator<E> iterator = collection.iterator();
            while (iterator.hasNext()) {
                E element = iterator.next();
                add(element);
            }
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean addFirst(E[] array) {
        try {
            for (int i = array.length - 1; i >= 0; i--) {
                addFirst(array[i]);
            }
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    @Override
    public E[] peekArray(int n) {
        try {
            Iterator<E> iterator = this.iterator();
            E[] save = (E[]) new Object[n];
            for (int i = 0; i < n && iterator.hasNext(); i++) {
                save[i] = iterator.next();
            }
            return save;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return null;
    }

    @Override
    public E[] peekLastArray(int n) {
        try {
            Iterator<E> iterator = this.iterator();
            E[] save = (E[]) new Object[n];
            for (int e = 0; e < size - n; e++) {
                iterator.next();
            }
            for (int i = 0; i < n && iterator.hasNext(); i++) {
                save[i] = iterator.next();
            }
            return save;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return null;
    }

    @Override
    public E[] pollArray(int n) {
        try {
            E[] save = (E[]) new Object[n];
            if (n >= size) {
                n = size;
            }
            for (int i = 0; i < n; i++) {
                save[i] = poll();
            }
            return save;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return null;
    }

    @Override
    public boolean remove(E[] array) {
        try {
            for (E element : array) {
                remove(element);
            }
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean remove(Collection<E> collection) {
        try {
            Iterator<E> iterator = collection.iterator();
            while (iterator.hasNext()) {
                E element = iterator.next();
                remove(element);
            }
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }
    
        @Override
    public boolean remove(Predicate<E> filter) {
        try {
            if (size == 0) {
                return false;
            }
            boolean eliminado=false;
            Iterator<E> iterator = this.iterator();
            while (iterator.hasNext()){
                E element=iterator.next();
                if (filter.test(element)){
                    eliminado = true;
                    remove(element);
                }
            }
            return eliminado;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean replace(E[] array, E[] newArray, Predicate<E> comparator) {
        try {
            for (int i = 0; i < array.length; i++) {
                replace(array[i], newArray[i], comparator);
            }
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean replace(Collection<E> collection, Collection<E> newCollection, Predicate<E> comparator) {
        try {
            Iterator<E> initialIterator = collection.iterator();
            Iterator<E> finalIterator = newCollection.iterator();
            while (initialIterator.hasNext() && finalIterator.hasNext()) {
                replace(initialIterator.next(), finalIterator.next(), comparator);
            }
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean contains(E element) {
        boolean found = false;
        Iterator<E> iterator = this.iterator();
        for (int i = 0; i < size && !found; i++) {
            if (iterator.next() == element) {
                found = true;
            }
        }
        return found;
    }

    @Override
    public boolean contains(E[] array) {
        boolean found = true;
        for (int i = 0; i < array.length && found; i++) {
            found = contains(array[i]);
        }
        return found;
    }

    @Override
    public boolean contains(Collection<E> collection) {
        boolean found = true;
        Iterator<E> iterator = collection.iterator();
        while (iterator.hasNext() && found) {
            E element = iterator.next();
            found = contains(element);
        }
        return found;
    }
    
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void forEach(Function<E, Void> action) {
        Iterator<E> iterator=this.iterator();
        while(iterator.hasNext()) {
            action.apply(iterator.next());
        }
    }
}
