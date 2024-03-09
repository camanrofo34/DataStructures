/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.model.queue.list;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.model.util.iterator.Iterator;

/**
 *
 * @author PC 4060TI
 */
public class QueueTest {
    
    private Queue<Integer> integerQueue;

    @BeforeEach
    void setUp() {
        integerQueue = new Queue<>();
    }

    @Test
    void testClear() {
        integerQueue.insert(1);
        integerQueue.insert(2);
        assertTrue(integerQueue.clear());
        assertTrue(integerQueue.isEmpty());
    }

    @Test
    void testContainsElement() {
        integerQueue.insert(1);
        assertTrue(integerQueue.contains(1));
        assertFalse(integerQueue.contains(2));
    }

    @Test
    void testContainsArray() {
        integerQueue.insert(1);
        integerQueue.insert(2);
        Integer[] testArray = {1, 2};
        assertTrue(integerQueue.contains(testArray));
        Integer[] testArray2 = {2, 3};
        assertFalse(integerQueue.contains(testArray2));
    }

    @Test
    void testIsEmpty() {
        assertTrue(integerQueue.isEmpty());
        integerQueue.insert(1);
        assertFalse(integerQueue.isEmpty());
    }

    @Test
    void testReverse() {
        integerQueue.insert(1);
        integerQueue.insert(2);
        assertTrue(integerQueue.reverse());
        assertEquals(2, integerQueue.peek());
    }

    @Test
    void testSize() {
        assertEquals(0, integerQueue.size());
        integerQueue.insert(1);
        integerQueue.insert(2);
        assertEquals(2, integerQueue.size());
    }

    @Test
    void testForEach() {
        integerQueue.insert(1);
        integerQueue.insert(2);

        int[] sum = {0};
        integerQueue.forEach(value -> {
            sum[0] += value;
            return null;
        });

        assertEquals(3, sum[0]);
    }

    @Test
    void testPeek() {
        integerQueue.insert(1);
        integerQueue.insert(2);
        assertEquals(1, integerQueue.peek());
    }

    @Test
    void testExtract() {
        integerQueue.insert(1);
        integerQueue.insert(2);
        assertEquals(1, integerQueue.extract());
        assertEquals(1, integerQueue.size());
    }

    @Test
    void testInsert() {
        assertTrue(integerQueue.insert(1));
        assertTrue(integerQueue.insert(2));
        assertEquals(2, integerQueue.size());
    }
    
}
