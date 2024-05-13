package org.model.tree.avltree;

public class AVLNode<E extends Comparable> {

        private E element;
        private AVLNode<E> left;
        private AVLNode<E> right;
        private int height;

        public AVLNode(E element) {
            this.element = element;
            this.left = null;
            this.right = null;
            this.height = 0;
        }

        public AVLNode(E element, AVLNode<E> left, AVLNode<E> right) {
            this.element = element;
            this.left = left;
            this.right = right;
            this.height = 0;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public AVLNode<E> getLeft() {
            return left;
        }

        public void setLeft(AVLNode<E> left) {
            this.left = left;
        }

        public AVLNode<E> getRight() {
            return right;
        }

        public void setRight(AVLNode<E> right) {
            this.right = right;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
}
