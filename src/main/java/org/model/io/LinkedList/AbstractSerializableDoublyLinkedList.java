package org.model.io.LinkedList;

import org.model.LinkedList.doubly.LinkedList;

import java.io.Serializable;

public abstract class AbstractSerializableDoublyLinkedList<E extends Serializable> extends LinkedList<E> implements Serializable {
    protected static final long serialVersionUID = 1L;

    public AbstractSerializableDoublyLinkedList() {
    }

    public AbstractSerializableDoublyLinkedList(E element) {
        super(element);
    }

    public AbstractSerializableDoublyLinkedList(E[] array) {
        super(array);
    }
}
