package idh.java;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*; 

public class TestMyLinkedList {
	@Test
	public void testSize() {
		MyLinkedList<String> list = new MyLinkedList<>(); 
		assertEquals(0,list.size()); 
		list.add(0,"A");
		list.add(1, "B");
		assertEquals(2,list.size()); 
		assertNotEquals(5,list.size()); 
		System.out.println("The size is"+list.size()); 
	}
	@Test
	public void testGet() {
		MyLinkedList<String> list = new MyLinkedList<>(); 
		list.add(0, "M"); 
		list.add(1, "J");
		list.add(2, "K");
		list.get(2); 
		assertEquals("K",list.get(2)); 
		assertNotEquals("N",list.get(2)); 
	}
	@Test 
	public void testAdd() {
		MyLinkedList<String> list = new MyLinkedList<>(); 
		list.add(0, "S" );
		assertEquals("S", list.get(0)); 
	}
	@Test
	public void testClear() {
		MyLinkedList<String> list = new MyLinkedList<>();
		list.add(0, "S");
		list.add(1,  "K");
		list.add(2, "R");
		assertEquals(3, list.size()); 
		list.clear();
		assertEquals(0, list.size()); 
	}

}
