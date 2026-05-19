package idh.java;

public class MyLinkedList<T> {

    /** Helper class for the list elements */
    private class ListElement {
        T payload;
        ListElement next;

        ListElement(T value) {
            this.payload = value;
            this.next = null;
        }
    }

    private ListElement first;

    public MyLinkedList() {
        this.first = null;
    }

    public int size() {
        int n = 0;
        ListElement current = first;
        while (current != null) {
            n++;
            current = current.next;
        }
        return n;
    }

    public boolean contains(Object o) {
        for (ListElement cur = first; cur != null; cur = cur.next) {
            if (o == null) {
                if (cur.payload == null) return true;
            } else {
                if (o.equals(cur.payload)) return true;
            }
        }
        return false;
    }

    public boolean remove(Object o) {
        ListElement prev = null;
        ListElement cur = first;
        while (cur != null) {
            if (o == null ? cur.payload == null : o.equals(cur.payload)) {
                if (prev == null) {
                    first = cur.next;
                } else {
                    prev.next = cur.next;
                }
                return true;
            }
            prev = cur;
            cur = cur.next;
        }
        return false;
    }

    public T set(int index, T element) {
        ListElement e = getElement(index);
        T old = e.payload;
        e.payload = element;
        return old;
    }

    public void add(int index, T element) {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException("Index: " + index);
        if (index == 0) {
            ListElement ne = new ListElement(element);
            ne.next = first;
            first = ne;
            return;
        }
        ListElement prev = getElement(index - 1);
        ListElement ne = new ListElement(element);
        ne.next = prev.next;
        prev.next = ne;
    }

    public T remove(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException("Index: " + index);
        if (index == 0) {
            T val = first.payload;
            first = first.next;
            return val;
        }
        ListElement prev = getElement(index - 1);
        ListElement toRemove = prev.next;
        prev.next = toRemove.next;
        return toRemove.payload;
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
     */
    private ListElement last() {
        if (first == null) return null;
        ListElement cur = first;
        while (cur.next != null) cur = cur.next;
        return cur;
    }

    /**
     * Internal method to get the list element (not the value) at the specified index.
     */
    private ListElement getElement(int index) {
        if (index < 0) throw new IndexOutOfBoundsException("Index: " + index);
        ListElement cur = first;
        int i = 0;
        while (cur != null) {
            if (i == index) return cur;
            i++;
            cur = cur.next;
        }
        throw new IndexOutOfBoundsException("Index: " + index);
    }

}
