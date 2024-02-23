/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.model.LinkedList.doubly.circular;

import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.model.LinkedList.Node.doubly.LinkedNode;
import org.model.util.collection.Collection;
import org.model.util.iterator.Iterator;
import org.model.util.list.AbstractList;
import org.model.util.list.List;

/**
 *
 * @author admin
 * @param <E>
 */
public class LinkedList<E> extends AbstractList<E> {

    private LinkedNode<E> head;

    public LinkedList() {
        super();
        this.head = null;
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
            LinkedNode<E> newNode = new LinkedNode<>(element);
            if (head == null) {
                head = newNode;
                head.setNext(head);
                head.setPrevious(head);
            } else {
                LinkedNode<E> current = head;
                while (current.getNext() != head) {
                    current = current.getNext();
                }
                current.setNext(newNode);
                newNode.setPrevious(current);
                newNode.setNext(head);
                head.setPrevious(newNode);
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
            LinkedNode<E> newNode = new LinkedNode<>(element);
            if (head == null) {
                head = newNode;
                newNode.setNext(head);
                head.setPrevious(head);
            } else {
                LinkedNode<E> current = head;
                while (current.getNext() != head) {
                    current = current.getNext();
                }
                current.setNext(newNode);
                newNode.setPrevious(current);
                newNode.setNext(head);
                head.setPrevious(newNode);
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
    public boolean addFirst(Collection<E> collection) {
        try {
            Iterator<E> iterator = collection.iterator();
            LinkedNode<E> reversedList = null;
            while (iterator.hasNext()) {
                E element = iterator.next();
                LinkedNode<E> newNode = new LinkedNode<>(element, reversedList, null);
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
            return head.get();
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
                head.setPrevious(current);
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
                entrega = head.get();
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
                head.setPrevious(previous);
            }
            size--;
            return entrega;
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
                size = 0;
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
                for (int i = n - 1; i >= 0; i--) {
                    save.addFirst(pollLast());
                }
            } else {
                for (int i = 0; i < size; i++) {
                    save.addFirst(pollLast());
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
                    head.setPrevious(tail);
                }
            } else {
                previous.setNext(current.getNext());
                current.getNext().setPrevious(previous);
            }
            size--;
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
            return false;
        }
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
        LinkedList<E> newList = new LinkedList<>();
        LinkedNode<E> current = head;
        LinkedNode<E> previous = null;
        while (!(current == head && previous != null)) {
            for (E arrayElement : array) {
                if (arrayElement.equals(current.get())) {
                    newList.add(current.get());
                }
            }
            current = current.getNext();
            previous = current;
        }
        head = newList.head;
        size = newList.size;
        return !newList.isEmpty();
    }

    @Override
    public boolean retain(Collection<E> collection) {
        LinkedList<E> newList = new LinkedList<>();
        LinkedNode<E> current = head;
        LinkedNode<E> previous = null;
        while (!(current == head && previous != null)) {
            if (collection.contains(current.get())) {
                newList.add(current.get());
                previous = current;
            } else {
                if (previous != null) {
                    previous.setNext(current.getNext());
                    current.getNext().setPrevious(previous);
                } else {
                    head = current.getNext();
                }
            }
            current = current.getNext();
        }
        head = newList.head;
        size = newList.size;
        return !newList.isEmpty();
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
    public boolean clear() {
        try {
            head.setNext(null);
            head.setPrevious(null);
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
                if (size == 0) {
                    return false;
                }
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
