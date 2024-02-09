package org.model.util.iterator;

public interface Iterator<E> {
    /**
     * Determines if the iterator has more elements.
     * @return 'true' if the iterator has more elements, otherwise 'false'.
     */
    public boolean hasNext();

    /**
     * Gets the next element in the iteration.
     * @return the next element in the iteration.
     */
    public E next();
}
