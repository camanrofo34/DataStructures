package org.model.tree.avltree;

import org.model.LinkedList.doubly.circular.LinkedList;
import org.model.queue.list.Queue;
import org.model.util.list.List;

public class AVLTree<E extends Comparable> {
    AVLNode<E> root;
    int height;

    public AVLTree() {
        this.root = null;
        this.height = 0;
    }

    public void insert(E element){
        root = insertPriv(element, root);
    }

    private AVLNode<E> insertPriv(E element, AVLNode<E> node){
        if (node == null){
            node = new AVLNode<>(element);
        } else if (element.compareTo(node.getElement()) < 0){
            node.setLeft(insertPriv(element, node.getLeft()));
            if (height(node.getLeft()) - height(node.getRight()) == 2){
                if (element.compareTo(node.getLeft().getElement()) < 0){
                    node = rotateWithLeftChild(node);
                } else {
                    node = doubleWithLeftChild(node);
                }
            }
        } else if (element.compareTo(node.getElement()) > 0){
            node.setRight(insertPriv(element, node.getRight()));
            if (height(node.getRight()) - height(node.getLeft()) == 2){
                if (element.compareTo(node.getRight().getElement()) > 0){
                    node = rotateWithRightChild(node);
                } else {
                    node = doubleWithRightChild(node);
                }
            }
        }
        node.setHeight(max(height(node.getLeft()), height(node.getRight()) + 1));
        return node;
    }

    private static int max(int lhs, int rhs){
        return lhs > rhs ? lhs : rhs;
    }

    private AVLNode<E> rotateWithLeftChild(AVLNode<E> k2){
        AVLNode<E> k1 = k2.getLeft();
        k2.setLeft(k1.getRight());
        k1.setRight(k2);
        k2.setHeight(max(height(k2.getLeft()), height(k2.getRight())) + 1);
        k1.setHeight(max(height(k1.getLeft()), k2.getHeight()) + 1);
        return k1;
    }

     private AVLNode<E> rotateWithRightChild(AVLNode<E> k1) {
         AVLNode<E> k2 = k1.getRight();
         k1.setRight(k2.getLeft());
         k2.setLeft(k1);
         k1.setHeight(max(height(k1.getLeft()), height(k1.getRight())) + 1);
         k2.setHeight(max(height(k2.getRight()), k1.getHeight()) + 1);
         return k2;
     }

     private AVLNode<E> doubleWithLeftChild(AVLNode<E> k3) {
         k3.setLeft(rotateWithRightChild(k3.getLeft()));
         return rotateWithLeftChild(k3);
     }

     private AVLNode<E> doubleWithRightChild(AVLNode<E> k1) {
        k1.setRight(rotateWithLeftChild(k1.getRight()));
        return rotateWithRightChild(k1);
    }

    private int height(AVLNode<E> node){
        return node == null ? -1 : node.getHeight();
    }

    public List<E> binTreePreOrden() {
        List<E> list = new LinkedList<>();
        preOrderRoot(root, list);
        return list;
    }

    public Boolean binTreePreOrdenSearch(E element) {
        return preOrderRootSearch(root, element);
    }

    private Boolean preOrderRootSearch(AVLNode<E> node, E element) {
        if (node != null) {
            if (node.getElement().equals(element)) {
                return true;
            }
            else if (preOrderRootSearch(node.getLeft(), element)) {
                return true;
            }
            else return preOrderRootSearch(node.getRight(), element);
        }
        return false;
    }

    private void preOrderRoot(AVLNode<E> node, List<E> list) {
        if (node != null) {
            list.add(node.getElement());
            preOrderRoot(node.getLeft(), list);
            preOrderRoot(node.getRight(), list);
        }
    }

    public List<E> binTreeInOrder() {
        List<E> list = new LinkedList<>();
        inOrderRoot(root, list);
        return list;
    }

    public Boolean binTreeInOrderSearch(E element) {
        return inOrderRootSearch(root, element);
    }

    private void inOrderRoot(AVLNode<E> node, List<E> list) {
        if (node != null) {
            inOrderRoot(node.getLeft(), list);
            list.add(node.getElement());
            inOrderRoot(node.getRight(), list);
        }
    }

