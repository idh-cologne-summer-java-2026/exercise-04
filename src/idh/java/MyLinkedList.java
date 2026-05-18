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
		ListElement current = first;

		while (current != null) {
			counter++;
			current = current.next;
		}

		return counter;
	}

	public boolean contains(Object o) {
		ListElement current = first;

		while (current != null) {
			if (equalsPayload(current.payload, o)) {
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

		if (equalsPayload(first.payload, o)) {
			first = first.next;
			return true;
		}

		ListElement previous = first;
		ListElement current = first.next;

		while (current != null) {
			if (equalsPayload(current.payload, o)) {
				previous.next = current.next;
				return true;
			}

			previous = current;
			current = current.next;
		}
		return false;

	}

	public T set(int index, T element) {
		ListElement current = getElement(index);
		T oldPayload = current.payload;
		current.payload = element;
		return oldPayload;
	}
	
	public boolean add(T element) {
		ListElement newElement = new ListElement(element);

		if (first == null) {
			first = newElement;
		} else {
			last().next = newElement;
		}

		return true;
	}

	public void add(int index, T element) {
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}

		ListElement newElement = new ListElement(element);

		if (index == 0) {
			newElement.next = first;
			first = newElement;
			return;
		}

		ListElement previous = getElement(index - 1);
		newElement.next = previous.next;
		previous.next = newElement;
	}


	public T remove(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}

		if (index == 0) {
			T oldPayload = first.payload;
			first = first.next;
			return oldPayload;
		}

		ListElement previous = getElement(index - 1);
		ListElement removed = previous.next;

		previous.next = removed.next;

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
	
	private boolean equalsPayload(Object a, Object b) {
		if (a == null) {
			return b == null;
		}
		return a.equals(b);
	}

}
