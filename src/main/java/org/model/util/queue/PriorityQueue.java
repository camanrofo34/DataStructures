/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.model.util.queue;

import java.io.Serializable;

/**
 *
 * @author informatica
 */
public interface PriorityQueue<E> extends Queue<E>, Serializable {
    public boolean insert(E element);
    public boolean insert (int index, E element);
    
}
