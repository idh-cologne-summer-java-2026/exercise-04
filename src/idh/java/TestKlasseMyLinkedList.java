package idh.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestKlasseMyLinkedList {

    @Test
    public void testSizeEmptyList() {
        MyLinkedList<String> list = new MyLinkedList<String>();

        assertEquals(0, list.size());
    }

    @Test
    public void testSizeNachAdd() {
        MyLinkedList<String> list = new MyLinkedList<String>();

        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals(3, list.size());
    }

    @Test
    public void testGetErstesElement() {
        MyLinkedList<String> list = new MyLinkedList<String>();

        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals("A", list.get(0));
    }

    @Test
    public void testGetMittleresElement() {
        MyLinkedList<String> list = new MyLinkedList<String>();

        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals("B", list.get(1));
    }

    @Test
    public void testGetLetztesElement() {
        MyLinkedList<String> list = new MyLinkedList<String>();

        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals("C", list.get(2));
    }

    @Test
    public void testException() {
        MyLinkedList<String> list = new MyLinkedList<String>();

        list.add("A");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(1);
        });
    }

    @Test
    public void testGetMitNegativemIndex() {
        MyLinkedList<String> list = new MyLinkedList<String>();

        list.add("A");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(-1);
        });
    }

   
    @Test
    public void testClear() {
        MyLinkedList<String> list = new MyLinkedList<String>();

        list.add("A");
        list.add("B");
        list.add("C");

        list.clear();

        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    
}