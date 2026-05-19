package idh.java;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

public class TestMyLinkedList {

	@Test
	public void testSize() {
		MyLinkedList<String> list = MyLinkedList<>();
		 // ???????
		int result = list.size();
		
		assertEquals(0, result);
	}
	
	@Test
	public void testGet() {

	    MyLinkedList<String> list = new MyLinkedList<>();

	    list.get("A");
	    list.get("B");
	    list.get("C");

	    String result = list.get(0);

	    assertEquals("A", result);
	}

	  
	
	
	@Test
	public void testAdd() {

	    MyLinkedList<String> list = new MyLinkedList<>();

	    list.add(0, "A");

	    assertEquals(1, list.size());
	    assertEquals("A", list.get(0));
	}
	
	@Test
	public void testClear() {

	    MyLinkedList<String> list = new MyLinkedList<>();

	    list.add(0, "A");
	    list.add(1, "B");

	    list.clear();

	    assertEquals(0, list.size());
	    assertTrue(list.isEmpty());
	}
	

}
