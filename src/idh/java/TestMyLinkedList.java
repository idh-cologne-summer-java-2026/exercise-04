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

	@Test
	void testSize() { 
		// Check 
		assertEquals(0, list.size(), "List should be empty at the beginning");
		
		// Check nach dem einfuegen der Elemente
		list.add(0, "Apple");
		list.add(1, "Banana");
		assertEquals(2, list.size(), "Size should update correctly");	
	}
	
	@Test
	void testGet() {
		list.add(0, "Item A");
		list.add(1, "Item B");
		
		// Check 
		assertEquals("Item A", list.get(0));
		assertEquals("Item B", list.get(1));
	}
	
	@Test
	void testAdd() {
		assertTrue(list.isEmpty());
		
		
		list.add(0, "Single Element");
		assertFalse(list.isEmpty());
		assertEquals(1, list.size());
		assertEquals("Single Element", list.get(0));
	}
	
	@Test
	void testClear() {
		list.add(0, "Target 1");
		list.add(1, "Target 2");
		

		list.clear();
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
	}
}
