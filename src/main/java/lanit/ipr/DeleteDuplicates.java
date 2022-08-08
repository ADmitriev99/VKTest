package lanit.ipr;

import java.util.Iterator;
import java.util.LinkedList;

public class DeleteDuplicates {
    public static void deleteDuplicates(LinkedList<Integer> head) {
        if (head == null) return;
        for (int i = 0; i < head.size(); i++) {
            Iterator<Integer> outerIterator = head.iterator();
            boolean temp = false;
            while (outerIterator.hasNext()) {
                if (outerIterator.next() == head.get(i)) {
                    if (temp) {
                        outerIterator.remove();
                    } else {
                        temp = true;
                    }
                }
            }
        }
    }
}
