package idh.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestMyLinkedList {
	
	MyLinkedList<String> listObject = new MyLinkedList<>();
	
	
	@BeforeEach
    void setUp() {
        listObject = new MyLinkedList<>();
        int index = 0;
        for (char c = 'A'; c <= 'Z'; c++) {
            listObject.add(index, String.valueOf(c)); 
            index++; // Index läuft mit, um richtige alphabetische Reihenfolge zu ermöglichen  
        }
    }
	
	@Test
	public void testSizeOfList() {
		assertEquals(26, listObject.size());
	}

	@Test
	public void testGetPayloadAtIndex() {
		assertNotEquals("A", listObject.get(1));
		assertEquals("A", listObject.get(0));
		assertEquals("H", listObject.get(7));
		assertEquals("R", listObject.get(17));
		assertEquals("Z", listObject.get(25));
		
	}
	
	@Test
	public void testAddFirstElement() {
		listObject.add(0, "AA");
		assertEquals(27, listObject.size());
		assertEquals("AA", listObject.get(0));
		assertEquals("A", listObject.get(1));
		assertEquals("Z", listObject.get(26));
	}
	@Test
	public void testAddMiddleElement() {
		listObject.add(12, "AA");
		assertEquals(27, listObject.size());
		assertEquals("AA", listObject.get(12));
		assertEquals("M", listObject.get(13));
	}
	@Test
	public void testAddLastElement() {
		listObject.add(26, "AA");
		assertEquals(27, listObject.size());
		assertEquals("AA", listObject.get(26));
		assertEquals("Z", listObject.get(25));
	}
	
	@Test
	public void testClearList() {
		listObject.clear();
		assertEquals(0, listObject.size());
	}
	
	// OutOufBoundsExceptions müssen fehlschlagen, da im getesten Code nicht abgefangen
    @Test
    public void testAddIndexOutOfBoundsException() {
        // Eingabe eines negativen Index
        assertThrows(IndexOutOfBoundsException.class, () -> listObject.add(-1, "Fehlfunktion"), "Index ist negativ");

        // Eingabe eines zu groß gewählten Index
        assertThrows(IndexOutOfBoundsException.class, () -> listObject.add(27, "Fehlfunktion"), "Index größer als Listengröße");
    
    }
}
	

