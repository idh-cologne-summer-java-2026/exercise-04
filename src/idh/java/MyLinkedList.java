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
			if (o == null && current.payload == null) {
				return true;
			}

			if (o != null && o.equals(current.payload)) {
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

		if (o == null && first.payload == null) {
			first = first.next;
			return true;
		}

		if (o != null && o.equals(first.payload)) {
			first = first.next;
			return true;
		}

		ListElement current = first;

		while (current.next != null) {
			if (o == null && current.next.payload == null) {
				current.next = current.next.next;
				return true;
			}

			if (o != null && o.equals(current.next.payload)) {
				current.next = current.next.next;
				return true;
			}

			current = current.next;
		}

		return false;
	}

	public T set(int index, T element) {
		ListElement current = getElement(index);
		T oldValue = current.payload;
		current.payload = element;
		return oldValue;
	}

	public void add(int index, T element) {
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
		if (index == 0) {
			T oldValue = first.payload;
			first = first.next;
			return oldValue;
		}

		ListElement previous = getElement(index - 1);
		T oldValue = previous.next.payload;
		previous.next = previous.next.next;
		return oldValue;
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