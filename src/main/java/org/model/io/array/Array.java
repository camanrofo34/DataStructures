/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.model.io.array;

import java.io.Serializable;

/**
 *
 * @author admin
 * @param <E>
 */
public class Array<E extends Serializable> extends AbstractSerializableArray<E> {

    public Array(int dimension) {
        super(dimension);
    }

    public Array() {
    }

    public Array(E[] array) {
        super(array);
    }
    
}
