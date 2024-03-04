/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.model.ArrayList;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.model.LinkedList.singly.LinkedList;
import org.model.util.ArrayList.AbstractArrayList;
import org.model.util.collection.Collection;
import org.model.util.iterator.Iterator;
import org.model.util.list.List;

/**
 *
 * @author PC 4060TI
 * @param <E>
 */
public class ArrayList<E> extends AbstractArrayList<E> {

    E[] arrayList;
    int size;

    public ArrayList(int size) {
        this.arrayList = (E[]) new Object[size];
        this.size = 0;
    }

    public ArrayList() {
        this.arrayList = (E[]) new Object[0];
        this.size = 0;
    }

    private void ensureCapacity() {
        if (size == arrayList.length) {
            int newCapacity = arrayList.length * 2;
            System.arraycopy(arrayList, 0, arrayList, 0, newCapacity);
        }
    }

    @Override
    public boolean clear() {
        try {
            System.arraycopy(arrayList, 0, arrayList, 0, 10);
            for (int i = 0; i < arrayList.length; i++) {
                arrayList[i] = null;
            }
            size = 0;
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean contains(E element) {
        for (E element1 : arrayList) {
            if (element1.equals(element)) {
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
        Iterator<E> collectionIterator = collection.iterator();
        while (collectionIterator.hasNext()) {
            E element = collectionIterator.next();
            if (!contains(element)) {
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
        try {
            for (int i = 0; i < arrayList.length / 2; i++) {
                E temp = arrayList[i];
                arrayList[i] = arrayList[arrayList.length - i - 1];
                arrayList[arrayList.length - i - 1] = temp;
            }
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void forEach(Function<E, Void> action) {
        for (E element : arrayList) {
            action.apply(element);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int indice = 0;

            @Override
            public boolean hasNext() {
                return indice < arrayList.length;
            }

            @Override
            public E next() {
                return arrayList[indice++];
            }
        };
    }

    @Override
    public boolean add(E element) {
        try {
            ensureCapacity();
            arrayList[size++] = element;
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean add(E[] array) {
        try {
            for (E element : array) {
                add(element);
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
                add(iterator.next());
            }
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean addFirst(E element) {
        try {
            ensureCapacity();
            System.arraycopy(arrayList, 0, arrayList, 1, size);
            arrayList[0] = element;
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean addFirst(E[] array) {
        try {
            for (E element : array) {
                addFirst(element);
            }
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean addFirst(Collection<E> collection) {
        try {
            Iterator<E> iterator = collection.iterator();
            while (iterator.hasNext()) {
                addFirst(iterator.next());
            }
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    @Override
    public E peek() {
        return arrayList[0];
    }

    @Override
    public E peekLast() {
        return arrayList[size - 1];
    }

    @Override
    public E[] peekArray(int n) {
        if (n > size) {
            n = size;
        }
        E[] array = (E[]) new Object[n];
        System.arraycopy(arrayList, 0, array, 0, n);
        return array;
    }

    @Override
    public E[] peekLastArray(int n) {
        if (n > size) {
            n = size;
        }
        E[] array = (E[]) new Object[n];
        System.arraycopy(arrayList, size - n, array, 0, n);
        return array;
    }

    @Override
    public List<E> peekCollection(int n) {
        List<E> list = new LinkedList<>();
        list.add(peekArray(n));
        return list;
    }

    @Override
    public List<E> peekLastCollection(int n) {
        List<E> list = new LinkedList<>();
        list.add(peekLastArray(n));
        return list;
    }

    @Override
    public E poll() {
        E element = arrayList[0];
        System.arraycopy(arrayList, 1, arrayList, 0, size--);
        return element;
    }

    @Override
    public E pollLast() {
        E element = arrayList[size - 1];
        System.arraycopy(arrayList, 0, arrayList, 0, size--);
        return element;
    }

    @Override
    public E[] pollArray(int n) {
        if (n > size) {
            n = size;
        }
        E[] array = (E[]) new Object[n];
        for (int i = 0; i < n; i++) {
            array[i] = poll();
        }
        return array;
    }

    @Override
    public E[] pollLastArray(int n) {
        if (n > size) {
            n = size;
        }
        E[] array = (E[]) new Object[n];
        for (int i = n - 1; i >= 0; i++) {
            array[i] = pollLast();
        }
        return array;
    }

    @Override
    public List<E> pollCollection(int n) {
        List<E> list = new LinkedList<>();
        list.add(pollArray(n));
        return list;
    }

    @Override
    public List<E> pollLastCollection(int n) {
        List<E> list = new LinkedList<>();
        list.add(pollLastArray(n));
        return list;
    }

    @Override
    public boolean remove(E element) {
        for (int i = 0; i < size; i++) {
            if (arrayList[i].equals(element)) {
                System.arraycopy(arrayList, i + 1, arrayList, i, size - i - 1);
                arrayList[--size] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(E[] array) {
        boolean removed=true;
        for (E element: array){
            if (!remove(element)) removed=false;
        }
        return removed;
    }

    @Override
    public boolean remove(Collection<E> collection) {
        boolean removed=true;
        Iterator<E> iterator = collection.iterator();
        while(iterator.hasNext()){
            if (!remove(iterator.next())) removed=false;
        }
        return removed;
    }

    @Override
    public boolean remove(Predicate<E> filter) {
        boolean removed=false;
        for (int i=0; i<size; i++){
            if(filter.test(arrayList[i])) {  
                remove(arrayList[i]);
                removed=true;
            }
        }
        return removed;
    }

    @Override
    public boolean replace(E element, E newElement, Predicate<E> comparator) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean replace(E[] array, E[] newArray, Predicate<E> comparator) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean replace(Collection<E> collection, Collection<E> newCollection, Predicate<E> comparator) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean retain(E[] array) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean retain(Collection<E> collection) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean set(E index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean sort(ToIntFunction<E> toInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<E> subList(E from, E to) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean add(int index, E[] array) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean add(int index, Collection<E> collection) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int indexOf(E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int lastIndexOf(E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean remove(int from, int to) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}