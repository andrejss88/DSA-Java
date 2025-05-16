package _1warmup.misc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com._1warmup.misc.SmallestEvenMultiple2413.smallestEvenMultiple;
import static org.junit.jupiter.api.Assertions.*;

public class SmallestEvenMultipleTest {

    @Test
    void smallestMultipleTestEvenNum() {
        assertEquals(6, smallestEvenMultiple(6));
    }

    @Test
    void smallestMultipleTestOddNum() {
        assertEquals(10, smallestEvenMultiple(5));
    }

}
