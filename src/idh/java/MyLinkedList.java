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
		// TODO: Implement
		int count = 0; 
		ListElement current = first; 
		while(current.next!=null) {
			current = current.next; 
			count++; 
		}
		return count; 
	}

	public boolean contains(Object o) {
		ListElement current = first; 
		while(current.next !=null) {
			if(current.payload == o) {
				return true; 
			}
			current = current.next; 
		}
		return false; 
	}

	public boolean remove(Object o) {
		// remove first element 
		if(o.equals(first.payload)) {
			first = first.next; 
			return true; 
		}
		ListElement current = first; 
		while(current.next !=null) {
		  if(o.equals(current.next.payload)) {
			current.next = current.next.next; 
			return true; 
		  }
		}
        return false; 
	}

	public T set(int index, T element) {
		ListElement current = first; 
	    for(int i=0; i<index; i++) {
	      if(current.next==null) {
	    	  ListElement newE = new ListElement(element); 
	    	  current.next = newE; 
	    	  return element; 
	      }
	      current = current.next; 
	    }
	    current.payload = element; 
	    return element; 
		
	}

	public void add(int index, T element) {
		// TODO: Implement
		ListElement newE = new ListElement(element); 
		if(index ==0) {
			newE.next = first; 
			first = newE; 
		} else {
			ListElement current = first; 
			for(int i=0; i<index;i++) {
				current = current.next; 
			}
			newE.next = current.next; 
			current.next = newE; 
		}
	}


	public T remove(int index) {
	  if(index ==0) {
		  first = first.next; 
	  }
	  ListElement previous = getElement(index-1); 
	  previous.next = previous.next.next; 
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
