/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.model.queue.array;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.model.util.iterator.Iterator;

/**
 *
 * @author admin
 */
public class QueueTest {
    
private Queue<Integer> integerQueue;

    @BeforeEach
    void setUp() {
        integerQueue = new Queue<>(5);
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
    
    @Test
    void testPeek1() {
        integerQueue.insert(1);
        integerQueue.insert(2);
        integerQueue.insert(3);
        assertEquals(1, integerQueue.peek());
    }

    @Test
    public void testExtract1() {
        integerQueue.insert(1);
        integerQueue.insert(2);
        assertEquals(1, integerQueue.extract());
        assertEquals(2, integerQueue.peek());
    }

    @Test
    public void testInsert1() {
        assertTrue(integerQueue.insert(1));
        assertTrue(integerQueue.insert(2));
        assertEquals(1, integerQueue.peek());
    }
    
    @Test
    public void testInsertRestoDeVainas(){
        integerQueue.insert(1);
        integerQueue.insert(2);
        integerQueue.insert(3);
        integerQueue.insert(4);
        integerQueue.insert(5);
        integerQueue.extract();
        integerQueue.insert(6);
        Iterator<Integer> iterator = integerQueue.iterator();
        int[] sum = {2,3,4,5,6};
        int i=0;
        while(iterator.hasNext()){
            assertEquals(sum[i++], iterator.next());
        }
    }

    @Test
    public void testClear1() {
        integerQueue.insert(1);
        integerQueue.insert(2);
        assertTrue(integerQueue.clear());
        assertTrue(integerQueue.isEmpty());
    }

    @Test
    public void testContains() {
        integerQueue.insert(1);
        integerQueue.insert(2);
        assertTrue(integerQueue.contains(1));
        assertFalse(integerQueue.contains(3));
    }

    @Test
    public void testIsEmpty1() {
        assertTrue(integerQueue.isEmpty());
        integerQueue.insert(1);
        assertFalse(integerQueue.isEmpty());
    }
    
    
}
