package idh.java;

public class TestMyLinkedList {

	public TestMyLinkedList() {
		//MyLinkedList<String> list;
		//list = new MyLinkedList<>();
		

		MyLinkedList<String> list = new MyLinkedList<>();
		
		list.addlast("eins");
		list.addlast("zwei");
		list.addlast("drei");
		list.addlast("vier");
		list.addlast("fünf");
		list.addlast("sechs");
		
		System.out.println(list);
	}

}