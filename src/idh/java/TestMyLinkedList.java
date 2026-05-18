package idh.java;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestMyLinkedList {

	MyLinkedList<String> list = new MyLinkedList<>();
	
	public void fillList() {
		// Better safe than sorry. That's why we're starting with an empty list.
		list.clear();
		// Elements
		list.addlast("eins");
		list.addlast("zwei");
		list.addlast("drei");
		list.addlast("vier");
		list.addlast("fünf");
		list.addlast("sechs");
	}
	
	public void printList() {
		for(int i=0;i<list.size();i++)
		{
			System.out.println("ListElement "+i+" = "+list.get(i));
		}
	}
		
	@Test
	// size() - Returns the number of elements in the list
	public void testSize() {
		fillList();
		assertTrue( list.size() == 6 );
		System.out.println("Test size()");
		System.out.println("Size = "+list.size());
		printList();
	}

	@Test
	//  get(int) - Returns the element at the specified position
	public void testGet() {
		fillList();
		assertTrue( list.get(1) == "zwei" );
		assertEquals("eins", list.get(0));
	}
	
	@Test
	// addLast() - Adds an element to the end of the list
	public void testAddLast() {		
		fillList();
		list.addlast("sieben");
		System.out.println("Test addLast()");
		System.out.println("Size new = "+list.size());
		assertTrue( list.size() == 7 );
		assertEquals("sieben", list.get(6));
		printList();
	}

	@Test
	// clear() - Deletes the list
	public void testClear() 
	{
		fillList();
		list.clear();
		assertTrue( list.isEmpty() );
	}
	
	@Test
	// contains() - Returns true, if the list contains the element
	public void testContains() {
		fillList();
		assertTrue(  list.contains("eins") );
	}
	
	@Test
	// remove() - Deletes the element at the index position from the list
	public void testRemoveInt() {
		fillList();
		assertTrue( list.remove(0) == "eins" );
		System.out.println("Test remove(Int)");
		printList();
	}
	
	@Test
	// set() - Replace the element at the index position in the list
	public void testSet() {
		fillList();
		String replace = list.set(1, "aaaa");
		assertTrue( replace ==  "aaaa" );
		System.out.println("Test set()");
		printList();
	}
	
	@Test
	// remove() - Returns true, if the element has been removed from the list
	public void testRemoveObj() {
		fillList();
		assertTrue( list.remove("zwei") );
		assertTrue( list.remove("eins") );
		System.out.println("Test remove(Object)");
		printList();
	}
	
	
	@Test
	// add() - Inserts the element into the list at the specified index position
	public void testAdd() {		
		fillList();
		list.add(0,"acht");
		list.add(3,"sieben");
		System.out.println("Test add()");
		System.out.println("Size new = "+list.size());
		assertTrue( list.size() == 8 );
		assertEquals("acht", list.get(0));
		assertEquals("sieben", list.get(3));
		printList();
	}

}