/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.model.priorityQueue.list;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.model.util.iterator.Iterator;

/**
 *
 * @author admin
 */
public class PriorityQueueTest {

    private PriorityQueue<Integer> integerPriorityQueue;

    @BeforeEach
    void setUp() {
        integerPriorityQueue = new PriorityQueue<>(3);
    }

    @Test
    void testClear() {
        integerPriorityQueue.insert(1);
        integerPriorityQueue.insert(2);
        assertTrue(integerPriorityQueue.clear());
        assertTrue(integerPriorityQueue.isEmpty());
    }

    @Test
    void testContainsElement() {
        integerPriorityQueue.insert(1);
        assertTrue(integerPriorityQueue.contains(1));
        assertFalse(integerPriorityQueue.contains(2));
    }

    @Test
    void testContainsArray() {
        integerPriorityQueue.insert(1);
        integerPriorityQueue.insert(2);
        Integer[] testArray = {1, 2};
        assertTrue(integerPriorityQueue.contains(testArray));
        Integer[] testArray2 = {2, 3};
        assertFalse(integerPriorityQueue.contains(testArray2));
    }


    @Test
    void testIsEmpty() {
        assertTrue(integerPriorityQueue.isEmpty());
        integerPriorityQueue.insert(1);
        assertFalse(integerPriorityQueue.isEmpty());
    }

    @Test
    void testReverse() {
        integerPriorityQueue.insert(1);
        integerPriorityQueue.insert(2);
        integerPriorityQueue.reverse();

        Iterator<Integer> iterator = integerPriorityQueue.iterator();
        assertEquals(2, iterator.next());
        assertEquals(1, iterator.next());
    }

    @Test
    void testSize() {
        assertEquals(0, integerPriorityQueue.size());
        integerPriorityQueue.insert(1);
        integerPriorityQueue.insert(2);
        assertEquals(2, integerPriorityQueue.size());
    }

    @Test
    void testForEach() {
        integerPriorityQueue.insert(1);
        integerPriorityQueue.insert(2);

        int[] sum = {0};
        integerPriorityQueue.forEach(value -> {
            sum[0] += value;
            return null;
        });

        assertEquals(3, sum[0]);
    }

    @Test
    void testInsert() {
        assertTrue(integerPriorityQueue.insert(1));
        assertTrue(integerPriorityQueue.insert(2));
        assertEquals(2, integerPriorityQueue.size());
    }

    @Test
    void testInsertAtIndex() {
        assertTrue(integerPriorityQueue.insert(0, 1));
        assertTrue(integerPriorityQueue.insert(2, 2));
        assertEquals(2, integerPriorityQueue.size());
    }

    @Test
    void testPeek() {
        integerPriorityQueue.insert(1);
        integerPriorityQueue.insert(2);
        assertEquals(1, integerPriorityQueue.peek());
    }

    @Test
    void testExtract() {
        integerPriorityQueue.insert(1);
        integerPriorityQueue.insert(2);
        assertEquals(1, integerPriorityQueue.extract());
        assertEquals(1, integerPriorityQueue.size());
    }

    @Test
    void testExtractEmptyQueue() {
        assertNull(integerPriorityQueue.extract());
    }

    @Test
    void testExtractFromEmptyPriority() {
        PriorityQueue<String> stringPriorityQueue = new PriorityQueue<>(2);
        assertNull(stringPriorityQueue.extract());
    }
    
}
