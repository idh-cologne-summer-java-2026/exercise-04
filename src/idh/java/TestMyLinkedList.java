package idh.java;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

//import idh.java.MyLinkedList.ListElement;


public class TestMyLinkedList {

	MyLinkedList<String> list = new MyLinkedList<>();
	
	public void fillList() {
		// Sicher ist sicher. Darum wird mit leerer Liste angefangen
		list.clear();
		
		// Elemente
		list.addlast("eins");
		list.addlast("zwei");
		list.addlast("drei");
		list.addlast("vier");
		list.addlast("fünf");
		list.addlast("sechs");
	}
		
	@Test
	// size() - Returns the number of elements in the list
	public void testSize() {
		fillList();
		System.out.println("Size = "+list.size());
		assertTrue( list.size() == 6 );
	}

	@Test
	//  get(int) - Returns the element at the specified position
	public void testGet() {
		fillList();
		//System.out.println("First = "+list.get(1));
		assertTrue( list.get(1) == "eins" );
	}
	
	@Test
	// add() - Adds an element to the end of the list
	public void testAdd() {		
		fillList();
		list.addlast("sieben");
		System.out.println("Size = "+list.size());
		assertTrue( list.size() == 7 );
	}

	@Test
	// clear() - Deletes the list
	public void testClear() 
	{
		list.clear();
		assertTrue( list.isEmpty() );
	}
}