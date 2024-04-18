/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.model.tree;

import org.model.LinkedList.doubly.circular.LinkedList;
import org.model.util.iterator.Iterator;
import org.model.util.list.List;

/**
 *
 * @author PC 4060TI
 */
public class BinTreeTry {

    public static void main(String[] args) {
        Node<String> root = new Node<>("+", new Node<>("*", new Node<>("a"), new Node<>("b")), new Node<>("/", new Node<>("c", new Node<>("z"), null), new Node<>("d")));

        BinaryTree<String> bin = new BinaryTree<>(root);

        LinkedList<String> preList = (LinkedList<String>) bin.binTreePreOrden();
        Iterator<String> iteratorPre = preList.iterator();
        while (iteratorPre.hasNext()) {
            System.out.print(iteratorPre.next() + " ");
        }
        System.out.println("");
        LinkedList<String> inList = (LinkedList<String>) bin.binTreeInOrder();
        Iterator<String> iteratorIn = inList.iterator();
        while (iteratorIn.hasNext()) {
            System.out.print(iteratorIn.next() + " ");
        }
        System.out.println("");
        LinkedList<String> posList = (LinkedList<String>) bin.binTreePosOrder();
        Iterator<String> iteratorPos = posList.iterator();
        while (iteratorPos.hasNext()) {
            System.out.print(iteratorPos.next() + " ");
        }
        System.out.println("");

        LinkedList<String> depthList = (LinkedList<String>) bin.binTreeDepthOrder();
        Iterator<String> iteratorDepth = depthList.iterator();
        while (iteratorDepth.hasNext()) {
            System.out.print(iteratorDepth.next() + " ");
        }
        System.out.println("");
        System.out.print(bin.height());
        System.out.println("");
        System.out.println(bin.isCompleteTree());

        BinaryTree<String> binCreate = new BinaryTree<>();
        binCreate.insert("a");
        binCreate.insert("b");
        binCreate.insert("c");
        binCreate.insert("d");
        binCreate.insert("e");
        binCreate.insert("f");
        binCreate.insert("g");
        System.out.println(binCreate.isCompleteTree());
        System.out.println(binCreate.binTreeDepthSearch("a"));
        System.out.println(binCreate.binTreeInOrderSearch("b"));
        System.out.println(binCreate.binTreeInOrderSearch("c"));
        System.out.println(binCreate.binTreePosOrderSearch("d"));
        binCreate.delete("b");
        LinkedList<String> depthList2 = (LinkedList<String>) binCreate.binTreePreOrden();
        Iterator<String> iteratorDepth2 = depthList2.iterator();
        while (iteratorDepth2.hasNext()) {
            System.out.print(iteratorDepth2.next() + " ");
        }
        System.out.println("");

        BinSearchTree<Integer> BST = new BinSearchTree<>(e -> e);
        BST.insert(4);
        BST.insert(15);
        BST.insert(6);
        BST.insert(8);
        BST.insert(5);
        BST.insert(3);
        BST.insert(7);
        BST.insert(2);
        BST.delete(4);
        BST.delete(8);
        List<Integer> list = BST.binTreeDepthOrder();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println("");
        System.out.println(BST.search(15));
        System.out.println(BST.search(10));


    }
}
