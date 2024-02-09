/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.model.util.list;

import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import org.model.util.collection.Collection;

/**
 *
 * @author Camilo
 * @param <E>
 */
public interface List<E> {

    /**
     * Appends the specified element to the end of this list.
     *
     * @param element
     * @return 'true' if the element was added successfully, otherwise 'false'.
     */
    public boolean add(E element);

    /**
     * Inserts the specified element at the clear position in this collection.
     *
     * @param array
     * @return 'true' if the array was added successfully, otherwise 'false'.
     */
    public boolean add(E[] array);

    /**
     * Inserts the specified element at the clear position in this collection.
     *
     * @param collection
     * @return Inserts the specified element at the clear position in this
     * collection.
     */
    public boolean add(Collection<E> collection);

    /**
     * Appends the specified element at the beginning of this list.
     *
     * @param element
     * @return 'true' if the element was added successfully, otherwise 'false'.
     */
    public boolean addFirst(E element);

    /**
     * Appends all of the elements in the specified array at the beginning of
     * this list, in the order that they are returned by the specified
     * collection's iterator.
     *
     * @param array
     * @return 'true' if the collection was added successfully, otherwise
     * 'false'.
     */
    public boolean addFirst(E[] array);

    /**
     * Appends all of the elements in the specified collection at the beginning
     * of this list, in the order that they are returned by the specified
     * collection's iterator.
     *
     * @param collection
     * @return 'true' if the collection was added successfully, otherwise
     * 'false'.
     */
    public boolean addFirst(Collection<E> collection);

    /**
     * Retrieves, but does not remove, the head (first element) of this list.
     *
     * @return the element in the head of this list, or 'null' if this list is
     * empty.
     */
    public E peek();

    /**
     * Retrieves, but does not remove, the last element of this list.
     *
     * @return the element in the last of this list, or 'null' if this list is
     * empty.
     */
    public E peekLast();

    /**
     * Retrieves, but does not remove, the first n elements of the list.
     *
     * @param n
     * @return an array containing the first n elements of the list.
     */
    public E[] peekArray(int n);

    /**
     * Retrieves, but does not remove, the last n elements of the list.
     *
     * @param n
     * @return an array containing the last n elements of the list.
     */
    public E[] peekLastArray(int n);

    /**
     * Retrieves, but does not remove, the first n elements of the list.
     *
     * @param n
     * @return a collection containing the first n elements of the list.
     */
    public List<E> peekCollection(int n);

    /**
     * Retrieves, but does not remove, the last n elements of the list.
     *
     * @param n
     * @return a collection containing the last n elements of the list.
     */
    public List<E> peekLastCollection(int n);

    /**
     * Retrieves and removes the head (first element) of this list.
     *
     * @return the element in the head of this list, or 'null' if this list is
     * empty.
     */
    public E poll();

    /**
     * Retrieves and removes the last element of this list.
     *
     * @return the element in the last of this list, or 'null' if this list is
     * empty.
     */
    public E pollLast();

    /**
     * Retrieves and removes the first n elements of the list.
     *
     * @param n
     * @return an array containing the first n elements of the list.
     */
    public E[] pollArray(int n);

    /**
     * Retrieves and removes the last n elements of the list.
     *
     * @param n
     * @return an array containing the first n elements of the list.
     */
    public E[] pollLastArray(int n);

    /**
     * Retrieves and removes the first n elements of the list.
     *
     * @param n
     * @return a collection containing the first n elements of the list.
     */
    public List<E> pollCollection(int n);

    /**
     * Retrieves and removes the last n elements of the list
     *
     * @param n
     * @return a collection containing the last n elements of the list.
     */
    public List<E> pollLastCollection(int n);

    /**
     * Removes the first occurrence of the specified element from this list, if
     * it is present.
     *
     * @param element
     * @return 'true' if the element was removed successfully, otherwise
     * 'false'.
     */
    public boolean remove(E element);

    /**
     * Removes from this list all of its elements that are contained in the
     * specified collection.
     *
     * @param array
     * @return 'true' if the collection elements was removed successfully,
     * otherwise 'false'.
     */
    public boolean remove(E[] array);

    /**
     * Removes from this list all of its elements that are contained in the
     * specified collection.
     *
     * @param collection
     * @return 'true' if the collection elements was removed successfully,
     * otherwise 'false'.
     */
    public boolean remove(Collection<E> collection);

    /**
     * Removes all of the elements of this list that satisfy the given
     * predicate. Errors or runtime exceptions thrown during iteration or by the
     * predicate are relayed to the caller.
     *
     * @param filter
     * @return 'true' if the list was removed successfully, otherwise 'false'.
     */
    public boolean remove(Predicate<E> filter);

    /**
     * Replaces each element of this list with the result of applying the
     * function to that element.
     *
     * @param element
     * @param newElement
     * @param comparator
     * @return 'true' if the list was replaced successfully, otherwise 'false'.
     */
    public boolean replace(E element, E newElement, Predicate<E> comparator);

    /**
     * Replaces each element of this list with the result of applying the
     * function to that element.
     *
     * @param array
     * @param newArray
     * @param comparator
     * @return 'true' if the list was replaced successfully, otherwise 'false'.
     */
    public boolean replace(E[] array, E[] newArray, Predicate<E> comparator);

    /**
     * Replaces each element of this list with the result of applying the
     * function to that element.
     *
     * @param collection
     * @param newCollection
     * @param comparator
     * @return 'true' if the element was added successfully, otherwise 'false'.
     */
    public boolean replace(Collection<E> collection, Collection<E> newCollection, Predicate<E> comparator);

    /**
     * Retains only the elements in this list that are contained in the specified collection.
     *
     * 
     * @param array
     * @return 'true' if the list was retained successfully, otherwise 'false'.
     */
    public boolean retain(E[] array);

    /**
     * Retains only the elements in this list that are contained in the specified collection.
     *
     * 
     * @param collection
     * @return 'true' if the list was retained successfully, otherwise 'false'.
     */
    public boolean retain(Collection<E> collection);

    /**
     * Replaces the specified element by a new element in this list. Only the first occurrence is replaced.
     *
     * @param index
     * @param element
     * @return 'true' if the element was replaced successfully, otherwise 'false'.
     */
    public boolean set(E index, E element);

    /**
     * Sorts this list according to the order induced by the specified Comparator.
     *
     * @param toInt
     * @return 'true' if the list was sorted successfully, otherwise 'false'.
     */
    public boolean sort(ToIntFunction<E> toInt);

    /**
     * Returns a sub list of this list between the specified "from" and "to".
     *
     * @param from
     * @param to
     * @return a sub list of this list between the specified "from", inclusive, and "to", exclusive.
     */
    public List<E> subList(E from, E to);

    /**
     * Returns an array containing all of the elements in this list.
     *
     * @return an array containing all of the elements in this list.
     */
    public E[] toArray();

}
