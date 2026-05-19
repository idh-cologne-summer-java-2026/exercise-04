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

	/* Returns the number of elements in this list.*/
	public int size() {
		int count = 0;
		ListElement current = first;
		while (current != null) {
			count ++;
			current = current.next;
		}
		return count;
	}
	
	/* Returns true if this list contains the specified element */
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
	
	
	/* Removes the first occurrence of the specified element from this list, if it is present */
	public boolean remove(Object o) {
		
		// Erstes Element entfernen
		if (o.equals(first.payload)) {
			first = first.next;
			return true;
		}

		// Element in Mitte/Ende entfernen
		ListElement current = first;
		while (current.next != null) {
			if (o.equals(current.next.payload)) {
				current.next = current.next.next;
				return true;
			}
		}
		return false;

	}
	
	/*Replaces the element at the specified position in this list with the specified element.*/
	public T set(int index, T element) {
		ListElement node = getElement(index);
		T oldValue = node.payload;
		node.payload = element;
		return oldValue;
	}
	
	/*Inserts the specified element at the specified position in this list.*/
	public void add(int index, T element) {
		ListElement newElement = new ListElement(element);
		
		if (index == 0) {
			newElement.next = first;
			first = newElement;
		} else {
		ListElement previous = getElement(index-1);
		if (previous != null) {
			newElement.next = previous.next;
			previous.next = newElement;
		}
		}
	} 

	/* Removes the element at the specified position in this list*/
	public T remove(int index) {

		if (index == 0) {
			ListElement previous = first;
			first = first.next;
			return previous.payload;
		}
			
		int count = 0;
		ListElement current = first;
		while (current.next != null) {
			count++;
			current = current.next;
			 if (count == index) { 
				ListElement previous = current;
				current.next = current.next.next;
				return previous.payload; 
			}
		}
		return null;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	/*Removes all of the elements from this list.*/
	public void clear() {
		first = null;
	}
	
	/*Returns the element at the specified position in this list.*/
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
