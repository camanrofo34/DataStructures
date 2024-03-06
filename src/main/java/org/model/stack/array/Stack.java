/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.model.stack.array;

import java.util.function.Function;
import org.model.array.Array;
import org.model.util.collection.Collection;
import org.model.util.iterator.Iterator;
import org.model.util.stack.AbstractStack;

/**
 *
 * @author admin
 */
public class Stack<E> extends AbstractStack<E> {
    Array<E> stack;
    
    public Stack(int dimension){
        stack=new Array<>(dimension);
    }

    @Override
    public boolean clear() {
        return stack.clear();
    }

    @Override
    public boolean contains(E element) {
        return stack.contains(element);
    }

    @Override
    public boolean contains(E[] array) {
        return stack.contains(array);
    }

    @Override
    public boolean contains(Collection<E> collection) {
        return stack.contains(collection);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public boolean reverse() {
        return stack.reverse();
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public void forEach(Function<E, Void> action) {
        stack.forEach(action);
    }

    @Override
    public Iterator<E> iterator() {
        return stack.iterator();
    }

    @Override
    public E peek() {
        return stack.get(size()-1);
    }

    @Override
    public E pop() {
        E element= peek();
        stack.remove(size()-1);
        return element;
    }

    @Override
    public boolean push(E element) {
        return stack.add(element);
    }
    
}

