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
		ListElement current = first; 
		int counter = 0; 
		if(current == null) {return 0;}
		while(current.next != null) {
			counter++; 
			current = current.next; 
		}
		return counter-1; 
	}

	public boolean contains(Object o) {
		ListElement current = first; 
		while (current.next != null) { 
			if (current.payload == o) {
				return true; 
			}
			current = current.next;
		}
		return false;
	}

	public boolean remove(Object o) {
		ListElement current = first; 
		if(this.contains(o)) {
			ListElement before = new ListElement(null); 
			int counter = 0; 
			while (current.payload != o ) {
				current = current.next; 
				counter++; 
			}
			current = first; 
			for (int i = 0; i < counter; i++) {
				current = current.next;  
			
			}
			current.next = current.next.next; 
			return true; 
			
		}
		else {
		return false;}

	}

	public T set(int index, T element) {
	ListElement current = first; 
	for (int i = 0; i < index; i++) {
		if(current.next == null) {
			ListElement newElement = new ListElement(element); 
			current.next = newElement; 
			System.out.println("Die Liste hatte noch nicht" + index + "Einträge. Dein Eintrag wurde stattdessen an der Stelle" + (i+1) + "hinzugefügt");
			return element; 
			}
		current = current.next; 
		
		
	}
	current.payload = element; 
		return element;
	}

	public boolean add(int index, T element) {
		// TODO: Implement
		//Added einen neuen Listeninput. Dazu müssen wir die Elemente mit einer For SChleife bis dahin durchgeheh, die next Variable dieses Elements auf unser Element setzen, und die next variable von usnerem Element auf das Element danach setzen 
		ListElement current = first; 
		for(int i = 0; i < index; i++) {
			current = current.next;  
		}
//		ListElement nextElement = current.next; //Speichert die Adresse des nächsten Punkts
		ListElement newElement = new ListElement(element); 
		newElement.next = current.next; //Setzt das feld next unseres neuen Elements auf das Element, danach, das wir gespeichert haben 
		current.next = newElement; //Setzt die Adresse des nächsten Punkts auf unser neues element 
		return true;
	}


	public T remove(int index) {
		ListElement current = first; 
		for(int i = 0; i < index-1; i++) {
			if(current.next == null) {
				
				System.out.println("Die Liste hatte noch nicht" + index + "Einträge. Es wurde kein Eintrag gelöscht");
				return null; }
			current = current.next;  
		}
		
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
