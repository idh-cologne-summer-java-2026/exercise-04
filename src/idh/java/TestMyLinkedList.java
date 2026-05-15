package idh.java;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestMyLinkedList {

	@Test
	public void testSize() {
		MyLinkedList<String> list = new MyLinkedList<>();
			assertEquals(0, list.size()); 
			list.add(0, "H");
			list.add(1, "E");
			list.add(2, "Y");
			assertEquals(3, list.size()); 
			assertNotEquals(4, list.size());
	}
	@Test
	public void testGet() {
		MyLinkedList<String> list = new MyLinkedList<>(); 
		list.add(0, "H");
		list.add(1, "E");
		list.add(2, "Y");
		assertEquals("H", list.get(0));
        assertEquals("E", list.get(1));
        assertEquals("Y", list.get(2));
	}

	@Test
	public void testAdd() {
		MyLinkedList<String> list = new MyLinkedList<>();
		list.add(0, "H");
		list.add(1, "Y");
		list.add(1, "E");
		assertEquals("H", list.get(0)); 
		assertEquals("E", list.get(1)); 
		assertEquals("Y", list.get(2)); 

	}
	
	@Test
	public void testClear() {
		MyLinkedList<String> list = new MyLinkedList<>();
		list.add(0, "A");
	    list.add(1, "B");

	    assertEquals(2, list.size());

	    list.clear();

	    assertEquals(0, list.size());
	    assertTrue(list.isEmpty());
	}
}
