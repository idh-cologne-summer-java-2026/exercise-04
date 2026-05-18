package idh.java.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MyLinkedListTests <T> {
	MyLinkedListTests<Integer> LLT;
	T value;
	//Cannot make static a reference to the non-static type T -> specifying the type here fixes it
	
	@BeforeAll
	void setUp(){
		LLT = new MyLinkedListTests<Integer>();
	}
	
	
	public MyLinkedListTests() {
//		MyLinkedListTests <Integer>LLT = new MyLinkedListTests<Integer>();
//		LLT = new MyLinkedListTests<Integer>();
		for(int i = 0; i<=10; i++) {
			LLT.add((int) (Math.random()* 101)); //0-100 (?) -> why 101 and not just 100?
		}
	}

	/**
	 * Method iterates through list and checks if a given element has a next neighbor, false if no more element
	 */
	@Test
	void sizeTest() {
		fail();
		
	}
	
	@Test
	void getTest(T value) {
		fail();
	}
	
	@Test 
	void add(T value) {
		fail();
	}
	
	@Test
	void clear() {
		fail();
	}
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
