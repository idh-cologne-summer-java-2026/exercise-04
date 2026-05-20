package idh.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;



public class TestMyLinkedList {

	@Test
	void testAdd() {
		MyLinkedList<Integer> ill = new MyLinkedList<Integer>();
		ill.add(0, 27);
		ill.add(1, 9);
		ill.add(2, 11);
		assertEquals(Integer.valueOf(27), ill.get(0));
		assertEquals(Integer.valueOf(9), ill.get(1));
		assertEquals(Integer.valueOf(11),  ill.get(2));
	}
	
	@Test
	public void testSize() {
		MyLinkedList<Integer> ill = new MyLinkedList<Integer>();
		ill.add(0, 27);
		ill.add(1, 9);
		ill.add(2, 11);
		assertEquals(Integer.valueOf(3), ill.size());
	}
	
	@Test
	public void testClear() {
		MyLinkedList<Integer> ill = new MyLinkedList<Integer>();
		ill.add(0, 27);
		ill.add(1, 9);
		ill.add(2, 11);
		ill.clear();
		try
		assertTrue(ill.get(0) ==  null);
	}
}


	
	

