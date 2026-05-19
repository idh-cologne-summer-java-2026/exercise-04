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
	
	
	public void add(T element) { // Typ T
	    this.add(this.size(), element);
	}

	/**
	 * We only need to store the very first element of our list, because it will
	 * know whether there is a next element.
	 */
	
	ListElement first;
// Implement 1. 
	public int size() {
		int count = 0; 
		ListElement current = first; 
		
		while (current != null) { 
			count ++; 
			current = current.next; 
		}
		return 0;
	 }
	
	
// Implement 2. 
	public boolean contains(Object o) {
		ListElement current = first; 
		while (current != null) { 
			if (o == null && current.payload == null)
				return true; 
		}
		 
		current = current.next; 
		
			
		return false;
	 }
	

// Implement 3. 
	public boolean remove(Object o) {
		if (isEmpty ()) return false; // Wenn Liste leer ist kann nichts gelöscht werden 
		
		ListElement current = first; 
		while (current.next != null) { 
			if ((o == null && first.payload == null)); 
			first = first.next; 
			return true; 
		}
		
	    
		while (current.next != null) {
			if ((o == null && current.next.payload == null)) {
				current = current.next.next; 
			return true; 
		   
			}
		
		current = current.next; 
		}
		return false;

	   }
	
	
	
	// Implement 4. 
	public T set(int index, T element) {
		ListElement target = getElement(index); 
		
		if (target == null) {
			throw new IndexOutOfBoundsException("Index ungültig: " + index);
		}
		
		T alteLadung = target.payload; 
		
		target.payload = element;
		return alteLadung;
	}

	
	
	// Implement 5. 
	public void add(int index, T element) {
		ListElement neu = new ListElement(element); 
		
		if(index == 0) { 
			neu.next = first; 
			first = neu; // neuer Startpunkt
			return;
		}
		        ListElement before = getElement(index  - 1); // Stelle, bevor das neue Element eingefügt werden soll
		        if (before == null) {
		            throw new IndexOutOfBoundsException("Index ungültig: " + index);
		        }
		        
		        neu.next = before.next; 
		        before.next = neu; // neues Element 
		    }
		
			
			
    
	// Implement 6. 
	public T remove(int index) {
		if (index == 0) { 
			T alterPayload = first.payload; 
			first = first.next; 
			return alterPayload; 
		}
		
		ListElement before = getElement(index - 1); 
		if (before == null )
			throw new IndexOutOfBoundsException();
		
		T alterPayload = before.next.payload; 
		before.next = before.next.next; 
		return alterPayload;
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
