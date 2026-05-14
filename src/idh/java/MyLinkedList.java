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

	public int size() { // zählt die Elemente in einer Liste und geht mit next weiter
		
		
		int count = 0;
		ListElement current = first;  // First zeigt auf das erste Element wenn Liste leer, dann first = 0
		
		while (current != null) {
			count++;
			current = current.next; // Mit next bewegt man sich durch die Liste
		}
		return count;  // Länge der Liste
	}

	public boolean contains(Object o) {
	
		ListElement current = first;
		
		while (current != null) {
			
			if (o == null) {  // Fall 1: Index ist leer 
				
			if (current.payload == null) {   // Fall 2: Es wird nach "null" gesucht
				return true;
					
				} else {
				if (o.equals(current.payload)) { // Fall 3: Objekt vorhanden und nicht "null"
					
				} return true;   // Wenn das Element am Index mit dem gesuchten Object übereinstimmt dann true
	          }
			
		    }   current = current.next; 
		    
		} return false;
				    }


	public boolean remove(Object o) {
		
		if (first == null) {   // Fall 1: Liste leer
		return false;
		}
	
	

		if (o == null) {                       // Fall 2: Das erste Elemente soll entfernt werden
            if (first.payload == null) {
                first = first.next;
                return true;
            }
            
        } else {
            if (o.equals(first.payload)) {   // Fall 3: Das gesuchte Object soll entfernt werden
                first = first.next;
                return true;
            }
        }

        ListElement current = first;

        while (current.next != null) {
            if (o == null) {
                if (current.next.payload == null) {
                    current.next = current.next.next;
                    return true;
                }
            } else {
                if (o.equals(current.next.payload)) {
                    current.next = current.next.next;
                    return true;
                }
            }

            current = current.next;
        }

        return false;
    }


	public T set(int index, T element) {
		

		ListElement listElement = getElement(index);

        if (listElement == null) {
            throw new IndexOutOfBoundsException();
        }

        T oldValue = listElement.payload;
        listElement.payload = element;   // Ersetzt den Wert an einem bestimmten Index

        return oldValue;
    }


	public boolean add(T element) {
        ListElement newElement = new ListElement(element);

        if (first == null) {
            first = newElement; // Wenn die Liste leer ist, dann wird das neue Element an die erste Stelle gesetzt
        } else {
            last().next = newElement;  //ruft die methode Last() auf, die zum letzten Element springt und fügt das neue Elemt ein
        }

        return true;
    }


	public void add(int index, T element) { //Element an einem Index einfügen
		
		if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();  // Grenzwerte prüfen und Exception 
        }

        ListElement newElement = new ListElement(element);

        if (index == 0) {            // Ist der Index bei 0, dann wird das neue Element an die erste Stelle geschrieben
            newElement.next = first;
            first = newElement;
            return;    
        }

        ListElement previous = getElement(index - 1);  // Einfügen des Werts vor dem gesuchten Index damit der Wert mit .next am Index gespeichert wird 
        newElement.next = previous.next;
        previous.next = newElement;
    }

    
    


		
	

	


	public T remove(int index) {
		
		

		 if (index < 0 || index >= size()) {
		            throw new IndexOutOfBoundsException();  // Grenzwerte prüfen
		        }

		        if (index == 0) {                 // Bei index = 0 wird das erste Element entfernt 
		            T oldValue = first.payload;
		            first = first.next;         
		            return oldValue;
		        }

		        ListElement previous = getElement(index - 1);   // Ein Element in der Mitte oder am Ende soll entfernt werden. Der Index springt dann eins zurück.
		        ListElement elementToRemove = previous.next;

		        T oldValue = elementToRemove.payload;
		        previous.next = elementToRemove.next;

		        return oldValue;  // Der entfernte Wert wird zurückgegeben
		    }

		
	

		public boolean isEmpty() {
			return first == null;
		}
	
		public void clear() {
			first = null;  // Liste wird auf 0 gesetzt
		}
	
		
		
		public T get(int index) {
		
		ListElement element = getElement(index);

        if (element == null) {
            throw new IndexOutOfBoundsException();  //Wenn kein Element am Index gefunden wird, dann existert dieser nicht -> throw Exception
        }

        return element.payload;  // Gibt nur den Wert am Index zurück

		
	}

	/**
	 * Internal method that iterates over the list, returning the last element
	 * (i.e., the one whose next field is null)
	 * 
	 * @return
	 */
	private ListElement last() {  //geht durch die Liste bis zum letzten Element
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
			return null;  //Wenn die Liste leer ist, gibt es kein Element
		
		ListElement current = first;
		while (current != null) { //Ist der Index > 0, dann geht die Schleife weiter
			
			if (index == 0)
				return current; // Ist die Schleife beim Index 0 angekommen, wird der gesuchte Wert bzw. Index zurückgegeben
			index--;
			current = current.next;
		}
		return null;
	}
	
	
	
	

	
	
	
	
	
	

}
