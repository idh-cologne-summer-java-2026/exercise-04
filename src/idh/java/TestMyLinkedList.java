package idh.java;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class TestMyLinkedList {
	
	@Test

	public void TestMyLinkedListSize() {
		
		MyLinkedList<String> List = new MyLinkedList<String>();
		List.add("one");
		List.add("two");
		List.add("three");
		List.add("four");
		List.add("five");
	
		System.out.println(List.get(0));
		System.out.println(List.get(1));
		System.out.println(List.get(2));
		System.out.println(List.get(3));
		System.out.println(List.get(4));
		assertEquals(5,List.size());
		
		
	}
	
	@Test
	public void TestMyLinkedListGet() {
		
		MyLinkedList<String> List = new MyLinkedList<String>();
		List.add("one");
		List.add("two");
		List.add("three");
		List.add("four");
		List.add("five");
		
		assertEquals("one",List.get(0));
		assertEquals("two",List.get(1));
		assertEquals("three",List.get(2));
		assertEquals("four",List.get(3));
		assertEquals("five",List.get(4));
		
	}
	@Test
	public void TestMyLinkedListAdd() {
		
		MyLinkedList<String> List = new MyLinkedList<String>();
		assertEquals(0,List.size());
		List.add("one");
		assertEquals(1,List.size());
		
	}
	
	@Test
	public void TestMyLinkedListClear() {
		
		MyLinkedList<String> List = new MyLinkedList<String>();
		List.add("one");
		List.add("two");
		List.add("three");
		List.add("four");
		List.add("five");
		assertEquals(5,List.size());
		
		List.clear();
		assertEquals(0,List.size());
	}
	
	@Test
	public void TestContains() {
		
		MyLinkedList<String> List = new MyLinkedList<String>();
		assertFalse(List.contains("one"));
		List.add("one");
		List.add("two");
		List.add("three");
		assertTrue(List.contains("one"));
		assertTrue(List.contains("two"));
		assertTrue(List.contains("three"));
		assertFalse(List.contains("four"));
		
	}
	

	
}
	
