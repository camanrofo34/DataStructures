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

    protected Node<E> root;
    protected int height;

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

    public Boolean binTreePreOrdenSearch(E element) {
        return preOrderRootSearch(root, element);
    }

    private Boolean preOrderRootSearch(Node<E> node, E element) {
        if (node != null) {
            if (node.getRoot().equals(element)) {
                return true;
            }
            else if (preOrderRootSearch(node.getLeft(), element)) {
                return true;
            }
            else return preOrderRootSearch(node.getRight(), element);
        }
        return false;
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

    public Boolean binTreeInOrderSearch(E element) {
        return inOrderRootSearch(root, element);
    }

    private void inOrderRoot(Node<E> node, List<E> list) {
        if (node != null) {
            inOrderRoot(node.getLeft(), list);
            list.add(node.getRoot());
            inOrderRoot(node.getRight(), list);
        }
    }

    private Boolean inOrderRootSearch(Node<E> node, E element) {
        if (node != null) {
            if (inOrderRootSearch(node.getLeft(), element)) {
                return true;
            }
            else if (node.getRoot().equals(element)) {
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

    private void posOrderRoot(Node<E> node, List<E> list) {
        if (node != null) {
            posOrderRoot(node.getLeft(), list);
            posOrderRoot(node.getRight(), list);
            list.add(node.getRoot());
        }
    }

    public Boolean binTreePosOrderSearch(E element) {
        return posOrderRootSearch(root, element);
    }

    private Boolean posOrderRootSearch(Node<E> node, E element) {
        if (node != null) {
            if (posOrderRootSearch(node.getLeft(), element)) {
                return true;
            }
            else if (posOrderRootSearch(node.getRight(), element)) {
                return true;
            }
            else return node.getRoot().equals(element);
        }
        return false;
    }

    public List<E> binTreeDepthOrder() {
        List<E> list = new LinkedList<>();
        Queue<Node<E>> auxiliar = new Queue<>();
        auxiliar.insert(root);
        depthOrder(auxiliar, list);
        return list;
    }

    public Boolean binTreeDepthSearch(E element) {
        Queue<Node<E>> auxiliar = new Queue<>();
        auxiliar.insert(root);
        return depthSearch(auxiliar, element);
    }

    private Boolean depthSearch(Queue<Node<E>> nodes, E element) {
        if (!nodes.isEmpty()) {
            Queue<Node<E>> auxiliar = new Queue<>();
            while (!nodes.isEmpty()) {
                Node<E> node = nodes.extract();
                if (node.getRoot().equals(element)) {
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

    private void depthOrder(Queue<Node<E>> nodes, List<E> list) {
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
            depthOrder(auxiliar, list);
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

    public Boolean insert(E element) {
        if (root == null) {
            root = new Node<>(element);
            return true;
        } else {
            Queue<Node<E>> auxiliar = new Queue<>();
            auxiliar.insert(root);
            depthInsertR(auxiliar, element);
        }
        return true;

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

    public Boolean delete(E element) {
        delete(root, element);
        return true;
    }

    private void delete(Node<E> root, E key)
    {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            if (root.getRoot() == key) {
                root = null;
                return;
            }
            else
                return;
        }

        Queue<Node<E>> q = new Queue<>();
        q.insert(root);
        Node<E> temp = null, keyNode = null;

        // Do level order traversal until
        // we find key and last node.
        while (!q.isEmpty()) {
            temp = q.peek();
            q.extract();

            if (temp.getRoot() == key)
                keyNode = temp;

            if (temp.left != null)
                q.insert(temp.left);

            if (temp.right != null)
                q.insert(temp.right);
        }

        if (keyNode != null) {
            E x = temp.getRoot();
            keyNode.setRoot(x); ;
            deleteDeepest(root, temp);
        }
    }

    private void deleteDeepest(Node<E> root, Node<E> delNode)
    {
        Queue<Node<E>> q = new Queue<Node<E>>();
        q.insert(root);

        Node<E> temp = null;

        // Do level order traversal until last node
        while (!q.isEmpty()) {
            temp = q.peek();
            q.extract();

            if (temp == delNode) {
                temp = null;
                return;
            }
            if (temp.right != null) {
                if (temp.right == delNode) {
                    temp.right = null;
                    return;
                }
                else
                    q.insert(temp.right);
            }

            if (temp.left != null) {
                if (temp.left == delNode) {
                    temp.left = null;
                    return;
                }
                else
                    q.insert(temp.left);
            }
        }
    }

}