    private Boolean inOrderRootSearch(AVLNode<E> node, E element) {
        if (node != null) {
            if (inOrderRootSearch(node.getLeft(), element)) {
                return true;
            }
            else if (node.getElement().equals(element)) {
                return true;
            }
            else return inOrderRootSearch(node.getRight(), element);
        }
        return false;
    }

    public List<E> binTreePosOrder() {
        List<E> list = new LinkedList<>();
        posOrderRoot(root, list);
        return list;
    }

    private void posOrderRoot(AVLNode<E> node, List<E> list) {
        if (node != null) {
            posOrderRoot(node.getLeft(), list);
            posOrderRoot(node.getRight(), list);
            list.add(node.getElement());
        }
    }

    public Boolean binTreePosOrderSearch(E element) {
        return posOrderRootSearch(root, element);
    }

    private Boolean posOrderRootSearch(AVLNode<E> node, E element) {
        if (node != null) {
            if (posOrderRootSearch(node.getLeft(), element)) {
                return true;
            }
            else if (posOrderRootSearch(node.getRight(), element)) {
                return true;
            }
            else return node.getElement().equals(element);
        }
        return false;
    }

    public List<E> binTreeDepthOrder() {
        List<E> list = new LinkedList<>();
        Queue<AVLNode<E>> auxiliar = new Queue<>();
        auxiliar.insert(root);
        depthOrder(auxiliar, list);
        return list;
    }

    public Boolean binTreeDepthSearch(E element) {
        Queue<AVLNode<E>> auxiliar = new Queue<>();
        auxiliar.insert(root);
        return depthSearch(auxiliar, element);
    }

    private Boolean depthSearch(Queue<AVLNode<E>> nodes, E element) {
        if (!nodes.isEmpty()) {
            Queue<AVLNode<E>> auxiliar = new Queue<>();
            while (!nodes.isEmpty()) {
                AVLNode<E> node = nodes.extract();
                if (node.getElement().equals(element)) {
                    return true;
                }
                if (node.getLeft() != null) {
                    auxiliar.insert(node.getLeft());
                }
                if (node.getRight() != null) {
                    auxiliar.insert(node.getRight());
                }
            }
            return depthSearch(auxiliar, element);
        }
        return false;
    }

    private void depthOrder(Queue<AVLNode<E>> nodes, List<E> list) {
        if (!nodes.isEmpty()) {
            Queue<AVLNode<E>> auxiliar = new Queue<>();
            while (!nodes.isEmpty()) {
                AVLNode<E> node = nodes.extract();
                list.add(node.getElement());
                if (node.getLeft() != null) {
                    auxiliar.insert(node.getLeft());
                }
                if (node.getRight() != null) {
                    auxiliar.insert(node.getRight());
                }
            }
            depthOrder(auxiliar, list);
        }
    }

    public int height() {
        this.height = 0;
        Queue<AVLNode<E>> auxiliar = new Queue<>();
        auxiliar.insert(root);
        countHeight(auxiliar);
        return height;
    }

    private void countHeight(Queue<AVLNode<E>> nodes) {
        if (!nodes.isEmpty()) {
            Queue<AVLNode<E>> auxiliar = new Queue<>();
            while (!nodes.isEmpty()) {
                AVLNode<E> node = nodes.extract();
                if (node.getLeft() != null) {
                    auxiliar.insert(node.getLeft());
                }
                if (node.getRight() != null) {
                    auxiliar.insert(node.getRight());
                }
            }
            height++;
            countHeight(auxiliar);
        }
    }

    public boolean isCompleteTree() {
        return isComplete(root);
    }

    private boolean isComplete(AVLNode<E> node) {
        if (node == null) {
            return true;
        }
        int branchCount = branchCount(node);
        if (branchCount == 1) {
            return false;
        }
        return isComplete(node.getLeft()) && isComplete(node.getRight());
    }

    private int branchCount(AVLNode<E> node) {
        int i = 0;
        if (node.getLeft() != null) {
            i++;
        }
        if (node.getRight() != null) {
            i++;
        }
        return i;
    }

}
