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
	        if (current.payload.equals(o)) return true;
	        current = current.next;
	    }
	    return false;
	}

	public boolean remove(Object o) {
	    if (first == null) return false;
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
	    ListElement node = getElement(index);
	    T oldPayload = node.payload;
	    node.payload = element;
	    return oldPayload;
	}

	public void add(int index, T element) {
	    ListElement newNode = new ListElement(element);
	    if (index == 0) {
	        newNode.next = first;
	        first = newNode;
	    } else {
	        ListElement prev = getElement(index - 1);
	        newNode.next = prev.next;
	        prev.next = newNode;
	    }
	}


	public T remove(int index) {
	    if (isEmpty()) return null;
	    T removedValue;
	    if (index == 0) {
	        removedValue = first.payload;
	        first = first.next;
	    } else {
	        ListElement prev = getElement(index - 1);
	        removedValue = prev.next.payload;
	        prev.next = prev.next.next;
	    }
	    return removedValue;
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
