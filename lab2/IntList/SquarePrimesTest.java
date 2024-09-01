package IntList;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

public class SquarePrimesTest {

    /**
     * Here is a test for isPrime method. Try running it.
     * It passes, but the starter code implementation of isPrime
     * is broken. Write your own JUnit Test to try to uncover the bug!
     */
    @Test
    public void testSquarePrimesSimple() {
        IntList lst = IntList.of(14, 15, 16, 17, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 289 -> 18", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSqurePrimesHard() {
        IntList lst = IntList.of(2, 3, 4, 5, 7, 9, 11);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("4 -> 9 -> 4 -> 25 -> 49 -> 9 -> 121", lst.toString());
        assertTrue(changed);
    }
}
