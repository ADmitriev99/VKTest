package lanit.ipr.TEST;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static lanit.ipr.DeleteDuplicates.deleteDuplicates;

public class TestDeleteDuplicates {
    LinkedList<Integer> testList1 = new LinkedList<>();
    LinkedList<Integer> trueList1 = new LinkedList<>();

    @BeforeEach
    public void beforeHook() {
        testList1.clear();
        trueList1.clear();
    }

    @Test
    public void testManyNumbers() {
        for (int i = 1; i < 15; i++) {
            testList1.add(i);
            testList1.add(i * 2);
        }
        trueList1.add(1);
        trueList1.add(2);
        trueList1.add(4);
        trueList1.add(3);
        trueList1.add(6);
        trueList1.add(8);
        trueList1.add(5);
        trueList1.add(10);
        trueList1.add(12);
        trueList1.add(7);
        trueList1.add(14);
        trueList1.add(16);
        trueList1.add(9);
        trueList1.add(18);
        trueList1.add(20);
        trueList1.add(11);
        trueList1.add(22);
        trueList1.add(24);
        trueList1.add(13);
        trueList1.add(26);
        trueList1.add(28);
        deleteDuplicates(testList1);
        Assertions.assertEquals(testList1, trueList1);
    }

    @Test
    public void testEmpty() {
        deleteDuplicates(testList1);
        Assertions.assertEquals(testList1, trueList1);
    }

    @Test
    public void testSameNumbers() {
        testList1.add(1);
        testList1.add(1);
        testList1.add(1);
        trueList1.add(1);
        deleteDuplicates(testList1);
        Assertions.assertEquals(testList1, trueList1);
    }

    @Test
    public void testNullData() {
        testList1.add(1);
        testList1.add(null);
        testList1.add(1);
        testList1.add(null);
        trueList1.add(1);
        trueList1.add(null);
        deleteDuplicates(testList1);
        Assertions.assertEquals(testList1, trueList1);
    }
}
