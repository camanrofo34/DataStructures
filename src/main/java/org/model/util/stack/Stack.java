/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.model.util.stack;

/**
 *
 * @author informatica
 * @param <E>
 */
public interface Stack<E> {
    public E peek();
    public E pop();
    public boolean push(E element);
}
