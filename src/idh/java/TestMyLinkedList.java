package idh.java;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestMyLinkedList {
	
	@Test
	public void testSize() {
		MyLinkedList<String> listObject = new MyLinkedList<>();
		
		assertEquals(0, listObject.size());
	}
	
	@Test
	public void testGet() {
		MyLinkedList<String> listObject = new MyLinkedList<>();
		listObject.add(0, "Hallo");
		
		assertEquals("Hallo", listObject.get(0));
	}
	
	@Test
	public void testAdd() {
		MyLinkedList<String> listObject = new MyLinkedList<>();
		listObject.add(0, "Hallo");
		
		assertEquals(1, listObject.size());
		assertEquals("Hallo", listObject.get(0));
	}
	
	@Test
	public void testClear() {
		MyLinkedList<String> listObject = new MyLinkedList<>();
		listObject.add(0,  "Hallo");
		listObject.clear();
		
		assertEquals(0, listObject.size());
		assertTrue(listObject.isEmpty());
	}
}
