/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.model.util.queue;

import org.model.util.collection.Collection;

import java.io.Serializable;

/**
 *
 * @author admin
 */
public interface Queue<E> extends Serializable, Collection<E> {
    public E peek();
    public E extract();
    public boolean insert(E element);
}
