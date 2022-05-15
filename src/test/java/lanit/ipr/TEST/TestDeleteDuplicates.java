package lanit.ipr.TEST;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static lanit.ipr.DeleteDuplicates.deleteDuplicates;

public class TestDeleteDuplicates {
    @Test
    public void Test(){
        LinkedList<Integer> testList1 = new LinkedList<>();
        for (int i=1; i<15; i++) {
            testList1.add(i);
            testList1.add(i*2);
        }
        LinkedList<Integer> trueList1 = new LinkedList<>();
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
        Assertions.assertTrue(testList1.equals(trueList1));
        testList1.clear();
        deleteDuplicates(testList1);
        Assertions.assertTrue(testList1.equals(new LinkedList<>()));
        testList1.add(1);
        testList1.add(2);
        testList1.add(1);
        trueList1.clear();
        trueList1.add(1);
        trueList1.add(2);
        deleteDuplicates(testList1);
        Assertions.assertTrue(testList1.equals(trueList1));
        testList1.clear();
        trueList1.clear();
        testList1.add(1);
        testList1.add(1);
        testList1.add(1);
        trueList1.add(1);
        deleteDuplicates(testList1);
        Assertions.assertTrue(testList1.equals(trueList1));
    }
}
