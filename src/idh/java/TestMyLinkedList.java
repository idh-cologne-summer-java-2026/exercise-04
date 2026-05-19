package idh.java;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestMyLinkedList {
	
	
	private MyLinkedList<String> list;
	
	
	@BeforeEach 
	public void setUp() { 
	list = new MyLinkedList<>(); 
	
	}
	
	@Test 
	void testSize() { 
	 assertEquals(0, list.size()); 
	 assertEquals(1, list.size()); 
	 assertEquals(2, list.size()); 
	 assertEquals(3, list.size());  
	    
	
	}
	
	@Test 
	void testGet() { 
		list.add("Erstens"); 
		list.add("Zweitens"); 
		list.add("Drittens");
		
		assertEquals("Erstens", list.get(0)); 
		assertEquals("Zweitens", list.get(1)); 
		assertEquals("Drittens", list.get(2)); 
			
	}
	
	@Test 
	void testAdd() { 
		// Erste Zahl einsetzen
		list.add(0,"Eins"); // neues Element mit dem Wert "Eins" wird erstellt 
		assertEquals(1,list.size()); 
		// Zweite Zahl einsetzen
		list.add(1,"Zwei"); // Element mit dem Wert "Zwei"
		assertEquals(2,list.size()); 
		// Dritte Zahl einsetzen 
		list.add(2,"Drei"); // Element mit dem Wert "Drei"
		assertEquals(3,list.size()); 
		
		// Mit list.get prüfen, ob die Werte wirklich an der richtigen Stelle stehen
		assertEquals("Eins", list.get(0), "An der Stelle 0 steht 'Eins'.");
		assertEquals("Zwei", list.get(1), "An der Stelle 1 steht 'Zwei'.");
		assertEquals("Drei", list.get(2), "An der Stelle 2 steht 'Drei'.");
		
	}
	
	
	@Test 
	void testClear() {
		// Elemente der Liste hinzufügen
		list.add("Eins"); 
		list.add("Zwei");
		list.add("Drei");
		
		// Löschen 
		list.clear(); 
		
		// Liste sollte nach dem Löschen 0 Elemente beeinhalten 
		assertEquals(0, list.size()); 
		
	  }
	
	}
