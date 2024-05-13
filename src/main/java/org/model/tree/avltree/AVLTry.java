package org.model.tree.avltree;

import org.model.util.iterator.Iterator;

public class AVLTry {

    public static AVLTree<Integer> avlTree = new AVLTree<>();

    public static void main(String[] args) {
        avlTree.insert(48);
        avlTree.insert(65);
        avlTree.insert(33);
        avlTree.insert(76);
        avlTree.insert(55);
        avlTree.insert(60);
        avlTree.insert(57);
        avlTree.insert(63);
        avlTree.insert(83);
        avlTree.insert(59);

        System.out.println(avlTree.isCompleteTree());
        Iterator<Integer> iterator = avlTree.binTreePosOrder().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

}
