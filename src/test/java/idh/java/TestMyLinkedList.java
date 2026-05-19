package idh.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestMyLinkedList {


    MyLinkedList<Integer> list1 = new MyLinkedList<>();

    @BeforeEach
    void setlist() {
        list1.add(0,1);
        list1.add(1,2);
        list1.add(2,3);
        list1.add(3,4);
        list1.add(4,5);
        list1.add(5,6);
    }

    @Test
    void sizetest() {
        Assertions.assertEquals(6, list1.size());
    }

    @Test
    void gettest() {
        Assertions.assertEquals(3, list1.get(2));
    }

    @Test
    void addtest() {
        list1.add(2,200);
        try {
            Assertions.assertEquals(200, list1.get(2));
            Assertions.assertEquals(3, list1.get(3));
            Assertions.assertEquals(6, list1.get(6));
            Assertions.assertEquals(null, list1.get(7));
        } catch (Exception e) {
        }
    }

    @Test
    void clear() {
        list1.clear();
        Assertions.assertEquals(true, list1.isEmpty());
    }

}
