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
			if (current.payload.equals(o)) {
				return true;
			}
		
		current = current.next;
		}		
		return false;
	}

	public boolean remove(Object o) {
		if (first == null) {
			return false;
		}
		
		if (first.payload.equals(o)) {
			first = first.next;
			return true;
		}
		
		ListElement current = first;
		
		while (current.next != null) {
			if (current.next.payload.equals(o)) {
				current.next = current.next.next;
				return true;
			}
			
			current = current.next;
		}
		return false;
	}

	public T set(int index, T element) {
		ListElement e = getElement(index);
		
		T old = e.payload;
		e.payload = element;
		
		return old;
	}

	public void add(int index, T element) {
		ListElement neu = new ListElement(element);
		
		if (index == 0) {
			neu.next = first; // der next-Wert wird auf null gesetzt
			first = neu; 		// der first wert kriegt das neue element
			return;
		}
		ListElement before = getElement(index-1);
		neu.next = before.next; // unser neues Element kriegt den next wert vom element was vorher an der stelle stand
		before.next = neu; // das vorherige element kriegt den wert vom neuen element
		// -> kette wieder in takt
		
	}


	
	/*
	 * Hier muss ein T wiedergegeben werden (?!)
	 * wir schauen uns den knoten via getElement an
	 * müssen den link vom knoten an index-1 zur stelle von knoten index.next herstellen
	 * also zb mit einem before element?
	 * ich glaub es sollte reichen wenn kein link mehr besteht, dann ist das element 
	 * hinfällig und wird gelöscht
	 */
	
	
	public T remove(int index) {
		if (index == 0) {
			T value = first.payload;
			first = first.next;
			return value;
		}
		
		ListElement before = getElement(index-1);
		ListElement removed = before.next;
		before.next = removed.next;
		return removed.payload;
		
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
	
	public boolean add(T element) {
		ListElement neu = new ListElement(element);
		
		if (first == null) {
			first = neu;
			return true;
		}
		last().next = neu;
		return true;
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
