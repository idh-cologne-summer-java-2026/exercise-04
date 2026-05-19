package idh.java;

public class EmployMyLinkedList {

	public static void main(String[] args) {
		
		MyLinkedList<String> list = new MyLinkedList<>();
		
		list.add(0, "A");
		list.add(1, "B");
		list.add(2, "C");
		
		// size()
		System.out.println("Size: " + list.size());
		
		//contains()
		System.out.println("Contains A: " + list.contains("A"));
		System.out.println("Contains B: " + list.contains("B"));
		
		//set(index, element)
		System.out.println("set 1:  " + list.set(1, "X"));
		
		//remove(o)
		//System.out.println("Remove A: " + list.remove("A"));
		//System.out.println("Remove B: " + list.remove("B"));
		//System.out.println("Remove C: " + list.remove("C"));
		
		//remove(index)
		//System.out.println("Remove 0: " + list.remove(0));
		System.out.println("Remove 1: " + list.remove(1));
		//System.out.println("Remove 2: " + list.remove(2));
		
		
	}

}
