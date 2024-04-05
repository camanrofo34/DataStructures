/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.model.tree;

import org.model.LinkedList.doubly.circular.LinkedList;
import org.model.util.iterator.Iterator;

/**
 *
 * @author PC 4060TI
 */
public class BinTreeTry {

    public static void main(String[] args) {
        Node<String> root = new Node<>("+", new Node<>("*", new Node<>("a"), new Node<>("b")), new Node<>("/", new Node<>("c", new Node<>("h"), null), new Node<>("d")));

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
        
        LinkedList<String> depthList = (LinkedList<String>) bin.binTreeDepthSearch();
        Iterator<String> iteratorDepth = depthList.iterator();
        while (iteratorDepth.hasNext()) {
            System.out.print(iteratorDepth.next() + " ");
        }
        System.out.println("");
        
        System.out.println(bin.height());
        
        
        
    }
}
