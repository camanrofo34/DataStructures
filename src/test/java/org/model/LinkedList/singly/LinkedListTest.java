/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.model.LinkedList.singly;

import java.util.Comparator;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.model.util.iterator.Iterator;
import org.model.util.list.List;

/**
 *
 * @author PC 4060TI
 */
public class LinkedListTest {

    LinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new LinkedList<>();
    }

    @Test
    void testAdd() {
        assertTrue(list.add(23));
        assertTrue(list.add(30));
        assertTrue(list.add(20));
        assertEquals(3, list.size());
        Object[] expected = {23, 30, 20};
        int i = 0;
        for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
            assertEquals(expected[i++], it.next());
        }
    }
   
    @Test
    void testAddArray() {
        Integer[] added = {23, 30, 20};
        assertTrue(list.add(added));
        assertEquals(3, list.size());
        Integer[] expected = {23, 30, 20};
        int i = 0;
        for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
            assertEquals(expected[i++], it.next());
        }
    }

    @Test
    void testAddCollection() {
        LinkedList<Integer> toAdd = new LinkedList<>();
        Integer[] added = {23, 30, 20};
        toAdd.add(added);
        assertTrue(list.add(toAdd));
        assertEquals(3, list.size());
        Integer[] expected = {23, 30, 20};
        int i = 0;
        for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
            assertEquals(expected[i++], it.next());
        }
    }

    @Test
    void testAddFirst() {
        assertTrue(list.addFirst(23));
        assertTrue(list.addFirst(30));
        assertTrue(list.addFirst(20));
        assertEquals(3, list.size());
        Object[] expected = {20, 30, 23};
        int i = 0;
        for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
            assertEquals(expected[i++], it.next());
        }
    }

    @Test
    void testAddFirstArray() {
        Integer[] added = {23, 30, 20};
        assertTrue(list.addFirst(added));
        assertEquals(3, list.size());
        Integer[] expected = {23, 30, 20};
        int i = 0;
        for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
            assertEquals(expected[i++], it.next());
        }
    }

    @Test
    void testAddFirstCollection() {
        LinkedList<Integer> toAdd = new LinkedList<>();
        Integer[] added = {23, 30, 20};
        toAdd.add(added);
        assertTrue(list.addFirst(toAdd));
        assertEquals(3, list.size());
        Integer[] expected = {23, 30, 20};
        int i = 0;
        for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
            assertEquals(expected[i++], it.next());
        }
    }

    @Test
    void testPeek() {
        list.add(23);
        list.add(30);
        list.add(20);
        int expected = 23;
        assertEquals(3, list.size());
        assertEquals(expected, list.peek());
    }

    @Test
    void testPeekLast() {
        list.add(23);
        list.add(30);
        list.add(20);
        int expected = 20;
        assertEquals(3, list.size());
        assertEquals(expected, list.peekLast());
    }

    @Test
    void testPeekArray() {
        list.add(23);
        list.add(30);
        list.add(20);
        Object[] expected = {23, 30};
        assertEquals(3, list.size());
        Object[] receive = list.peekArray(2);
        int i = 0;
        for (Object e : receive) {
            assertEquals(expected[i++], e);
        }
    }

    @Test
    void testPeekLastArray() {
        list.add(23);
        list.add(30);
        list.add(20);
        Object[] expected = {30, 20};
        assertEquals(3, list.size());
        Object[] receive = list.peekLastArray(2);
        int i = 0;
        for (Object e : receive) {
            assertEquals(expected[i++], e);
        }
    }

    @Test
    void testPeekCollection() {
        list.add(23);
        list.add(30);
        list.add(20);
        Object[] expected = {23, 30};
        assertEquals(3, list.size());
        LinkedList<Integer> receive = (LinkedList<Integer>) list.peekCollection(2);
        int i = 0;
        for (Iterator<Integer> it = receive.iterator(); i < 2;) {
            assertEquals(expected[i++], it.next());
        }
    }

    @Test
    void testPeekLastCollection() {
        list.add(23);
        list.add(30);
        list.add(20);
        Object[] expected = {30, 20};
        assertEquals(3, list.size());
        LinkedList<Integer> receive = (LinkedList<Integer>) list.peekLastCollection(2);
        int i = 0;
        for (Iterator<Integer> it = receive.iterator(); i < 2;) {
            assertEquals(expected[i++], it.next());
        }
    }

    @Test
    void testPoll() {
        list.add(23);
        list.add(30);
        list.add(20);
        int expected = 23;
        assertEquals(3, list.size());
        assertEquals(expected, list.poll());
        assertEquals(2, list.size());
        Object[] expectedArray = {30, 20};
        int i = 0;
        for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
            assertEquals(expectedArray[i++], it.next());
        }
    }
    
    @Test
    void testPollUniqueElement() {
        list.add(23);
        int expected = 23;
        assertEquals(1, list.size());
        assertEquals(expected, list.poll());
        assertEquals(0, list.size());
    }
    
        @Test
    void testPollTwoElement() {
        list.add(23);
        list.add(30);
        assertEquals(2, list.size());
        assertEquals(23, list.poll());
        assertEquals(1, list.size());
        assertEquals(30, list.poll());
        assertEquals(0, list.size());
    }

    @Test
    void testPollLast() {
        list.add(23);
        list.add(30);
        list.add(20);
        int expected = 20;
        assertEquals(3, list.size());
        assertEquals(expected, list.pollLast());
        assertEquals(2, list.size());
        Object[] expectedArray = {23, 30};
        int i = 0;
        for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
            assertEquals(expectedArray[i++], it.next());
        }
    }
    
    @Test
    void testPollLastUniqueElement() {
        list.add(23);
        int expected = 23;
        assertEquals(1, list.size());
        assertEquals(expected, list.pollLast());
        assertEquals(0, list.size());
    }

    @Test
    void testPollArray() {
        list.add(23);
        list.add(30);
        list.add(20);
        Object[] expected = {23, 30};
        assertEquals(3, list.size());
        Object[] receive = list.pollArray(2);
        assertEquals(1, list.size());
        int i = 0;
        for (Object e : receive) {
            assertEquals(expected[i++], e);
        }
        for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
            assertEquals(20, it.next());
        }
    }
    

    @Test
    void testPollArrayOneElement() {
        list.add(23);
        Object[] expected = {23, null};
        assertEquals(1, list.size());
        Object[] receive = list.pollArray(2);
        assertEquals(0, list.size());
        int i = 0;
        for (Object e : receive) {
            assertEquals(expected[i++], e);
        }
    }

    @Test
    void testPollLastArray() {
        list.add(23);
        list.add(30);
        list.add(20);
        Object[] expected = {30, 20};
        assertEquals(3, list.size());
        Object[] receive = list.pollLastArray(2);
        assertEquals(1, list.size());
        int i = 0;
        for (Object e : receive) {
            assertEquals(expected[i++], e);
        }
        for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
            assertEquals(23, it.next());
        }
    }
    
    @Test
    void testPollLastArrayUniqueItem() {
        list.add(23);
        assertEquals(1, list.size());
        Object[] receive = list.pollLastArray(2);
        assertEquals(0, list.size());
        int i = 0;
        Object[] expected = {23, null};
        for (Object e : receive) {
            assertEquals(expected[i++], e);
        }
        for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
            assertEquals(23, it.next());
        }
    }

    
    @Test
    void testPollCollection() {
        list.add(23);
        list.add(30);
        list.add(20);
        Object[] expected = {23, 30};
        assertEquals(3, list.size());
        LinkedList<Integer> receive = (LinkedList<Integer>) list.pollCollection(2);
        assertEquals(1, list.size());
        int i = 0;
        for (Iterator<Integer> it = receive.iterator(); it.hasNext();) {
            assertEquals(expected[i++], it.next());
        }
        for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
            assertEquals(20, it.next());
        }
    }
    
    @Test
    void testPollCollectionUniqueElement() {
        list.add(23);
        Object[] expected = {23};
        assertEquals(1, list.size());
        LinkedList<Integer> receive = (LinkedList<Integer>) list.pollCollection(2);
        assertEquals(0, list.size());
        int i = 0;
        for (Iterator<Integer> it = receive.iterator(); it.hasNext();) {
            assertEquals(expected[i++], it.next());
        }
    }

    @Test
    void testPollLastCollection() {
        list.add(23);
        list.add(30);
        list.add(20);
        Object[] expected = {30, 20};
        assertEquals(3, list.size());
        LinkedList<Integer> receive = (LinkedList<Integer>) list.pollLastCollection(2);
        assertEquals(1, list.size());
        int i = 0;
        for (Iterator<Integer> it = receive.iterator(); it.hasNext();) {
            assertEquals(expected[i++], it.next());
        }
        for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
            assertEquals(23, it.next());
        }
    }
    
    @Test
    void testPollLastCollectionUniqueElement() {
        list.add(23);
        Object[] expected = {23};
        assertEquals(1, list.size());
        LinkedList<Integer> receive = (LinkedList<Integer>) list.pollLastCollection(2);
        assertEquals(0, list.size());
        int i = 0;
        for (Iterator<Integer> it = receive.iterator(); it.hasNext();) {
            assertEquals(expected[i++], it.next());
        }
    }

    @Test
    void testRemove() {
        list.add(23);
        list.add(30);
        list.add(20);
        Object[] expected = {23, 20};
        assertEquals(3, list.size());
        assertTrue(list.remove(30));
        assertEquals(2, list.size());
        int i = 0;
        for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
            assertEquals(expected[i++], it.next());
        }
    }
        @Test
    void testRemoveTail() {
        list.add(23);
        list.add(30);
        list.add(20);
        Object[] expected = {23, 30};
        assertEquals(3, list.size());
        assertTrue(list.remove(20));
        assertEquals(2, list.size());
        int i = 0;
        for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
            assertEquals(expected[i++], it.next());
        }
        assertEquals(30, list.peekLast());
    }

    @Test
    void testRemoveArray() {
        list.add(23);
        list.add(30);
        list.add(20);
        Integer[] toErase = {23, 20};
        assertEquals(3, list.size());
        assertTrue(list.remove(toErase));
        assertEquals(1, list.size());
        for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
            assertEquals(30, it.next());
        }
    }

    @Test
    void testRemoveCollection() {
        list.add(23);
        list.add(30);
        list.add(20);
        LinkedList<Integer> toErase = new LinkedList<>();
        toErase.add(23);
        toErase.add(20);
        assertEquals(3, list.size());
        assertTrue(list.remove(toErase));
        assertEquals(1, list.size());
        for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
            assertEquals(30, it.next());
        }
    }

    @Test
    void testRemovePredicate() {
        list.add(23);
        list.add(30);
        list.add(20);
        Predicate<Integer> filter = e -> e.equals(30);
        Integer[] expected = {23, 20};
        assertTrue(list.remove(filter));
        int i = 0;
        for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
            assertEquals(expected[i++], it.next());
        }
    }

    @Test
    void testReplace() {
        list.add(23);
        list.add(30);
        list.add(20);

        assertTrue(list.replace(30, 35, e -> e > 25));
        Integer[] expected = {23, 35, 20};
        int i = 0;
        for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
            assertEquals(expected[i++], it.next());
        }
    }

    @Test
    void testReplaceArray() {
        list.add(23);
        list.add(30);
        list.add(20);

        assertTrue(list.replace(new Integer[]{23, 30}, new Integer[]{25, 35}, e -> e > 22));
        Integer[] expected = {25, 35, 20};
        int i = 0;
        for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
            assertEquals(expected[i++], it.next());
        }
    }

    @Test
    void testReplaceCollection() {
        list.add(23);
        list.add(30);
        list.add(20);
        LinkedList<Integer> replaceList = new LinkedList<>(new Integer[]{23, 30});
        LinkedList<Integer> newList = new LinkedList<>(new Integer[]{25, 35});
        assertTrue(list.replace(replaceList, newList, e -> e > 22));
        Integer[] expected = {25, 35, 20};
        int i = 0;
        for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
            assertEquals(expected[i++], it.next());
        }
    }

    @Test
    void testRetainArray() {
        list.add(23);
        list.add(30);
        list.add(20);

        assertTrue(list.retain(new Integer[]{23, 20}));
        Integer[] expected = {23, 20};
        int i = 0;
        for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
            assertEquals(expected[i++], it.next());
        }
    }

    @Test
    void testRetainCollection() {
        list.add(23);
        list.add(30);
        list.add(20);

        LinkedList<Integer> retainCollection = new LinkedList<>(new Integer[]{23, 30});
        assertTrue(list.retain(retainCollection));
        Integer[] expected = {23, 30};
        int i = 0;
        for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
            assertEquals(expected[i++], it.next());
        }
    }

    @Test
    void testSet() {
        list.add(23);
        list.add(30);
        list.add(20);

        assertTrue(list.set(30, 35));
        Integer[] expected = {23, 35, 20};
        int i = 0;
        for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
            assertEquals(expected[i++], it.next());
        }
    }

    @Test
    void testSort() {
        list.add(23);
        list.add(30);
        list.add(20);
        ToIntFunction<Integer> intToSelf = i -> i;
        assertTrue(list.sort(intToSelf));
        Integer[] expected = {20, 23, 30};
        int i = 0;
        for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
            assertEquals(expected[i++], it.next());
        }
    }

    @Test
    void testSubList() {
        list.add(23);
        list.add(30);
        list.add(20);
        list.add(40);

        LinkedList<Integer> subList = (LinkedList<Integer>) list.subList(30, 40);
        Integer[] expected = {30, 20};
        int i = 0;
        for (Iterator<Integer> it = subList.iterator(); it.hasNext();) {
            assertEquals(expected[i++], it.next());
        }
    }

    @Test
    public void testToArray() {
        list.add(23);
        list.add(30);
        list.add(20);
        Integer[] expected = {23, 30, 20};
        Object[] result = list.toArray();
        int i = 0;
        for (Integer element : expected) {
            assertEquals(element, result[i++]);
        }
    }

    @Test
    public void testClear() {
        list.add(23);
        list.add(30);
        list.add(20);
        assertEquals(3, list.size());
        assertTrue(list.clear());
        assertEquals(0, list.size());
    }

    @Test
    public void testContains() {
        list.add(23);
        list.add(30);
        list.add(20);
        assertTrue(list.contains(30));
        assertTrue(list.contains(20));
        assertTrue(list.contains(23));
    }

    @Test
    public void testContainsArray() {
        list.add(23);
        list.add(30);
        list.add(20);
        Integer[] array = {30, 20};
        Integer[] arrayNotPresent = {10, 40};
        assertTrue(list.contains(array));
        assertFalse(list.contains(arrayNotPresent));

    }

    @Test
    public void testContainsCollection() {
        list.add(23);
        list.add(30);
        list.add(20);
        LinkedList<Integer> present = new LinkedList<>(new Integer[]{23, 30});
        LinkedList<Integer> notPresent = new LinkedList<>(new Integer[]{10, 40});
        assertTrue(list.contains(present));
        assertFalse(list.contains(notPresent));
    }

    @Test
    public void testIsEmpty() {
        list.add(23);
        list.add(30);
        list.add(20);
        assertFalse(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testReverse() {
        list.add(23);
        list.add(30);
        list.add(20);
        Integer[] expected = {20, 30, 23};
        list.reverse();
        int i = 0;
        for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
            assertEquals(expected[i++], it.next());
        }
    }

    @Test
    public void testSize() {
        list.add(23);
        list.add(30);
        list.add(20);
        assertEquals(3, list.size());
        list.clear();
        assertEquals(0, list.size());
    }

}
