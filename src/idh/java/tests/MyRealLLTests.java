package idh.java.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyRealLLTests {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	class MyLinkedListTests <T> {
		public MyLinkedListTests<Integer> LLT; //needs to NOT be static for the BeforeEach setUp method to work. The opposite is true for the BeforeAll annotation
		private MyLinkedListTests<String> StringList;// --> The generic Type allows for any complex data type to be used
		private MyLinkedListTests<Float> FloatList;
		T value;
		TestElement t;
		
		private class TestElement{
			T payLoad;
			TestElement next = null;
			
			TestElement(T value){
				this.payLoad = payLoad;
			}
		}
		
		//Cannot make static a reference to the non-static type T -> specifying the type here fixes it
		@BeforeEach
		 void setUp(){
			LLT = new MyLinkedListTests<Integer>();
		
		}
		

		/**
		 * Method iterates through list and checks if a given element has a next neighbor,<br>
		 * false if no more element and returns the counter
		 */
		@Test
		void sizeTest() {
			for(int i = 0; i < 10; i++) {
				LLT.add(i, new TestElement ((int)(Math.random()*101))); //why 101 and not 100? -> fill List with numbers 0-100
			}
			assertEquals(10, LLT.add(0, LLT.size()));	
		}
		
		@Test
		void getTest(T value) {
			this.value = value;
		}
		
		@Test 
		void add(int index, TestElement t) {
			LLT.add(index, t);
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
}