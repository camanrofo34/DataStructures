/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.model.array;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.model.util.iterator.Iterator;

/**
 *
 * @author PC 4060TI
 */
public class ArrayTest {

    private Array<Integer> integerArray;

    @BeforeEach
    void setUp() {
        integerArray = new Array<>(5);
    }

    @Test
    void testAdd() {
        assertTrue(integerArray.add(1));
        assertTrue(integerArray.add(2));
    }

    @Test
    void testAddAtIndexWithArray() {
        Integer[] newArray = {10, 20, 30};
        assertTrue(integerArray.add(1, newArray));
        assertFalse(integerArray.add(4, newArray));
    }


    @Test
    void testDefragment() {
        integerArray.add(1);
        integerArray.add(2);
        integerArray.add(3);
        integerArray.remove(0);
        integerArray.defragment();
        assertEquals(2, integerArray.get(0));
    }

    @Test
    void testGet() {
        integerArray.add(1);
        integerArray.add(2);
        assertEquals(1, integerArray.get(0));
        assertNull(integerArray.get(2));
    }

    @Test
    void testIndexOf() {
        integerArray.add(1);
        integerArray.add(2);
        assertEquals(0, integerArray.indexOf(1));
        assertEquals(-1, integerArray.indexOf(3));
    }

    @Test
    void testLastIndexOf() {
        integerArray.add(1);
        integerArray.add(2);
        integerArray.add(1);
        assertEquals(2, integerArray.lastIndexOf(1));
        assertEquals(-1, integerArray.lastIndexOf(3));
    }

    @Test
    void testRemoveByIndex() {
        integerArray.add(1);
        integerArray.add(2);
        assertTrue(integerArray.remove(1));
        assertNull(integerArray.get(1));
    }

    @Test
    void testRemoveByFilter() {
        integerArray.add(1);
        integerArray.add(2);
        assertTrue(integerArray.remove(x -> x == 2));
        assertNull(integerArray.get(1));
    }

    @Test
    void testRemoveByRange() {
        integerArray.add(1);
        integerArray.add(2);
        integerArray.add(3);
        assertTrue(integerArray.remove(1, 3));
        assertNull(integerArray.get(1));
        assertNull(integerArray.get(2));
    }


    @Test
    void testSet() {
        integerArray.add(1);
        assertTrue(integerArray.set(0, 5));
        assertEquals(5, integerArray.get(0));
    }

    @Test
    void testClear() {
        integerArray.add(1);
        integerArray.add(2);
        assertTrue(integerArray.clear());
        assertEquals(0, integerArray.size());
    }

    @Test
    void testContainsElement() {
        integerArray.add(1);
        assertTrue(integerArray.contains(1));
        assertFalse(integerArray.contains(2));
    }

    @Test
    void testContainsArray() {
        integerArray.add(1);
        integerArray.add(2);
        Integer[] testArray = {1, 2};
        assertTrue(integerArray.contains(testArray));
        Integer[] testArray2 = {2, 3};
        assertFalse(integerArray.contains(testArray2));
    }

    @Test
    void testIsEmpty() {
        assertTrue(integerArray.isEmpty());
        integerArray.add(1);
        assertFalse(integerArray.isEmpty());
    }

    @Test
    void testReverse() {
        integerArray.add(1);
        integerArray.add(2);
        integerArray.add(3);
        assertTrue(integerArray.reverse());
        assertEquals(3, integerArray.get(0));
        assertEquals(2, integerArray.get(1));
        assertEquals(1, integerArray.get(2));
    }

    @Test
    void testSize() {
        assertEquals(0, integerArray.size());
        integerArray.add(1);
        integerArray.add(2);
        assertEquals(2, integerArray.size());
    }

}
