package idh.java;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class TestMyLinkedList {
	
	private MyLinkedList<String> list;
	
	@BeforeEach 
	public void createNewList() {
        list = new MyLinkedList<>();
    }

	
	@Test
	public void size() { 
		// größe der List,vor & nach dem hinzufügen von Elementen
		assertEquals(0, list.size());
		
		list.add(0, "Element 1");
		list.add(1, "Element 2");
		assertEquals(2, list.size());	
	}
	
	@Test
	public void get() {
		// int = Position des Elements
		list.add(0,"Element A");
		list.add(1, "Element B");
		assertEquals("Element A", list.get(0));
		assertEquals("Element B", list.get(1));
		
	}
	
	@Test
	public void add() {
		// Länge herausfinden, vor & nach add()
		assertEquals(0, list.size());
		list.add(0, "Element I");
		assertEquals(1,list.size());
	}
	
	@Test
	public void clear() {
		//größe muss = 0 sein
		list.add(0, "zu leerendes Element");
		list.clear();
		assertEquals(0, list.size());
	}
}
