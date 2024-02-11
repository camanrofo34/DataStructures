/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.model.array;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.model.LinkedList.singly.LinkedList;
import org.model.util.iterator.Iterator;

/**
 *
 * @author PC 4060TI
 */
public class ArrayTest {

    private Array<String> array;

    @BeforeEach
    void setUp() {
        array = new Array(3);
    }

    @Test
    void testAdd() {
        assertTrue(array.add("Element1"));
        assertEquals("Element1", array.get(0));
    }

    @Test
    void testAddAtIndexWithArray() {
        array.add("Element1");
        array.add("Element2");
        assertTrue(array.add(1, new String[]{"NewElement1", "NewElement2"}));
        assertEquals("NewElement1", array.get(1));
        assertEquals("NewElement2", array.get(2));
    }
    
        @Test
    void testAddAtIndexWithArrayMoreSpacesThan() {
        array.add("Element1");
        array.add("Element2");
        assertFalse(array.add(1, new String[]{"NewElement1", "NewElement2", "NewElement3"}));
        assertEquals("Element1", array.get(0));
        assertEquals("NewElement1", array.get(1));
        assertEquals("NewElement2", array.get(2));
    }

    @Test
    void testAddAtIndexWithCollection() {
        array.add("Element1");
        array.add("Element2");
        LinkedList<String> collection = new LinkedList<>();
        collection.add("NewElement1");
        collection.add("NewElement2");
        assertTrue(array.add(1, collection));
        assertEquals("NewElement1", array.get(1));
        assertEquals("NewElement2", array.get(2));
    }
    
    @Test
    void testAddAtIndexWithCollectionMoreSpacesThan() {
        array.add("Element1");
        array.add("Element2");
        LinkedList<String> collection = new LinkedList<>();
        collection.add("NewElement1");
        collection.add("NewElement2");
        collection.add("NewElement3");
        assertFalse(array.add(1, collection));
        assertEquals("Element1", array.get(0));
        assertEquals("NewElement1", array.get(1));
        assertEquals("NewElement2", array.get(2));
    }

    @Test
    void testDefragment() {
        array.add("Element1");
        array.add("Element2");
        array.add("Element3");
        array.remove(1);
        array.remove(0);
        array.defragment();
        assertEquals("Element3", array.get(0));
    }

    @Test
    void testGet() {
        array.add("Element1");
        assertEquals("Element1", array.get(0));
    }

    @Test
    void testIndexOf() {
        array.add("Element1");
        array.add("Element2");
        array.add("Element1");
        assertEquals(0, array.indexOf("Element1"));
        assertEquals(1, array.indexOf("Element2"));
        assertEquals(-1, array.indexOf("NonexistentElement"));
    }

    @Test
    void testLastIndexOf() {
        array.add("Element1");
        array.add("Element2");
        array.add("Element1");
        assertEquals(2, array.lastIndexOf("Element1"));
        assertEquals(1, array.lastIndexOf("Element2"));
        assertEquals(-1, array.lastIndexOf("NonexistentElement"));
    }

    @Test
    void testRemoveAtIndex() {
        array.add("Element1");
        array.add("Element2");
        assertTrue(array.remove(1));
        assertEquals("Element1", array.get(0));
        assertEquals(null, array.get(1));
    }

    @Test
    void testRemoveByFilter() {
        array.add("Apple");
        array.add("Banana");
        array.add("Orange");
        assertTrue(array.remove(e -> e.startsWith("B")));
        assertEquals("Apple", array.get(0));
        assertEquals(null, array.get(1));
        assertEquals("Orange", array.get(2));
    }

    @Test
    void testRemoveRange() {
        array.add("Element1");
        array.add("Element2");
        array.add("Element3");
        assertTrue(array.remove(1, 2));
        assertEquals("Element1", array.get(0));
        assertEquals("Element3", array.get(2));
    }

    @Test
    void testDimension() {
        array.add("Element1");
        array.add("Element2");
        assertTrue(array.dimension(1));
        assertEquals("Element1", array.get(0));
        assertEquals(null, array.get(1));
    }

    @Test
    void testSet() {
        array.add("Element1");
        assertTrue(array.set(0, "NewElement"));
        assertEquals("NewElement", array.get(0));
    }

    @Test
    void testClear() {
        array.add("Element1");
        array.add("Element2");
        array.add("Element3");
        assertTrue(array.clear());
        assertEquals(null, array.get(0));
        assertEquals(null, array.get(1));
        assertEquals(null, array.get(2));
    }

    @Test
    void testContains() {
        array.add("Element1");
        array.add("Element2");
        array.add("Element3");
        assertTrue(array.contains("Element1"));
        assertTrue(array.contains("Element2"));
        assertTrue(array.contains("Element3"));
    }

    @Test
    void testContainsArray() {
        array.add("Element1");
        array.add("Element2");
        array.add("Element3");
        String[] expected = {"Element1", "Element2"};
        assertTrue(array.contains(expected));
    }

    @Test
    void testContainsCollection() {
        array.add("Element1");
        array.add("Element2");
        array.add("Element3");
        LinkedList<String> expected = new LinkedList<>();
        expected.add("Element1");
        expected.add("Element2");
        assertTrue(array.contains(expected));
    }

    @Test
    void testIsClear() {
        array.add("Element1");
        array.add("Element2");
        array.add("Element3");
        assertTrue(array.clear());
        assertTrue(array.isEmpty());
    }

    @Test
    void testReverse() {
        array.add("Element1");
        array.add("Element2");
        array.add("Element3");
        String[] expected = {"Element3", "Element2", "Element1"};
        assertTrue(array.reverse());
        int i = 0;
        for (Iterator<String> it = array.iterator(); it.hasNext();) {
            assertEquals(expected[i++], it.next());
        }
    }

    @Test
    void testSize() {
        assertEquals(3, array.size());
    }
}
