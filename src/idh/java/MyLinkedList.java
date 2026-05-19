package idh.java;

public class MyLinkedList<T> {


	private class ListElement {
		T payload;
		ListElement next = null;

		ListElement(T value) {
			this.payload = value;
		}
	}

	
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
			if (o == null ? current.payload == null : o.equals(current.payload)) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public boolean remove(Object o) {
		if (isEmpty()) return false;
		

		if (o == null ? first.payload == null : o.equals(first.payload)) {
			first = first.next;
			return true;
		}
		
		
		ListElement current = first;
		while (current.next != null) {
			if (o == null ? current.next.payload == null : o.equals(current.next.payload)) {
				current.next = current.next.next;
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public T set(int index, T element) {
		ListElement targetNode = getElement(index);
		if (targetNode == null) return null;
		
		T oldValue = targetNode.payload;
		targetNode.payload = element;
		return oldValue;
	}

	public void add(int index, T element) {
		ListElement newElement = new ListElement(element);
		
		if (index == 0) {
			newElement.next = first;
			first = newElement;
		} else {

			ListElement prevElement = getElement(index - 1);
			if (prevElement != null) {
				newElement.next = prevElement.next;
				prevElement.next = newElement;
			}
		}
	}

	public T remove(int index) {
		if (isEmpty()) return null;
		
		if (index == 0) {
			T removedValue = first.payload;
			first = first.next;
			return removedValue;
		}
		
		ListElement prevElement = getElement(index - 1);
		if (prevElement == null || prevElement.next == null) return null;
		
		T removedValue = prevElement.next.payload;
		prevElement.next = prevElement.next.next;
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

	//
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