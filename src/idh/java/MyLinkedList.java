package idh.java;

public class MyLinkedList<T> {

	/**
	 * Interne Hilfsklasse: Ein einzelnes "Kettenglied" (Node) der Liste.
	 * Speichert den eigentlichen Wert (payload) und den Zeiger auf das NÄCHSTE Glied (next).
	 */
	private class ListElement {
		T payload;
		ListElement next = null;

		ListElement(T value) {
			this.payload = value;
		}
	}

	// Der Startpunkt unserer Kette. Wenn first null ist, ist die Liste leer.
	ListElement first;

	// Fügt ein Element GANZ AM ENDE der Liste hinzu
	public boolean add(T element) {
		if (first == null) {
			// Liste ist leer -> Neues Element wird direkt der Startpunkt
			first = new ListElement(element);
		} else {
			// Liste ist voll -> Suche das aktuell letzte Element und hänge das neue dort an
			last().next = new ListElement(element);
		}
		return true;
	}

	// Zählt, wie viele Elemente in der Liste sind
	public int size() {
		int count = 0;
		ListElement current = first;
		// Hüpfe von Element zu Element, bis wir am Ende (null) ankommen
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}

	// Prüft, ob ein bestimmtes Element in der Liste existiert
	public boolean contains(Object o) {
		ListElement current = first;
		while (current != null) {
			// Sicherer Vergleich (verhindert Absturz, falls wir nach 'null' suchen)
			if (o == null ? current.payload == null : o.equals(current.payload)) {
				return true; // Gefunden!
			}
			current = current.next; // Weiter zum nächsten Element
		}
		return false; // Nicht gefunden
	}

	// Sucht ein Element anhand des Wertes und löscht es
	public boolean remove(Object o) {
		if (first == null) return false; // Liste ist leer

		// Sonderfall: Das gesuchte Element ist direkt das ALLERERSTE
		if (o == null ? first.payload == null : o.equals(first.payload)) {
			first = first.next; // Wir machen das 2. Element zum Startpunkt (das 1. ist somit gelöscht)
			return true;
		}

		// Normalfall: Element ist irgendwo mittendrin
		ListElement current = first;
		while (current.next != null) {
			// Wir prüfen immer den Wert des NÄCHSTEN Elements (current.next)
			if (o == null ? current.next.payload == null : o.equals(current.next.payload)) {
				// Zeiger umbiegen: Wir überspringen das gesuchte Element einfach.
				// (Aus A -> B -> C wird A -> C). Element B ist damit gelöscht.
				current.next = current.next.next;
				return true;
			}
			current = current.next;
		}
		return false;
	}

	// Ersetzt den Wert an einem bestimmten Index
	public T set(int index, T element) {
		ListElement el = getElement(index); // Finde das Kettenglied an Position X
		if (el == null) throw new IndexOutOfBoundsException(); // Index existiert nicht
		
		T oldPayload = el.payload; // Alten Wert merken (müssen wir am Ende zurückgeben)
		el.payload = element;      // Neuen Wert in das Kettenglied schreiben
		return oldPayload;
	}

	// Fügt ein Element an einem GANZ BESTIMMTEN INDEX ein
	public void add(int index, T element) {
		// Sonderfall: Ganz vorne einfügen
		if (index == 0) {
			ListElement newNode = new ListElement(element);
			newNode.next = first; // Das neue Element zeigt auf den bisherigen Start
			first = newNode;      // Das neue Element wird der neue Start
			return;
		}
		
		// Normalfall: In der Mitte einfügen
		ListElement prev = getElement(index - 1); // Finde das Element EINS VOR der Zielposition
		if (prev == null) throw new IndexOutOfBoundsException();
		
		ListElement newNode = new ListElement(element);
		newNode.next = prev.next; // Das neue Element zeigt auf das bisherige Element an der Position
		prev.next = newNode;      // Das vorherige Element zeigt jetzt auf unser neues
	}

	// Löscht das Element an einem bestimmten INDEX
	public T remove(int index) {
		if (first == null) throw new IndexOutOfBoundsException();
		
		// Sonderfall: Erstes Element löschen
		if (index == 0) {
			T val = first.payload;
			first = first.next; // Startpunkt einfach auf das 2. Element verschieben
			return val;
		}
		
		// Normalfall: Element in der Mitte löschen
		ListElement prev = getElement(index - 1); // Finde das Element EINS VOR der Zielposition
		if (prev == null || prev.next == null) throw new IndexOutOfBoundsException();
		
		T val = prev.next.payload; // Wert des zu löschenden Elements merken
		prev.next = prev.next.next; // Zu löschendes Element überspringen (Zeiger umbiegen)
		return val;
	}

	// Prüft, ob die Liste komplett leer ist
	public boolean isEmpty() {
		return first == null;
	}

	// Leert die komplette Liste auf einen Schlag
	public void clear() {
		first = null; // Wenn der Startpunkt weg ist, löscht Java den Rest automatisch (Garbage Collector)
	}

	// Holt sich den Wert an einem bestimmten Index
	public T get(int index) {
		ListElement el = getElement(index);
		if (el == null) throw new IndexOutOfBoundsException();
		return el.payload;
	}

	// --- Vorgegebene Hilfsmethoden vom Dozenten ---
	
	// Spult die Liste bis zum allerletzten Element vor
	private ListElement last() {
		if (first == null) return null;
		ListElement current = first;
		while (current.next != null) {
			current = current.next;
		}
		return current;
	}

	// Findet das "Kettenglied" (Node) an einem bestimmten Index
	private ListElement getElement(int index) {
		if (isEmpty() || index < 0) return null;
		ListElement current = first;
		// Wir gehen die Kette entlang und zählen den Index runter, bis wir bei 0 sind
		while (current != null) {
			if (index == 0) return current;
			index--;
			current = current.next;
		}
		return null;
	}
}