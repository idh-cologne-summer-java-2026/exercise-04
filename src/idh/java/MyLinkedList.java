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
			       if ((o == null && current.payload == null) || (o != null && o.equals(current.payload))) {
				       return true;
			       }
			       current = current.next;
		       }
		       return false;
	       }

	       public boolean remove(Object o) {
		       ListElement current = first;
		       ListElement prev = null;
		       while (current != null) {
			       if ((o == null && current.payload == null) || (o != null && o.equals(current.payload))) {
				       if (prev == null) {
					       first = current.next;
				       } else {
					       prev.next = current.next;
				       }
				       return true;
			       }
			       prev = current;
			       current = current.next;
		       }
		       return false;
	       }

	       public T set(int index, T element) {
		       ListElement el = getElement(index);
		       if (el == null) {
			       throw new IndexOutOfBoundsException();
		       }
		       T old = el.payload;
		       el.payload = element;
		       return old;
	       }

	       public void add(int index, T element) {
		       if (index < 0 || index > size()) {
			       throw new IndexOutOfBoundsException();
		       }
		       ListElement newEl = new ListElement(element);
		       if (index == 0) {
			       newEl.next = first;
			       first = newEl;
			       return;
		       }
		       ListElement prev = getElement(index - 1);
		       newEl.next = prev.next;
		       prev.next = newEl;
	       }


	       public T remove(int index) {
		       if (index < 0 || index >= size()) {
			       throw new IndexOutOfBoundsException();
		       }
		       if (index == 0) {
			       T val = first.payload;
			       first = first.next;
			       return val;
		       }
		       ListElement prev = getElement(index - 1);
		       if (prev == null || prev.next == null) {
			       throw new IndexOutOfBoundsException();
		       }
		       T val = prev.next.payload;
		       prev.next = prev.next.next;
		       return val;
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
