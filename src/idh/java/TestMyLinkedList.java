package idh.java;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestMyLinkedList {
		
	@Test 
	public void TestSize() {
		MyLinkedList<String> TestList= new MyLinkedList<String>(); 
		TestList.add(0, null);
		TestList.add(1, null);
		TestList.add(2, null);
		TestList.add(3, null);
		//Testen, ob die richtige Nummer an Listeneinträgen zurückgegeben wird
		assertEquals(TestList.size(), 4 ); 
		TestList.add(4, null);
		TestList.add(5, null);
		assertEquals(TestList.size(), 6 );
		//Wie kann ich eine Linked list von einer bestimmten größe erstellen, wenn es keinen Konstruktor gibt? 
	}
	
	@Test 
	public void TestGet() {
		MyLinkedList<String> TestList = new MyLinkedList<String>(); 
		TestList.add(0, null);
		TestList.add(1, null);
		TestList.add(2, null);
		TestList.add(3, null);
		assertEquals(TestList.get(2), null); 
		
		
	}
	
	@Test 
	public void TestAdd() {
		MyLinkedList<String> TestList = new MyLinkedList<String>(); 
		assertTrue(TestList.add(0, null)); 
		
		
	}
	
	@Test 
	public void TestClear() {
		MyLinkedList<String> TestList = new MyLinkedList<String>(); 
		assertNull(TestList.get(0)); 
		
	}

}
