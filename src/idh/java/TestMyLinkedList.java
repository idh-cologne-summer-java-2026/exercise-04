package idh.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestMyLinkedList {

	// Unsere Liste, die wir testen wollen (hier für Texte/Strings)
	MyLinkedList<String> list;

	// @BeforeEach wird automatisch VOR JEDEM @Test ausgeführt.
	// Das garantiert uns eine frische, leere Liste für jeden Testfall.
	@BeforeEach
	void setUp() {
		list = new MyLinkedList<>();
	}

	@Test
	void testAddAndGet() {
		// Elemente am Ende der Liste anhängen
		list.add("Apfel");
		list.add("Banane");
		
		// Prüfen, ob die Elemente an den richtigen Index-Positionen liegen
		assertEquals("Apfel", list.get(0), "Index 0 muss 'Apfel' sein.");
		assertEquals("Banane", list.get(1), "Index 1 muss 'Banane' sein.");
	}

	@Test
	void testSize() {
		// Eine neue Liste muss die Größe 0 haben
		assertEquals(0, list.size());
		
		// Größe muss nach jedem Hinzufügen um 1 wachsen
		list.add("Apfel");
		assertEquals(1, list.size());
		
		list.add("Banane");
		assertEquals(2, list.size());
	}

	@Test
	void testClear() {
		// Liste befüllen
		list.add("Apfel");
		list.add("Banane");
		
		// Liste komplett leeren
		list.clear();
		
		// Prüfen, ob die Liste jetzt wirklich leer ist (Größe 0)
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
	}
}