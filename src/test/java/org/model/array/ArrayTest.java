/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.model.array;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.model.LinkedList.singly.LinkedList;
import org.model.util.iterator.Iterator;

/**
 *
 * @author PC 4060TI
 */
public class ArrayTest {
    
    public ArrayTest() {
    }

    /**
     * Test of add method, of class Array.
     */
    @Test
    public void testAdd_GenericType() {
        System.out.println("add");
        Object element = 3;
        Array instance = new Array(2);
        boolean expResult = true;
        boolean result = instance.add(element);
        assertEquals(expResult, result);
    }

    /**
     * Test of add method, of class Array.
     */
    @Test
    public void testAdd_int_GenericType() {
        System.out.println("add");
        int index = 4;
        Object[] array = {4,5,6};
        Array instance = new Array(5);
        boolean expResult = true;
        boolean result = instance.add(index, array);
        assertEquals(expResult, result);

    }

    /**
     * Test of add method, of class Array.
     */
    @Test
    public void testAdd_int_Collection() {
        System.out.println("add");
        Array instance = null;
        boolean expResult = false;
        boolean result = instance.add(null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of defragment method, of class Array.
     */
    @Test
    public void testDefragment() {
        System.out.println("defragment");
        Array instance = null;
        instance.defragment();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class Array.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int index = 0;
        Array instance = null;
        Object expResult = null;
        Object result = instance.get(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of indexOf method, of class Array.
     */
    @Test
    public void testIndexOf() {
        System.out.println("indexOf");
        Object element = null;
        Array instance = null;
        int expResult = 0;
        int result = instance.indexOf(element);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lastIndexOf method, of class Array.
     */
    @Test
    public void testLastIndexOf() {
        System.out.println("lastIndexOf");
        Object element = null;
        Array instance = null;
        int expResult = 0;
        int result = instance.lastIndexOf(element);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class Array.
     */
    @Test
    public void testRemove_int() {
        System.out.println("remove");
        int index = 0;
        Array instance = null;
        boolean expResult = false;
        boolean result = instance.remove(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class Array.
     */
    @Test
    public void testRemove_Predicate() {
        System.out.println("remove");
        Array instance = null;
        boolean expResult = false;
        boolean result = instance.remove(null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class Array.
     */
    @Test
    public void testRemove_int_int() {
        System.out.println("remove");
        int from = 0;
        int to = 0;
        Array instance = null;
        boolean expResult = false;
        boolean result = instance.remove(from, to);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dimension method, of class Array.
     */
    @Test
    public void testDimension() {
        System.out.println("dimension");
        int newDimension = 0;
        Array instance = null;
        boolean expResult = false;
        boolean result = instance.dimension(newDimension);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of set method, of class Array.
     */
    @Test
    public void testSet() {
        System.out.println("set");
        int index = 0;
        Object element = null;
        Array instance = null;
        boolean expResult = false;
        boolean result = instance.set(index, element);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class Array.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        Array instance = null;
        boolean expResult = false;
        boolean result = instance.clear();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contains method, of class Array.
     */
    @Test
    public void testContains_1args_1() {
        System.out.println("contains");
        Object element = null;
        Array instance = null;
        boolean expResult = false;
        boolean result = instance.contains(element);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contains method, of class Array.
     */
    @Test
    public void testContains_1args_2() {
        System.out.println("contains");
        Object[] array = null;
        Array instance = null;
        boolean expResult = false;
        boolean result = instance.contains(array);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contains method, of class Array.
     */
    @Test
    public void testContains_Collection() {
        System.out.println("contains");
        Array instance = null;
        boolean expResult = false;
        boolean result = instance.contains(1);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class Array.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Array instance = null;
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reverse method, of class Array.
     */
    @Test
    public void testReverse() {
        System.out.println("reverse");
        Array instance = null;
        boolean expResult = false;
        boolean result = instance.reverse();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class Array.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        Array instance = null;
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of iterator method, of class Array.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        Array instance = null;
        Iterator expResult = null;
        Iterator result = instance.iterator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of forEach method, of class Array.
     */
    @Test
    public void testForEach() {
        System.out.println("forEach");
        Array instance = null;
        instance.forEach(null);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
