package org.model.util.iterable;

import org.model.util.iterator.Iterator;

import java.io.Serializable;
import java.util.function.Function;

public interface Iterable<E> extends Serializable {
    /**
     * For each element in the iterator, executes the specified action.
     * @param action
     */
    public void forEach(Function<E, Void> action);
    /**
     * Gets an iterator over the elements in the iterator.
     * @return an iterator over the elements in the iterator.
     */
    public Iterator<E> iterator();
}
