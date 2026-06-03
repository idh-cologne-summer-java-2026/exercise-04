package idh.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestMyLinkedLists { 
	private MyLinkedList<Integer> list;

	@Test
	void testSize_Empty() {
	    list = new MyLinkedList<>();
	    assertEquals(0, list.size());
	}

	@Test
	void testSize_Add() {
		list = new MyLinkedList<>();
	    list.add(0, 10);
	    list.add(1, 20);
	    list.add(2, 30);

	    assertEquals(3, list.size());
	}

	@Test
	void testSize_Clear() {
		list = new MyLinkedList<>();
	    list.add(0, 1);
	    list.add(1, 2);

	    list.clear();

	    assertEquals(0, list.size());
	}
			
		
	

}
