package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {

    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> A = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();
        A.addLast(4);
        B.addLast(4);
        A.addLast(5);
        B.addLast(5);
        A.addLast(6);
        B.addLast(6);

        assertEquals(A.removeLast(), B.removeLast());
        for (int i = 0; i < A.size(); i++) {
            assertEquals(A.get(i), B.get(i));
        }
    }

    @Test
    public void testOneThousand() {
        AListNoResizing<Integer> A = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();
        for (int i = 0; i < 1000; i++) {
            A.addLast(i);
            B.addLast(i);
        }
        for (int j = 0; j < 900; j++) {
            assertEquals(A.removeLast(), B.removeLast());
        }
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();
        int operationNumber;
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            if (L.size() > 0) {
                operationNumber = StdRandom.uniform(0, 4);
            } else {
                operationNumber = StdRandom.uniform(0, 2);
            }
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int size2 = B.size();
                System.out.println("size of A is : " + size);
                System.out.println("size of B is : " + size2);
                assertEquals(size, size2);
            } else if (operationNumber == 2) {
                int x = L.getLast();
                int y = B.getLast();
                System.out.println("The last item of A is " + x);
                System.out.println("The last item of B is " + y);
                assertEquals(x, y);
            } else if (operationNumber == 3) {
                int x = L.removeLast();
                int y = B.removeLast();
                System.out.println("The last item in A of " + x + " is removed.");
                System.out.println("The last item in B of " + y + " is removed.");
                assertEquals(x, y);
            }

        }


    }
}
