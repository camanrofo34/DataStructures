/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.model.util.node;

/**
 *
 * @author Camilo
 * @param <E>
 */
public abstract class AbstractNode<E> implements Node<E>, Cloneable{
    protected E element;

    public AbstractNode() {
        this.element = null;
    }
    
    public AbstractNode(E element) {
        this.element = element;
    }
    
    @Override
    public void set(E element) {
        this.element=element;
    }

    @Override
    public E get() {
        return this.element;
    }
    
    @Override
    public String toString(){
        return element.toString();
    }
}
