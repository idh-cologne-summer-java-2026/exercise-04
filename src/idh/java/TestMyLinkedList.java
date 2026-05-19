package idh.java;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestMyLinkedList {

	private MyLinkedList<String> list;

	@BeforeEach
	void setup() {
		list = new MyLinkedList<>();
	}

	@Test
	void testSizeEmptyList() {
		assertEquals(0, list.size());
	}

	@Test
	void testSizeAfterAddingElements() {
		list.add("A");
		list.add("B");
		list.add("C");

		assertEquals(3, list.size());
	}

	@Test
	void testGetFirstElement() {
		list.add("A");
		list.add("B");

		assertEquals("A", list.get(0));
	}

	@Test
	void testGetSecondElement() {
		list.add("A");
		list.add("B");

		assertEquals("B", list.get(1));
	}

	@Test
	void testGetInvalidIndex() {
		list.add("A");

		assertThrows(IndexOutOfBoundsException.class,
				() -> list.get(5));
	}

	@Test
	void testAddElement() {
		list.add("Test");

		assertEquals(1, list.size());
		assertEquals("Test", list.get(0));
	}

	@Test
	void testAddMultipleElements() {
		list.add("A");
		list.add("B");
		list.add("C");

		assertEquals(3, list.size());
		assertEquals("C", list.get(2));
	}

	@Test
	void testClearList() {
		list.add("A");
		list.add("B");

		list.clear();

		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
	}

}
