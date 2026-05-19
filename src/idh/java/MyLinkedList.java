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
		int size = 1;
		ListElement current = first;
		while(current.next != null) {
			size++;
			current = current.next;
		}
		return size;
	}

	public boolean contains(Object o) {
		ListElement current = first;
		do{
			if(current.payload == o) {
				return true;
				}
			else {
				current = current.next;
				return false;
			}
		}
		while(current.next != null);
	}

	public boolean remove(Object o) {
		// TODO: Implement
		return false;

	}

	public T set(int index, T element) {
		ListElement current = first;
		do{
			if(index == 0) {
				current.payload = element;
				break;
			}
			else {
				current = current.next;
				index--;
			}
		}
		while(current.next != null);
		return element;
	}

	public void add(int index, T element) {
		ListElement current = first;
		ListElement neues;
		do{
			if(index == 1) {
				neues = (ListElement) new Object();
				neues.next = current.next;
				current = neues;
				index--;
			}
			else {
				current = current.next;
				index--;
			}
			if(index == 0) {
				current.payload = element;
				break;
			}
		}
		while(current.next != null);
	}


	public T remove(int index) {
		// TODO: Implement
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
