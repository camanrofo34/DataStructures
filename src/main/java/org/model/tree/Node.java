/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.model.tree;

/**
 *
 * @author informatica
 */
public class Node<E> implements Cloneable{

    E root;
    Node<E> left;
    Node<E> right;

    public Node(E root) {
        this.left = null;
        this.right = null;
        this.root = root;
    }

    public Node(E root, Node<E> left, Node<E> right) {
        this.root = root;
        this.left = left;
        this.right = right;
    }
    
    public Node() {
        this.left = null;
        this.right = null;
        this.root = null;
    }

    public E getRoot() {
        return root;
    }

    public void setRoot(E root) {
        this.root = root;
    }

    public Node<E> getLeft() {
        return left;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public Node<E> getRight() {
        return right;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }

}
