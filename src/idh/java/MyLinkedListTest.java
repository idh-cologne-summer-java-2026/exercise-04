package idh.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyLinkedListTest {

    @Test
    void testAdd() {

        MyLinkedList<String> list = new MyLinkedList<>();

        list.add(0, "Hallo");

        assertEquals("Hallo", list.get(0));
    }

    @Test
    void testClear() {

        MyLinkedList<String> list = new MyLinkedList<>();

        list.add(0, "Test");

        list.clear();

        assertTrue(list.isEmpty());
    }

}