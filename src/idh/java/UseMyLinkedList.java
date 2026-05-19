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

        //add()
        list.add(1, "Y");

        //set(index, o)
        System.out.println("Set X: " + list.set(1, "X"));
        System.out.println(list.get(1));

        list.clear();
        list.add(0,"A");
        list.add(1, "B");
        list.add(2, "C");

        //remove(index)
        System.out.println("Remove(1) " + list.remove(1));

         for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        //System.out.println(list.get(1));

        list.remove(0);
         for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
    
}
