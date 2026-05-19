package idh.java;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestMyLinkedList {
    private MyLinkedList<String> list;

    @Before
    public void setUp() {
        list = new MyLinkedList<>();
    }

    @Test
    public void testSizeEmpty() {
        assertEquals(0, list.size());
    }

    @Test
    public void testAddAndSize() {
        list.add(0, "A");
        assertEquals(1, list.size());
        list.add(1, "B");
        assertEquals(2, list.size());
    }

    @Test
    public void testGet() {
        list.add(0, "A");
        list.add(1, "B");
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetOutOfBounds() {
        list.get(0);
    }

    @Test
    public void testClear() {
        list.add(0, "A");
        list.add(1, "B");
        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testAddAtBeginning() {
        list.add(0, "A");
        list.add(0, "B");
        assertEquals("B", list.get(0));
        assertEquals("A", list.get(1));
    }

    @Test
    public void testAddAtEnd() {
        list.add(0, "A");
        list.add(1, "B");
        list.add(2, "C");
        assertEquals("C", list.get(2));
    }
}
