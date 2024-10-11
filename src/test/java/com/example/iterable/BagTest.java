package com.example.iterable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;

import static org.junit.jupiter.api.Assertions.*;

public class BagTest {

    private Bag<String> bag;

    @BeforeEach
    public void setUp() {
        bag = new Bag<>();
    }

    @Test
    public void testAddAndSize() {
        bag.add("Apple");
        bag.add("Orange");
        bag.add("Banana");
        bag.add("Tangerine");
        bag.add("Peach");
        bag.add("Grape");

        assertEquals(6, bag.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(bag.isEmpty());
        bag.add("Apple");
        assertFalse(bag.isEmpty());
    }

    @Test
    public void testIterator() {
        bag.add("Apple");
        bag.add("Orange");
        bag.add("Banana");
        bag.add("Tangerine");
        bag.add("Peach");
        bag.add("Grape");

        Iterator<String> iter = bag.iterator();
        assertTrue(iter.hasNext());
        assertEquals("Apple", iter.next());
        assertEquals("Orange", iter.next());
        assertEquals("Banana", iter.next());
        assertEquals("Tangerine", iter.next());
        assertEquals("Peach", iter.next());
        assertEquals("Grape", iter.next());
        assertFalse(iter.hasNext());
    }

    @Test
    public void testIntegerIterator() {
      Bag<Integer> intBag = new Bag<>();
      intBag.add(1);
      intBag.add(2);
      intBag.add(3);
      intBag.add(4);
      intBag.add(5);

      Iterator<Integer> iter = intBag.iterator();
      assertTrue(iter.hasNext());
      assertEquals(1, iter.next());
      assertEquals(2, iter.next());
      assertEquals(3, iter.next());
      assertEquals(4, iter.next());
      assertEquals(5, iter.next());
      assertFalse(iter.hasNext());
    }

    @Test
    public void testAddMultipleItems() {
        for (int i = 0; i < 25; i++) {
            bag.add("Fruit" + i);
        }
        assertEquals(25, bag.size());
    }

    @Test
    public void testForEach() {
      // write a test that uses the forEach method to print out the contents of the bag
      bag.add("Apple");
      bag.add("Orange");
      bag.add("Banana");
      bag.add("Tangerine");
      bag.add("Peach");
      bag.add("Grape");

      List<String> fruits = new ArrayList<>();
      bag.forEach(fruits::add);
      assertEquals(6, fruits.size());
      assertEquals("Apple", fruits.get(0));
      assertEquals("Orange", fruits.get(1));
      assertEquals("Banana", fruits.get(2));
      assertEquals("Tangerine", fruits.get(3));
      assertEquals("Peach", fruits.get(4));
      assertEquals("Grape", fruits.get(5));
    }

    @Test
    public void testSpliterator() {
      // write a test that uses the spliterator method to split the bag into two bags
      // and compare the sizes of the two bags to the original bag
      bag.add("Apple");
      bag.add("Orange");
      bag.add("Banana");
      bag.add("Tangerine");
      bag.add("Peach");
      bag.add("Grape");

      Spliterator<String> split = bag.spliterator();
      Bag<String> bag1 = new Bag<>();
      Bag<String> bag2 = new Bag<>();
      split.trySplit().forEachRemaining(bag1::add);
      split.forEachRemaining(bag2::add);

      assertEquals(3, bag1.size());
      assertEquals(3, bag2.size());
      assertEquals(6, bag.size());

    }

}
