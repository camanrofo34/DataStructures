/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.model.util.queue;

/**
 *
 * @author admin
 */
public interface Queue<E> {
    public E peek();
    public E extract();
    public boolean insert(E element);
}
