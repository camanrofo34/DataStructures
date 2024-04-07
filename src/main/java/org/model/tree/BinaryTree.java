/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.model.tree;

import org.model.LinkedList.doubly.circular.LinkedList;
import org.model.queue.list.Queue;
import org.model.util.list.List;

/**
 *
 * @author informatica
 */
public class BinaryTree<E> {

    private Node<E> root;
    private int height;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(E element) {
        this.root = new Node<>(element);
    }

    public BinaryTree(Node<E> root) {
        this.root = root;
    }

    public List<E> binTreePreOrden() {
        List<E> list = new LinkedList<>();
        preOrderRoot(root, list);
        return list;
    }

    private void preOrderRoot(Node<E> node, List<E> list) {
        if (node != null) {
            list.add(node.getRoot());
            preOrderRoot(node.getLeft(), list);
            preOrderRoot(node.getRight(), list);
        }
    }

    public List<E> binTreeInOrder() {
        List<E> list = new LinkedList<>();
        inOrderRoot(root, list);
        return list;
    }

    private void inOrderRoot(Node<E> node, List<E> list) {
        if (node != null) {
            inOrderRoot(node.getLeft(), list);
            list.add(node.getRoot());
            inOrderRoot(node.getRight(), list);
        }
    }

    public List<E> binTreePosOrder() {
        List<E> list = new LinkedList<>();
        posOrderRoot(root, list);
        return list;
    }

    private void posOrderRoot(Node<E> node, List<E> list) {
        if (node != null) {
            posOrderRoot(node.getLeft(), list);
            posOrderRoot(node.getRight(), list);
            list.add(node.getRoot());
        }
    }

    public List<E> binTreeDepthSearch() {
        List<E> list = new LinkedList<>();
        Queue<Node<E>> auxiliar = new Queue<>();
        auxiliar.insert(root);
        depthSearch(auxiliar, list);
        return list;
    }

    private void depthSearch(Queue<Node<E>> nodes, List<E> list) {
        if (!nodes.isEmpty()) {
            Queue<Node<E>> auxiliar = new Queue<>();
            while (!nodes.isEmpty()) {
                Node<E> node = nodes.extract();
                list.add(node.getRoot());
                if (node.getLeft() != null) {
                    auxiliar.insert(node.getLeft());
                }
                if (node.getRight() != null) {
                    auxiliar.insert(node.getRight());
                }
            }
            depthSearch(auxiliar, list);
        }
    }

    public int height() {
        this.height = 0;
        Queue<Node<E>> auxiliar = new Queue<>();
        auxiliar.insert(root);
        countHeight(auxiliar);
        return height;
    }

    private void countHeight(Queue<Node<E>> nodes) {
        if (!nodes.isEmpty()) {
            Queue<Node<E>> auxiliar = new Queue<>();
            while (!nodes.isEmpty()) {
                Node<E> node = nodes.extract();
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

    private boolean isComplete(Node<E> node) {
        if (node == null) {
            return true;
        }
        int branchCount = branchCount(node);
        if (branchCount == 1) {
            return false;
        }
        return isComplete(node.getLeft()) && isComplete(node.getRight());
    }

    private int branchCount(Node<E> node) {
        int i = 0;
        if (node.getLeft() != null) {
            i++;
        }
        if (node.getRight() != null) {
            i++;
        }
        return i;
    }

    public void depthInsert(E element) {
        if (root == null) {
            root = new Node<>(element);
        } else {
            Queue<Node<E>> auxiliar = new Queue<>();
            auxiliar.insert(root);
            depthInsertR(auxiliar, element);
        }

    }

    private void depthInsertR(Queue<Node<E>> nodes, E element) {
        boolean agregado = false;
        Queue<Node<E>> auxiliar = new Queue<>();
        while (!nodes.isEmpty() && !agregado) {
            Node<E> node = nodes.extract();
            if (node.getLeft() == null && !agregado) {
                node.setLeft(new Node<>(element));
                agregado = true;
            } else {
                auxiliar.insert(node.getLeft());
            }
            if (node.getRight() == null && !agregado) {
                node.setRight(new Node<>(element));
                agregado = true;
            }
            {
                auxiliar.insert(node.getRight());
            }
        }
        if (!agregado) {
            depthInsertR(auxiliar, element);
        }
    }

}
