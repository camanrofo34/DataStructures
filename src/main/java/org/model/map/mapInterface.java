/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.model.map;

/**
 *
 * @author informatica
 */
public interface mapInterface<E> {
    
    public boolean put(String key, E element);
    
    public E get(String key);
    
}
