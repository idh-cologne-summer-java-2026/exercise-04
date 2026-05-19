package idh.java;

public class MyLinkedList<T> {

	/**
	 * Helper class for the list elements
	 */
	//Deklaration
	private class ListElement {
		T payload;
		ListElement next = null;

		//Konstruktor 
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
		int count = 0; 
		ListElement current = first;
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}

	public boolean contains(Object o) {
		ListElement current = first;
		while (current != null) {
			if (current.payload == o) {
				return true;
			}
			current = current.next;
		}
		
		return false;
	}

	// Hier muss der Pfeil(also next Object) verändert werden, damit der Pfeil nicht mehr auf das entfernte Objekt zeigt, sondern auf das 
	// übernächste 
	public boolean remove(Object o) {
		
		//Erstes Elemet entfernt (Muss spezifisch genannt werden, da es sonst keinen next-Pfeil gibt, der geändert werden könnte
		if (o.equals(first.payload)) {
			first = first.next;
			return true;
		}
		
		//Element aus der Mitte entfernt
		ListElement current = first;
		while (current.next != null) {
			if (o.equals(current.next.payload)) {
				current.next = current.next.next;
				return true;
			}
			current = current.next; 
		}
		return false;
	}

	public T set(int index, T element) {
		// getElement sucht uns vorher schon das richtige Element raus 
		//Hier wird quasi nur der String überschrieben, an der Pfeilkette (next) ändert sich nichts 
		ListElement node = getElement(index);
		node.payload = element; 
		return element;
	}

	public void add(int index, T element) {
		ListElement newElement = new ListElement(element);
		
		//Erstes Element
		if (index == 0) {
			newElement.next = first;
			first = newElement;
		} else {
			ListElement previous = getElement (index-1);
			if (previous != null) {
				newElement.next = previous.next;
				previous.next = newElement; 
			}
		}
		
		ListElement previous = getElement (index-1);
		// Hier müssen noch die next-Pfeile geändert werden 
		previous.next =newElement; //(Der vorherige Pfeil zeigt aufs neue Elment)
		newElement.next = previous.next; // (Das neue Element braucht den alten Pfeil)
		
	}


	public T remove(int index) {
		//Erstes Element
		if (index == 0) {
			first = first.next;
		}
		
		//Element aus der Mitte
		//Vorgänger des gefragten Elements raussuchen 
		ListElement previous = getElement(index-1);
		//Der next-Pfeil muss geändert werden auf den übernächsten Wert 
		previous.next = previous.next.next;
		return null;
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
	/*private ListElement last() {
		if (first == null)
			return null;
		ListElement current = first;

		while (current.next != null) {
			current = current.next;
		}
		return current;
	}*/

	/**
	 * Internal method to get the list element (not the value) of the list at the
	 * specified index position.
	 * 
	 * @param index
	 * @return
	 */
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
