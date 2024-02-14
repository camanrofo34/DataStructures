/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.model.LinkedList.Node.doubly;

import org.model.util.node.AbstractNode;

/**
 *
 * @author informatica
 * @param <E>
 */
public class LinkedNode<E> extends AbstractNode<E> {

    LinkedNode<E> next;
    LinkedNode<E> previous;

    public LinkedNode() {
        this.next = null;
        this.previous = null;
    }

    public LinkedNode( E element, LinkedNode<E> next, LinkedNode<E> previous) {
        super(element);
        this.next = next;
        this.previous = previous;
    }
    

    public LinkedNode(E element) {
        super(element);
        this.next = null;
        this.previous = null;
    }

    public LinkedNode<E> getNext() {
        return next;
    }

    public void setNext(LinkedNode<E> next) {
        this.next = next;
    }

    public LinkedNode<E> getPrevious() {
        return previous;
    }

    public void setPrevious(LinkedNode<E> previous) {
        this.previous = previous;
    }
    
    

}
