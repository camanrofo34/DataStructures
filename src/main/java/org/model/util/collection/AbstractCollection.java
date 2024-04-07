/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.model.util.collection;



/**
 *
 * @author PC 4060TI
 * @param <E>
 */
public abstract class AbstractCollection<E> implements Collection<E>, Cloneable{
    @Override
    public AbstractCollection<E> clone() {
        try {
            return (AbstractCollection<E>) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
