/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.model.util.array;

/**
 *
 * @author admin
 */
public interface BufferArray {
        /**
     * Resizes the array to the specified dimension. If the specified dimension is less than the current dimension, the array is truncated.
     * @param newDimension
     * @return 'true' if the array was re dimensioned successfully, otherwise false.
     */    
    public boolean dimension (int newDimension);
    
    /**
     * Moves all the elements to the left.
     */
    public void defragment();
}
