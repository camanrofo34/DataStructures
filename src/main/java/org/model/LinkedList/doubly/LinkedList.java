/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.model.LinkedList.doubly;

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
 * @author informatica
 */
public class LinkedList<E> extends AbstractList<E> {

    LinkedNode<E> head;
    LinkedNode<E> tail;

    public LinkedList() {
        super();
        this.head = null;
        this.tail = null;
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
            if (size == 0) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.setPrevious(tail);
                tail.setNext(newNode);
                tail = newNode;
                tail.setNext(null);
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
            if (size == 0) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.setNext(head);
                head.setPrevious(newNode);
                head = newNode;
                head.setPrevious(null);
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
            return tail.get();
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<E> peekCollection(int n) {
        try {
            LinkedNode<E> current = head;
            List<E> save = new LinkedList<>();
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

    @Override
    public E poll() {
        try {
            if (size == 0) {
                return null;
            } else {
                E entrega = head.get();
                if (size == 1) {
                    head = null;
                    tail = null;
                } else {
                    LinkedNode<E> next = head.getNext();
                    next.setPrevious(null);
                    head.setNext(null);
                    head = next;
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
            if (size == 0) {
                return null;
            } else {
                E entrega = tail.get();
                if (size == 1) {
                    head = null;
                    tail = null;
                } else {
                    LinkedNode<E> previous = tail.getPrevious();
                    previous.setNext(null);
                    tail.setPrevious(null);
                    tail = previous;
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
    public List<E> pollCollection(int n) {
        try {
            LinkedNode<E> current = head;
            LinkedList<E> save = new LinkedList<>();
            for (int i = 0; i < n && current != null; i++) {
                save.add(current.get());
                current = current.getNext();
                size--;
            }
            if (size == 0) {
                head = null;
                tail = null;
            } else {
                if (size == 1) {
                    head = current;
                    head.setNext(null);
                    head.setPrevious(null);
                    tail = current;
                    tail.setNext(null);
                    tail.setPrevious(null);
                } else {
                    head = current;
                    head.setPrevious(null);
                }
            }
            return save;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<E> pollLastCollection(int n) {
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
                tail = null;
                size = 0;
            }
            return save;
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
                head.setPrevious(null);
            } else {
                if (current == tail) {
                previous.setNext(current.getNext());
                tail = previous;
                tail.setNext(null);
            } else{
                previous.setNext(current.getNext());
                current.getNext().setPrevious(previous);
                }
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
            while (current!=null) {
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
                    head.setPrevious(null);
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
                    head.setPrevious(null);
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
        return false;
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
        try{
            head.setNext(null);
            tail.setPrevious(null);
            head=null;
            tail=null;
            size=0;
            return true;
        }catch (Exception e) {
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
    public void forEach(Function<E, Void> action) {
        LinkedNode<E> current = head;
        while (current != null) {
            E element = (E) action.apply(current.get());
            current.set(element);
            current = current.getNext();
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            LinkedNode<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements to list");
                }
                E element = current.get();
                current = current.getNext();
                return element;
            }
        };
    }

}
