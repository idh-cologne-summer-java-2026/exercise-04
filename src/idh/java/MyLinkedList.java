package idh.java;

public class MyLinkedList<T> {

	/**
	 * Helper class for the list elements
	 */
	private class ListElement {
		T payload;
		ListElement next = null;

		ListElement(T value) {
			this.payload = value;
		}
	}

	/**
	 * We only need to store the very first element of our list, because it will
	 * know whether there is a next element.
	 */
	ListElement first;

	public int size() {
		int counter = 0;
		ListElement aktuell = first;
		while(aktuell != null) {
			counter++;
			aktuell = aktuell.next;
		}
		return counter;
	}

	public boolean contains(Object o) {
		ListElement aktuell = first;
		while(aktuell != null) {
			if(aktuell.payload.equals(o)) {
				return true;
			}
			aktuell = aktuell.next;
		}
		return false;
	}

	public boolean remove(Object o) {
		
		ListElement vorher = null;
		ListElement aktuell = first;
		while(aktuell != null){// schaut ob die Liste leer ist
			if(aktuell.payload.equals(o)){ // schaut ob o in Liste
				if(vorher == null) { // schaut ob es das erste Element ist
					first = aktuell.next;
				}else {// wenn nicht dann übergib dem Vorgänger deine Zahl
					vorher.next = aktuell.next;
				}
				return true;
			}
			vorher = aktuell; // speicher den aktuellen Wert = Vorgänger in der nächsten Runde
			aktuell = aktuell.next; // gehe zum nächsten Element
		}
		return false;
	}

	public T set(int index, T element) {
		ListElement neu = new ListElement(element);
		ListElement aktuell = first;
		for(int i = 0; i < index; i++ ) {
			aktuell = aktuell.next;
		}
		// kürzer mit getElement aufrufen lol
		T old= aktuell.payload;
		aktuell.payload = neu.payload;	
		return old;
	}

	public void add(int index, T element) {
		ListElement neu = new ListElement(element);
		if (index == 0) {
		neu.next = first;
		first = neu;
		return;
		}
		ListElement aktuell = first;
		for(int i = 0; i < index -1; i++) {
			aktuell = aktuell.next;
		}
		neu.next = aktuell.next;
		aktuell.next = neu;
	}
	

	public T remove(int index) {
		if(index == 0) {
			T value = first.payload;
			first = first.next; 
			return value;
		}
		ListElement aktuell = first; 
		for(int i = 0; i< index -1; i++) { 
			aktuell = aktuell.next;
		}
		ListElement entfernen = aktuell.next;
		aktuell.next = entfernen.next;
		return entfernen.payload;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void clear() {
		first = null;
	}

	public T get(int index) {
		return getElement(index).payload;
	}

	/**
	 * Internal method that iterates over the list, returning the last element
	 * (i.e., the one whose next field is null)
	 * 
	 * @return
	 */
	private ListElement last() {
		if (first == null)
			return null;
		ListElement current = first;

		while (current.next != null) {
			current = current.next;
		}
		return current;
	}

	/**
	 * Internal method to get the list element (not the value) of the list at the
	 * specified index position.
	 * 
	 * @param index
	 * @return
	 */
	//Hallo
	private ListElement getElement(int index) {
		if (isEmpty())
			return null;
		ListElement current = first;
		while (current != null) {
			if (index == 0)
				return current;
			index--;
			current = current.next;
		}
		return null;
	}

}
