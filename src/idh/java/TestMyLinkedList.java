package idh.java;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class TestMyLinkedList extends MyLinkedList{

	private MyLinkedList<String> list;
	
	@BeforeEach
	void setUp() {
		list = new MyLinkedList<>();
	}
	
	
	@Test
	void testSizeWithElements() {
		list.add(0,"A");
		list.add(1, "B");
		list.add(2, "C");
		
		assertEquals(3, list.size());
	}
	
	@Test
	void testGet() {
		list.add(0, "A");
		list.add(1, "B");
		
		assertEquals("A", list.get(0));
		assertEquals("B", list.get(1));
	}
	@Test
	void testSizeEmpty() {
		MyLinkedList<String> list = new MyLinkedList<>();
		assertTrue(list.isEmpty());
	}
	
	@Test
	void testAdd() {
	list.add (0,"A");
	list.add(1, "B");
	
	list.clear();
	
	assertTrue(list.isEmpty());
	assertEquals(0, list.size());
	
 }
}
