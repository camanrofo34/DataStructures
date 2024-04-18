package org.model.tree;

import java.util.function.ToIntFunction;

public class BinSearchTree<E> extends BinaryTree<E> {

    private final ToIntFunction<E> comparator;

    public BinSearchTree(ToIntFunction<E> comparator) {
        super();
        this.comparator = comparator;
    }

    public Boolean insert(E element) {
        return insertPriv(element, root);
    }

    private Boolean insertPriv(E element, Node<E> node) {
        if (node != null) {
            if (comparator.applyAsInt(element) < comparator.applyAsInt(node.getRoot())) {
                if (node.getLeft() == null) {
                    Node<E> otro = new Node<>(element);
                    node.setLeft(otro);
                    return true;
                } else {
                    insertPriv(element, node.getLeft());
                }
            } else if (comparator.applyAsInt(element) > comparator.applyAsInt(node.getRoot())) {
                if (node.getRight() == null) {
                    Node<E> otro = new Node<>(element);
                    node.setRight(otro);
                    return true;
                } else {
                    insertPriv(element, node.getRight());
                }
            }
        } else {
            Node<E> otro = new Node<>(element);
            this.root = otro;
            return true;
        }
        return false;
    }

    public Boolean search(E element) {
        return searchPriv(element, root);
    }

    private Boolean searchPriv(E element, Node<E> node) {
        if (node != null) {
            if (comparator.applyAsInt(element) == comparator.applyAsInt(node.getRoot())) {
                return true;
            } else if (comparator.applyAsInt(element) < comparator.applyAsInt(node.getRoot())) {
                return searchPriv(element, node.getLeft());
            } else if (comparator.applyAsInt(element) > comparator.applyAsInt(node.getRoot())) {
                return searchPriv(element, node.getRight());
            }
        }
        return false;
    }


    public Boolean delete(E element) {
        deletePriv(element, root);
        return true;
    }

    private Node<E> deletePriv(E element, Node<E> node) {
        if (node == null) {
            return null;
        } else if (comparator.applyAsInt(element) < comparator.applyAsInt(node.getRoot())) {
            Node<E> left;
            left = deletePriv(element, node.getLeft());
            node.setLeft(left);
        } else if (comparator.applyAsInt(element) > comparator.applyAsInt(node.getRoot())) {
            Node<E> right;
            right = deletePriv(element, node.getRight());
            node.setRight(right);
        } else {
            Node<E> q = node;
            if (q.getLeft() == null) {
                node = q.getRight();
            } else if (q.getRight() == null) {
                node = q.getLeft();
            } else {
                q = replace(q);
            }
            q = null;
        }
        return node;
    }

    private Node<E> replace(Node<E> node) {
        Node<E> aux = node;
        Node<E> aux1 = node.getLeft();
        while (aux1.getRight() != null) {
            aux = aux1;
            aux1 = aux1.getRight();
        }
        node.setRoot(aux1.getRoot());
        if (aux == node) {
            aux.setLeft(aux1.getLeft());
        } else {
            aux.setRight(aux1.getLeft());
        }
        return aux1;
    }

}
