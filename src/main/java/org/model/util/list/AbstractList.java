/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.model.util.list;

import org.model.util.collection.Collection;

/**
 *
 * @author admin
 * @param <E>
 */
public abstract class AbstractList<E> implements List<E>, Collection<E>, Cloneable{
    protected int size;
    protected AbstractList(){
        this.size=0;
    }
    @Override
    public int size(){
        return size;
    }
}
