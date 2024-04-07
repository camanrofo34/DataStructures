package org.model.util.collection;
import org.model.util.iterable.Iterable;

import java.io.Serializable;

public interface Collection<E> extends Iterable<E>, Serializable {
    static final long serialVersionUID = 1L;
    /**
     * Removes all elements from the collection.
     *
     * @return 'true' if the list was cleared successfully, otherwise 'false'.
     */
    boolean clear();

    /**
     * Determines if the collection contains the specified element.
     *
     * @param element the element to search for.
     * @return 'true' if the collection contains the specified element, otherwise
     *         'false'.
     */
    boolean contains(E element);

    /**
     * Determines if the collection contains the specified elements in the array.
     *
     * @param array the array containing elements to be searched for in this
     *              collection.
     * @return 'true' if the collection contains the specified elements in the
     *         array, otherwise 'false'.
     */
    boolean contains(E[] array);

    /**
     * Determines if the collection contains the specified elements.
     *
     * @param collection the collection containing elements to be searched for in
     *                   this collection.
     * @return 'true' if the collection contains the specified elements, otherwise
     *         'false'.
     */
    boolean contains(Collection<E> collection);

    /**
     * Determines if the collection contains any element.
     *
     * @return 'false' if the collection contains any element, otherwise 'true'.
     */
    boolean isEmpty();

    /**
     * Redistributes the elements in the collection in reverse order.
     *
     * @return 'true' if the collection was reversed successfully, otherwise
     *         'false'.
     */
    boolean reverse();

    /**
     * Gets the size of the collection.
     *
     * @return the number of elements in this collection.
     */
    int size();

}
