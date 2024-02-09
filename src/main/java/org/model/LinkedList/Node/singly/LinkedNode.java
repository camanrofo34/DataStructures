/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.model.LinkedList.Node.singly;

import org.model.util.node.AbstractNode;

/**
 *
 * @author admin
 * @param <E>
 */
public class LinkedNode<E> extends AbstractNode<E>{    
    private LinkedNode<E> next;
    
    public LinkedNode(LinkedNode<E> next) {
        this.next = next;
    }

    public LinkedNode(E element, LinkedNode<E> next) {
        super(element);
        this.next = next;
    }

    public LinkedNode<E> getNext() {
        return next;
    }

    public void setNext(LinkedNode<E> next) {
        this.next = next;
    }
}
