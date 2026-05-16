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
		if(first == null) {
			return 0;
		}
		int counter = 1;
		ListElement current = first;
		while (current.next != null) {
			counter++;
			current = current.next;
		}
		return counter;
	}
	
	public void add(T element) {
		
		ListElement newElement = new ListElement(element);
		if(first == null) {
			first = newElement;
			return;
		}
		
		ListElement current = first;
		while (current.next != null) {
		current = current.next;	
		}
		current.next = newElement;
	}
	
	
	public boolean contains(Object o) {
		if(first == null) {
			return false;
		}
		ListElement current = first;
		
		while (current.next != null) {
			if(current.payload.equals(o)) {
				return true;
			}
		current = current.next;
		}
		if(current.payload.equals(o)) {
			return true;
		}
		return false;
	}

	public boolean remove(Object o) {
		ListElement current = first;
		while (current.next != null) {
			if(current.payload == o) {
				current = null; 
				return true;
			}
		current = current.next;
		}
		return false;

	}

	public T set(int index, T element) {
		
		ListElement newElement = new ListElement(element);
		ListElement current = first;
		
		//Check if index is bigger than List Length
		/**if(index > MyLinkedList<T>.size()){
			-> throw exception
		}**/
		
		for(int i = 0; i < index; i++) {
			current = current.next;
		}
		current = newElement;
		
		return element;
	}

	public void add(int index, T element) {
		
		ListElement newElement = new ListElement(element);
		ListElement current = first;
		while (current != null) {
			if (index == 0)
			current = newElement;
		}
		index--;
	}


	public T remove(int index) {
		ListElement current = first;
		while (current.next != null) {
			
			if (index == 0) {
				current = null; 
				return null;
			}
				index--;
				current = current.next;
		}
		return (T) current;
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
			if (index == 0) {
				return current;
			}
			index--;
			current = current.next;
		}
		return null;
	}

}
