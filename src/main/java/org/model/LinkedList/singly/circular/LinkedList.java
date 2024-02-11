/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.model.LinkedList.singly.circular;

import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.model.LinkedList.Node.singly.LinkedNode;
import org.model.util.collection.Collection;
import org.model.util.iterator.Iterator;
import org.model.util.list.AbstractList;
import org.model.util.list.List;

/**
 *
 * @author informatica
 */
public class LinkedList<E> extends AbstractList<E> {

    private LinkedNode<E> head;
    private LinkedNode<E> inode;

    public LinkedList() {
        super();
        this.head = null;
        this.inode = null;
    }

    public LinkedList(E element) {
        super();
        add(element);
    }

    public LinkedList(E[] array) {
        super();
        for (E element : array) {
            add(element);
        }
    }

    @Override
    public boolean add(E element) {
        try {
            LinkedNode<E> newNode = new LinkedNode<>(element, null);
            if (head == null) {
                head = newNode;
                head.setNext(head);
            } else {
                LinkedNode<E> current = head;
                while (current.getNext() != head) {
                    current = current.getNext();
                }
                current.setNext(newNode);
                newNode.setNext(head);
            }
            size++;
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
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
    public boolean addFirst(E element) {
        try {
            LinkedNode<E> newNode = new LinkedNode<>(element, head);
            if (head == null) {
                head = newNode;
                newNode.setNext(head);
            } else {
                LinkedNode<E> current = head;

                while (current.getNext() != head) {
                    current = current.getNext();
                }

                current.setNext(newNode);
                head = newNode;
            }
            size++;
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
            Iterator<E> iterator = collection.iterator();

            LinkedNode<E> reversedList = null;
            while (iterator.hasNext()) {
                E element = iterator.next();
                LinkedNode<E> newNode = new LinkedNode<>(element, reversedList);
                reversedList = newNode;
            }

            LinkedNode<E> current = reversedList;
            while (current != null) {
                addFirst(current.get());
                current = current.getNext();
            }

            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    @Override
    public E peek() {
        try {
            if (head != null) {
                return head.get();
            }
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return null;
    }

    @Override
    public E peekLast() {
        try {
            if (head != null) {
                LinkedNode<E> current = head;
                while (current.getNext() != head) {
                    current = current.getNext();
                }
                return current.get();
            }
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return null;
    }

    @Override
    public E[] peekArray(int n) {
        try {
            LinkedNode<E> previous = null;
            LinkedNode<E> current = head;
            E[] save = (E[]) new Object[n];
            for (int i = 0; i < n && !(current == head && previous != null); i++) {
                save[i] = current.get();
                previous = current;
                current = current.getNext();
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
            LinkedNode<E> current = head;
            LinkedNode<E> previous = null;
            E[] save = (E[]) new Object[n];
            for (int e = 0; e < size - n; e++) {
                previous = current;
                current = current.getNext();
            }
            for (int i = 0; i < n && !(current == head && previous != null); i++) {
                save[i] = current.get();
                previous = current;
                current = current.getNext();
            }
            return save;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<E> peekCollection(int n) {
        try {
            LinkedNode<E> current = head;
            LinkedNode<E> previous = null;
            LinkedList<E> save = new LinkedList<>();
            for (int i = 0; i < n && !(current == head && previous != null); i++) {
                save.add(current.get());
                previous = current;
                current = current.getNext();
            }
            return save;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<E> peekLastCollection(int n) {
        try {
            LinkedNode<E> current = head;
            LinkedNode<E> previous = null;
            LinkedList<E> save = new LinkedList<>();
            for (int e = 0; e < size - n; e++) {
                previous = current;
                current = current.getNext();
            }
            for (int i = 0; i < n && !(current == head && previous != null); i++) {
                save.add(current.get());
                previous = current;
                current = current.getNext();
            }
            return save;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return null;
    }

    @Override
    public E poll() {
        try {
            if (size == 0) {
                return null;
            }
            E entrega = head.get();
            if (size == 1) {
                head = null;
            } else {
                LinkedNode<E> current = head;
                while (current.getNext() != head) {
                    current = current.getNext();
                }
                head = head.getNext();
                current.setNext(head);
            }
            size--;
            return entrega;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return null;
    }

    @Override
    public E pollLast() {
        try {
            E entrega = null;
            if (size == 0) {
                return null;
            }
            if (size == 1) {
                head = null;
            } else {
                LinkedNode<E> previous = null;
                LinkedNode<E> current = head;
                while (current.getNext() != head) {
                    previous = current;
                    current = current.getNext();
                }
                entrega = current.get();
                previous.setNext(head);
            }
            size--;
            return entrega;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return null;
    }

    @Override
    public E[] pollArray(int n) {
        try {
            E[] save = (E[]) new Object[n];
            if (n < size) {
                for (int i = 0; i < n; i++) {
                    save[i] = poll();
                }
            } else {
                System.arraycopy(toArray(), 0, save, 0, size);
                head = null;
            }
            return save;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return null;
    }

    @Override
    public E[] pollLastArray(int n) {
        try {
            E[] save = (E[]) new Object[n];
            if (n < size) {
                for (int i = n - 1; i >= 0; i--) {
                    save[i] = pollLast();
                }
            } else {
                System.arraycopy(toArray(), 0, save, 0, size);
                head = null;
            }
            return save;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<E> pollCollection(int n) {
        try {
            List<E> save = new LinkedList<>();
            if (n < size) {
                for (int i = 0; i < n; i++) {
                    save.add(poll());
                }
            } else {
                for (int i = 0; i < size; i++) {
                    save.add(poll());
                }
                head = null;
            }
            return save;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<E> pollLastCollection(int n) {
        try {
            List<E> save = new LinkedList<>();
            if (n < size) {
                for (int i = n - 1; i >= 0; i--) {
                    save.addFirst(pollLast());
                }
            } else {
                for (int i = 0; i < size; i++) {
                    save.addFirst(pollLast());
                }
                head = null;
            }
            return save;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return null;
    }

    @Override
    public boolean remove(E element) {
        try {
            LinkedNode<E> current = head;
            LinkedNode<E> previous = null;
            LinkedNode<E> tail = null;
            while (current != null && !current.get().equals(element)) {
                previous = current;
                current = current.getNext();
            }
            if (current == null) {
                return false;
            }
            if (current == head) {
                tail = head;
                while (tail.getNext() != head) {
                    tail = tail.getNext();
                }
                if (head == head.getNext()) {
                    head = null;
                    tail = null;
                } else {
                    head = head.getNext();
                    tail.setNext(head);
                }
            } else {
                previous.setNext(current.getNext());
            }
            size--;
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
            return false;
        }
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
            LinkedNode<E> current = head;
            LinkedNode<E> previous = null;
            boolean elementsRemoved = false;
            while (current != null) {
                if (filter.test(current.get())) {
                    if (previous == null) {
                        LinkedNode<E> tail = head;
                        while (current.getNext() != head) {
                            current = current.getNext();
                        }
                        head = current.getNext();
                        tail.setNext(head);
                    } else {
                        previous.setNext(current.getNext());
                    }
                    current = current.getNext();
                    elementsRemoved = true;
                    size--;
                } else {
                    previous = current;
                    current = current.getNext();
                }
            }
            return elementsRemoved;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean replace(E element, E newElement, Predicate<E> comparator) {
        try {
            LinkedNode<E> current = head;
            boolean elementReplaced = false;
            for (int i = 0; i < size; i++) {
                if (comparator.test(current.get()) && current.get().equals(element)) {
                    current.set(newElement);
                    elementReplaced = true;
                }
                current = current.getNext();
            }
            return elementReplaced;
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
    public boolean retain(E[] array) {
        LinkedNode<E> current = head;
        boolean elementsRetained = false;
        E element = null;
        while (current != null) {
            boolean elementContained = false;
            for (E arrayElement : array) {
                if (arrayElement.equals(current.get())) {
                    elementContained = true;
                }
                element = current.get();
            }
            if (!elementContained) {
                remove(element);
            }
        }
        return elementsRetained;
    }

    @Override
    public boolean retain(Collection<E> collection) {
        LinkedNode<E> current = head;
        LinkedNode<E> previous = null;
        boolean elementsRetained = false;
        while (current != null) {
            if (!collection.contains(current.get())) {
                remove(current.get());
            } else {
                previous = current;
                current = current.getNext();
            }
        }
        return elementsRetained;
    }

    @Override
    public boolean set(E index, E element) {
        try {
            boolean set = false;
            LinkedNode<E> current = head;
            while (current.get() != index && !set) {
                current = current.getNext();
            }
            current.set(element);
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean sort(ToIntFunction<E> toInt) {
        if (size <= 1) {
            return true;
        }
        boolean swapped;
        do {
            swapped = false;
            LinkedNode<E> current = head;
            do {
                LinkedNode<E> nextNode = current.getNext();
                if (toInt.applyAsInt(current.get()) > toInt.applyAsInt(nextNode.get())) {
                    E temp = current.get();
                    current.set(nextNode.get());
                    nextNode.set(temp);
                    swapped = true;
                }
                current = nextNode;
            } while (current.getNext() != head);
        } while (swapped);

        return true;
    }

    @Override
    public List<E> subList(E from, E to) {
        LinkedNode<E> current = head;
        LinkedList<E> newList = new LinkedList<>();
        while (current != null && !current.get().equals(from)) {
            current = current.getNext();
        }
        do {
            newList.add(current.get());
            current = current.getNext();
        } while (current.get() != to);
        return newList;
    }

    @Override
    public E[] toArray() {
        LinkedNode<E> current = head;
        E[] toArray = (E[]) new Object[size];
        for (int i = 0; i < size; i++) {
            toArray[i] = current.get();
            current = current.getNext();
        }
        return toArray;
    }

    @Override
    public boolean clear() {
        try {
            head.setNext(null);
            head = null;
            size = 0;
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean contains(E element) {
        boolean found = false;
        LinkedNode<E> current = head;
        for (int i = 0; i < size && !found; i++) {
            if (current.get() == element) {
                found = true;
            }
            current = current.getNext();
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
    public boolean reverse() {
        LinkedNode<E> current = this.head;
        Iterator<E> iterator = this.iterator();
        E[] reverso = (E[]) new Object[size];
        int i = 1;
        while (iterator.hasNext()) {
            E element = iterator.next();
            reverso[size - i] = element;
            i++;
        }
        for (E element : reverso) {
            current.set(element);
            current = current.getNext();
        }
        return true;
    }

    @Override
    public void forEach(Function<E, Void> action) {
        LinkedNode<E> current = head;
        for (int i = 0; i < size; i++) {
            E element = (E) action.apply(current.get());
            current.set(element);
            current = current.getNext();
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private LinkedNode<E> previous = null;
            private LinkedNode<E> current = head;
            private LinkedNode<E> next;

            {
                if (head != null) {
                    next = head.getNext();
                }
            }

            @Override
            public boolean hasNext() {
                return !(current == head && previous != null);
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements to list");
                }
                E element = current.get();
                previous = current;
                current = current.getNext();
                next = next.getNext();
                return element;
            }
        };
    }
}
