package idh.java;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TestMyLinkedList {
    private MyLinkedList<String> list;

    @BeforeEach
    void setUp() {
        list = new MyLinkedList<>();
    }

    //size()
    @Test
    void testSizeEmptyList() {
        assertEquals(0, list.size());
    }

    @Test
    void testSizeAfterAddingElements() {
        list.add(0, "A");
        list.add(1, "B");
        list.add(2, "C");

        assertEquals(3, list.size());
    }


    //get(int)
    @Test
    void testGetFirstElement() {
        list.add(0, "A");
        list.add(1, "B");

        assertEquals("A", list.get(0));
    }

    @Test
    void testGetMiddleElement() {
        list.add(0, "A");
        list.add(1, "B");
        list.add(2, "C");

        assertEquals("B", list.get(1));
    }

    @Test
    void testGetLastElement() {
        list.add(0, "A");
        list.add(1, "B");
        list.add(2, "C");

        assertEquals("C", list.get(2));
    }


    //add(T)
    @Test
    void testAddAtBeginning() {
        list.add(0, "B");
        list.add(0, "A");

        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
    }

    @Test
    void testAddInMiddle() {
        list.add(0, "A");
        list.add(1, "C");

        list.add(1, "B");

        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
    }

    @Test
    void testAddAtEnd() {
        list.add(0, "A");
        list.add(1, "B");

        assertEquals("B", list.get(1));
        assertEquals(2, list.size());
    }

    
    //clear()
    @Test
    void testClearList() {
        list.add(0, "A");
        list.add(1, "B");

        list.clear();

        assertEquals(0, list.size());
    }

    @Test
    void testClearEmptyList() {
        list.clear();

        assertEquals(0, list.size());
    }
}
