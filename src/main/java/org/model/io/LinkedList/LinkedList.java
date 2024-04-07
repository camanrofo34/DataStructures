package org.model.io.LinkedList;

import java.io.Serializable;

public class LinkedList<E extends Serializable> extends AbstractSerializableDoublyLinkedList<E>{

    public LinkedList() {
    }

    public LinkedList(E element) {
        super(element);
    }

    public LinkedList(E[] array) {
        super(array);
    }
}
