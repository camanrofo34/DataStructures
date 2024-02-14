/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.model.LinkedList.singly;

import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.model.util.list.AbstractList;
import org.model.LinkedList.Node.singly.LinkedNode;
import org.model.util.list.List;
import org.model.util.collection.Collection;
import org.model.util.iterator.Iterator;

/**
 *
 * @author admin
 * @param <E>
 */
public class LinkedList<E> extends AbstractList<E> {

    private LinkedNode<E> head;
    private LinkedNode<E> tail;
    private LinkedNode<E> inode;

    public LinkedList() {
        super();
        this.head = null;
        this.tail = null;
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

    //fine
    @Override
    public boolean add(E element) {
        try {
            LinkedNode<E> newNode = new LinkedNode<>(element, null);
            if (size == 0) {
                head = newNode;
                tail = newNode;
            } else {
                tail.setNext(newNode);
                tail = newNode;
            }
            size++;
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean addFirst(E element) {
        try {
            LinkedNode<E> current = new LinkedNode<>(element, null);
            if (head == null && tail == null) {
                head = current;
                tail = current;
            } else {
                current.setNext(head);
                head = current;
            }
            size++;
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean addFirst(Collection<E> collection) {
        try {
            LinkedList<E> newList = new LinkedList<>();
            Iterator<E> iterator = collection.iterator();
            while (iterator.hasNext()) {
                E element = iterator.next();
                newList.add(element);
                size++;
            }
            newList.tail.setNext(head);
            this.head = newList.head;
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    @Override
    public E peek() {
        try {
            return head.get();
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return null;
    }

    @Override
    public E peekLast() {
        try {
            return tail.get();
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<E> peekCollection(int n) {
        try {
            Iterator<E> iterator = this.iterator();
            List<E> save = new LinkedList<>();
            for (int i = 0; i < n && iterator.hasNext(); i++) {
                save.add(iterator.next());
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
            if (n > size) {
                n = size;
            }
            LinkedNode<E> current = this.head;
            LinkedList<E> save = new LinkedList<>();
            for (int e = 0; e < size - n; e++) {
                current = current.getNext();
            }
            for (int i = 0; i < n && current != null; i++) {
                save.add(current.get());
                current = current.getNext();
            }
            return save;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return null;
    }

    public E poll() {
        try {
            if (size == 0) {
                return null;
            } else {
                E entrega = head.get();
                if (size == 1) {
                    head = head.getNext();
                    tail = tail.getNext();
                } else {
                    head = head.getNext();
                }
                size--;
                return entrega;
            }
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
                entrega = head.get();
                head = null;
                tail = null;
            } else {
                LinkedNode<E> previous = null;
                LinkedNode<E> current = head;
                while (current.getNext() != null) {
                    previous = current;
                    current = current.getNext();
                }
                entrega = current.get();
                previous.setNext(null);
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
            LinkedNode<E> current = head;
            E[] save = (E[]) new Object[n];
            for (int i = 0; i < n && current != null; i++) {
                save[i] = current.get();
                current = current.getNext();
                size--;
            }
            if (size == 0) {
                head = null;
                tail = null;
            } else {
                if (size == 1) {
                    head = current;
                    tail = current;
                } else {
                    head = current;
                }
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
            LinkedNode<E> current = head;
            for (int e = 0; e < size - n; e++) {
                current = current.getNext();
            }
            LinkedNode<E> newTail = current;
            E[] save = (E[]) new Object[n];
            for (int i = 0; i < n && current != null; i++) {
                save[i] = current.get();
                current = current.getNext();
                size--;
            }
            if (size == 0) {
                head = null;
                tail = null;
            } else {
                if (size == 1) {
                    head = current;
                    tail = current;
                } else {
                    newTail.setNext(null);
                    this.tail = newTail;
                }
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
                size = 0;
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
                for (int i = 0; i < n; i++) {
                    save.addFirst(pollLast());
                }
            } else {
                for (int i = 0; i < size; i++) {
                    save.addFirst(pollLast());
                }
                head = null;
                tail = null;
                size = 0;
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
            while (current != null && !current.get().equals(element)) {
                previous = current;
                current = current.getNext();
            }
            if (current == null) {
                return false;
            }
            if (current == head) {
                head = current.getNext();
            } else {
                previous.setNext(current.getNext());
            }
            if (current == tail) {
                tail = previous;
                tail.setNext(null);
            }
            size--;
            return true;
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
    public boolean retain(E[] array) {
        LinkedNode<E> current = head;
        LinkedNode<E> previous = null;
        boolean elementsRetained = false;
        while (current != null) {
            boolean elementContained = false;
            for (E arrayElement : array) {
                if (arrayElement.equals(current.get())) {
                    elementContained = true;
                }
            }
            if (!elementContained) {
                if (previous == null) {
                    head = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                if (current == tail) {
                    tail = previous;
                    tail.setNext(null);
                }
                current = current.getNext();
                elementsRetained = true;
                size--;
            } else {
                previous = current;
                current = current.getNext();
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
                if (previous == null) {
                    head = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                if (current == tail) {
                    tail = previous;
                    tail.setNext(null);
                }
                current = current.getNext();
                elementsRetained = true;
                size--;
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
            LinkedNode<E> next = head.getNext();
            LinkedNode<E> previous = null;
            while (next != null) {
                int currentIntValue = toInt.applyAsInt(current.get());
                int nextIntValue = toInt.applyAsInt(next.get());
                if (currentIntValue > nextIntValue) {
                    if (previous == null) {
                        head = next;
                    } else {
                        previous.setNext(next);
                    }
                    current.setNext(next.getNext());
                    next.setNext(current);
                    if (current.getNext() == null) {
                        tail = current;
                    }
                    swapped = true;
                }
                previous = current;
                current = next;
                next = next.getNext();
            }
        } while (swapped);
        tail.setNext(null);
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
    public boolean clear() {
        try {
            head.setNext(null);
            tail = null;
            head = null;
            size = 0;
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean reverse() {
        LinkedNode<E> current = head;
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
    public Iterator<E> iterator() {
        inode = head;
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return inode != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements to list");
                }
                E element = inode.get();
                inode = inode.getNext();
                return element;
            }
        };
    }
}
