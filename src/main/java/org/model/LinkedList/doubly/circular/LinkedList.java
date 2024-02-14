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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E peek() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E peekLast() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<E> peekCollection(int n) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<E> peekLastCollection(int n) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E poll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E pollLast() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E[] pollLastArray(int n) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<E> pollCollection(int n) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<E> pollLastCollection(int n) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean remove(E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean replace(E element, E newElement, Predicate<E> comparator) {
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
    public boolean clear() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean reverse() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
