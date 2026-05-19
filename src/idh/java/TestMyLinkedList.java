package idh.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestMyLinkedList {

    @Test
    void testSize() {
        MyLinkedList<String> list = new MyLinkedList<>();

        assertEquals(0, list.size());
    }

    @Test
    void testAdd() {
        MyLinkedList<String> list = new MyLinkedList<>();

        list.add(0, "A");
        list.add(1, "B");
        list.add(2, "C");
    }

    @Test
    void testGet() {
        MyLinkedList<String> list = new MyLinkedList<>();

        list.add(0, "A");
        list.add(1, "B");
        list.add(2, "C");
        
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
    }

    
    @Test
    void testClear() {
        MyLinkedList<String> list = new MyLinkedList<>();


        list.clear();

        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }
}