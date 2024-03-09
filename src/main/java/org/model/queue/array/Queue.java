
package org.model.queue.array;

import java.util.function.Function;
import org.model.array.Array;
import org.model.util.collection.Collection;
import org.model.util.iterator.Iterator;
import org.model.util.queue.AbstractQueue;

public class Queue<E> extends AbstractQueue<E> {

    Array<E> queue;
    int dimension;
    int head;
    int tail;

    public Queue(int dimension) {
        this.dimension = dimension;
        this.queue = new Array<>(dimension);
        this.head = 0;
        this.tail = 0;
    }

    @Override
    public boolean clear() {
        return queue.clear();
    }

    @Override
    public boolean contains(E element) {
        return queue.contains(element);
    }

    @Override
    public boolean contains(E[] array) {
        return queue.contains(array);
    }

    @Override
    public boolean contains(Collection<E> collection) {
        return queue.contains(collection);
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public boolean reverse() {
        return queue.reverse();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public void forEach(Function<E, Void> action) {
        queue.forEach(action);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            int count = 0;
            int apuntador = head;
            @Override
            public boolean hasNext() {
                return count++ < queue.size();
            }

            @Override
            public E next() {
                if (apuntador >= dimension) {
                    apuntador=0;
                }
                return queue.get(apuntador++);
            }
        };
    }

    @Override
    public E peek() {
        return queue.get(head);
    }

    @Override
    public E extract() {
        E element = queue.get(head);
        if(queue.remove(head++) && element != null){
            head %= dimension;
            return element;
        }
        return null;
    }

    @Override
    public boolean insert(E element) {
        if (queue.add(element)) {
            tail = (tail+1)%dimension;
            return true;
        }
        return false;
    }
}