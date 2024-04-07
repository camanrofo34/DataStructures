/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.model.io.array;

import java.io.Serializable;
import org.model.array.Array;

/**
 *
 * @author admin
 * @param <E>
 */
public abstract class AbstractSerializableArray<E extends Serializable> extends Array<E> implements Serializable{ 

    protected static final long serialVersionUID = 1L;
    
    protected AbstractSerializableArray(int dimension) {
        super(dimension);
    }

    protected AbstractSerializableArray() {
    }

    protected AbstractSerializableArray(E[] array) {
        super(array);
    }
    
}
