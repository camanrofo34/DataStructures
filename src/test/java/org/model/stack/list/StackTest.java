/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.model.stack.list;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.model.util.iterator.Iterator;

/**
 *
 * @author PC 4060TI
 */
public class StackTest {
    
    private Stack<Integer> integerStack;
    private Iterator<Integer> iterator;

    @BeforeEach
    void setUp() {
        integerStack = new Stack<>();
    }

    @Test
    void testClear() {
        integerStack.push(1);
        integerStack.push(2);
        iterator = integerStack.iterator();
        Integer[] testArray = {1, 2};
        int i=0;
        while(iterator.hasNext()){
            assertEquals(testArray[i++], iterator.next());
        }
        assertTrue(integerStack.clear());
        assertTrue(integerStack.isEmpty());
    }

    @Test
    void testContainsElement() {
        integerStack.push(1);
        assertTrue(integerStack.contains(1));
        assertFalse(integerStack.contains(2));
    }

    @Test
    void testContainsArray() {
        integerStack.push(1);
        integerStack.push(2);
        Integer[] testArray = {1, 2};
        assertTrue(integerStack.contains(testArray));
        Integer[] testArray2 = {2, 3};
        assertFalse(integerStack.contains(testArray2));
    }


    @Test
    void testIsEmpty() {
        assertTrue(integerStack.isEmpty());
        integerStack.push(1);
        assertFalse(integerStack.isEmpty());
    }

    @Test
    void testReverse() {
        integerStack.push(1);
        integerStack.push(2);
        assertTrue(integerStack.reverse());
        assertEquals(1, integerStack.peek());
    }

    @Test
    void testSize() {
        assertEquals(0, integerStack.size());
        integerStack.push(1);
        integerStack.push(2);
        assertEquals(2, integerStack.size());
    }

    @Test
    void testForEach() {
        integerStack.push(1);
        integerStack.push(2);

        int[] sum = {0};
        integerStack.forEach(value -> {
            sum[0] += value;
            return null;
        });

        assertEquals(3, sum[0]);
    }


    @Test
    void testPeek() {
        integerStack.push(1);
        integerStack.push(2);
        assertEquals(2, integerStack.peek());
    }

    @Test
    void testPop() {
        integerStack.push(1);
        integerStack.push(2);
        assertEquals(2, integerStack.pop());
        assertEquals(1, integerStack.size());
    }

    @Test
    void testPush() {
        assertTrue(integerStack.push(1));
        assertTrue(integerStack.push(2));
        assertEquals(2, integerStack.size());
    }
    
}
