package org.model.util.array;

import java.util.function.Predicate;
import org.model.util.collection.Collection;

public interface Array<E> {
    /**
     * Inserts the specified element at the clear position in this collection..
     * @param element
     * @return 'true' if the element was added successfully, otherwise 'false'.
     */
    public boolean add (E element);
    
    /**
     * Inserts all of the elements in the specified array into this collection, starting at the specified position.
     * @param index
     * @param array
     * @return 'true' if the collection was added successfully, otherwise 'false'.
     */
    public boolean add  (int index, E[] array);
    
    /**
     * Inserts all of the elements in the specified collection into this collection, starting at the specified position.
     * @param index
     * @param collection
     * @return 'true' if the collection was added successfully, otherwise 'false'
     */
    public boolean add (int index, Collection<E> collection);
    
    /**
     * Moves all the elements to the left.
     */
    public void defragment();
    
    /**
     * Returns the element at the specified position in this collection.
     * @param index
     * @return the element at the specified position in this collection.
     */
    public E get (int index);

    /**
     * Returns the index of the first occurrence of the specified element in this collection.
     * @param element
     * @return the index of the first occurrence of the specified element in this collection, or -1 if this list does not contain the element.
     */    
    public int indexOf (E element);

    /**
     * Returns the index of the last occurrence of the specified element in this collection.
     * @param element
     * @return 	the index of the last occurrence of the specified element in this collection, or -1 if this list does not contain the element.
     */    
    public int lastIndexOf (E element);

    /**
     * Removes the element at the specified position in this collection.
     * @param index
     * @return 'true' if the element was removed successfully, otherwise 'false'.
     */    
    public boolean remove (int index);
    
    /**
     * Removes the first occurrence of the specified element from this collection, if it is present.
     * @param filter
     * @return 'true' if the element was removed successfully, otherwise 'false'.
     */        
    public boolean remove (Predicate<E> filter);
   
    /**
     * Removes from this collection all of the elements whose index is between "from" and "to"..
     * @param from
     * @param to
     * @return 'true' if the element was removed successfully between the specified "from", inclusive, and "to", exclusive, otherwise 'false'.
     */    
    public boolean remove (int from, int to);

    /**
     * Resizes the array to the specified dimension. If the specified dimension is less than the current dimension, the array is truncated.
     * @param newDimension
     * @return 'true' if the array was re dimensioned successfully, otherwise false.
     */    
    public boolean dimension (int newDimension);
    
    /**
     * Replaces the element at the specified position in this collection with the specified element.
     * @param index
     * @param element
     * @return 'true' if the element was replaced successfully, otherwise 'false'.
     */    
    public boolean set (int index, E element);
}
