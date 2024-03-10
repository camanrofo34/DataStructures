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
        this.arrayList = (E[]) new Object[10];
        this.size = 0;
    }

    private void ensureMoreCapacity() {
        if (size == arrayList.length) {
            int newCapacity = arrayList.length * 2;
            System.arraycopy(arrayList, 0, arrayList, 0, newCapacity);
        }
    }

    private void ensureLessCapacity() {
        if (size == (arrayList.length / 2)) {
            int newCapacity = arrayList.length / 2;
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
        for (int i = 0; i < size; i++) {
            if (arrayList[i].equals(element)) {
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
            for (int i = 0; i < size / 2; i++) {
                E temp = arrayList[i];
                arrayList[i] = arrayList[size - i - 1];
                arrayList[size - i - 1] = temp;
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
                return indice < size;
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
            ensureMoreCapacity();
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
            ensureMoreCapacity();
            System.arraycopy(arrayList, 0, arrayList, 1, size++);
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
    public boolean addFirst(Collection<E> collection) {
        try {
            collection.reverse();
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
        for (int i = n - 1; i >= 0; i--) {
            array[i] = pollLast();
        }
        ensureLessCapacity();
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
        boolean removed = true;
        for (E element : array) {
            if (!remove(element)) {
                removed = false;
            }
        }
        return removed;
    }

    @Override
    public boolean remove(Collection<E> collection) {
        boolean removed = true;
        Iterator<E> iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (!remove(iterator.next())) {
                removed = false;
            }
        }
        return removed;
    }

    @Override
    public boolean remove(Predicate<E> filter) {
        boolean removed = false;
        for (int i = 0; i < size; i++) {
            if (filter.test(arrayList[i])) {
                remove(arrayList[i]);
                removed = true;
            }
        }
        return removed;
    }

    @Override
    public boolean replace(E element, E newElement, Predicate<E> comparator) {
        boolean replaced = false;
        for (int i = 0; i < size; i++) {
            if (arrayList[i].equals(element) && comparator.test(arrayList[i])) {
                arrayList[i] = newElement;
                replaced = true;
            }
        }
        return replaced;
    }

    @Override
    public boolean replace(E[] array, E[] newArray, Predicate<E> comparator) {
        boolean replaced = true;
        for (int i = 0; i < array.length; i++) {
            if (!replace(array[i], newArray[i], comparator)) {
                replaced = false;
            }
        }
        return replaced;
    }

    @Override
    public boolean replace(Collection<E> collection, Collection<E> newCollection, Predicate<E> comparator) {
        boolean replaced = true;
        Iterator<E> iterator = collection.iterator();
        Iterator<E> newIterator = newCollection.iterator();
        while (iterator.hasNext() && newIterator.hasNext()) {
            if (!replace(iterator.next(), newIterator.next(), comparator)) {
                replaced = false;
            }
        }
        return replaced;
    }

    @Override
    public boolean retain(E[] array) {
        try {
            for (int i = 0; i < size; i++) {
                boolean elementContained = false;
                for (E arrayElement : array) {
                    if (arrayElement.equals(arrayList[i])) {
                        elementContained = true;
                    }
                }
                if (!elementContained) {
                    remove(arrayList[i]);
                }
            }
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean retain(Collection<E> collection) {
        try {
            for (int i = 0; i < size; i++) {
                if (!collection.contains(arrayList[i])) {
                    remove(arrayList[i]);
                }
            }
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean set(E index, E element) {
        for (int i = 0; i < size; i++) {
            if (arrayList[i].equals(index)) {
                arrayList[i] = element;
            }
        }
        return true;
    }

    @Override
    public boolean sort(ToIntFunction<E> toInt) {
        int i, j;
        E temp;
        boolean swapped;
        for (i = 0; i < size - 1; i++) {
            swapped = false;
            for (j = 0; j < size - i - 1; j++) {
                if (toInt.applyAsInt(arrayList[j]) > toInt.applyAsInt(arrayList[j + 1])) {
                    temp = arrayList[j];
                    arrayList[j] = arrayList[j + 1];
                    arrayList[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false) {
                break;
            }
        }
        return true;
    }

    @Override
    public List<E> subList(E from, E to) {
        List<E> list = new LinkedList<>();
        int i = indexOf(from);
        int e = indexOf(to);
        while (i < e) {
            list.add(arrayList[i++]);
        }
        return list;
    }

    @Override
    public E[] toArray() {
        return arrayList;
    }

    @Override
    public boolean add(int index, E[] array) {
        try {
            int e = 0;
            for (int i = index; i < array.length; i++) {
                arrayList[i] = array[e++];
                ensureMoreCapacity();
            }
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean add(int index, Collection<E> collection) {
        try {
            int e = index;
            Iterator<E> iterator = collection.iterator();
            while (iterator.hasNext()) {
                arrayList[e++] = iterator.next();
                ensureMoreCapacity();
            }
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    @Override
    public E get(int index) {
        try {
            return arrayList[index];
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return null;
    }

    @Override
    public int indexOf(E element) {
        int index = -1;
        try {
            for (int i = 0; i < arrayList.length && index == -1; i++) {
                if (arrayList[i] != null && arrayList[i].equals(element)) {
                    index = i;
                }
            }
            return index;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return index;
    }

    @Override
    public int lastIndexOf(E element) {
        int index = -1;
        try {
            for (int i = size - 1; i >= 0 && index == -1; i--) {
                if (arrayList[i] != null && arrayList[i].equals(element)) {
                    index = i;
                }
            }
            return index;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return index;
    }

    @Override
    public boolean remove(int index) {
        try {
            System.arraycopy(arrayList, index + 1, arrayList, index, size - index - 1);
            arrayList[--size] = null;
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean remove(int from, int to) {
        try {
            for (int i = to - 1; i >= from; i--) {
                if (!remove(i)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean set(int index, E element) {
        try {
            arrayList[index] = element;
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

}
