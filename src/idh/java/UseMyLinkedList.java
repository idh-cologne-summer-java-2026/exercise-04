package idh.java;

public class UseMyLinkedList {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();

        list.add(0,"A");
        list.add(1, "B");
        list.add(2, "C");

        //size()
        System.out.println("Size: " + list.size());

        //contains()
        System.out.println("Contains B: " + list.contains("B"));
        System.out.println("Contains X: " + list.contains("X"));

        //remove()
        System.out.println("Remove(A)");
        System.out.println("Remove A: " + list.remove("A"));
        System.out.println("Remove(B)");
        System.out.println("Remove B: " + list.remove("B"));

        //set(index, o)
        System.out.println("Set X: " + list.set(1, "X"));

    }
    
}
