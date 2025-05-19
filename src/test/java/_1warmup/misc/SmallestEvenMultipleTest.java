package _1warmup.misc;

import org.junit.jupiter.api.Test;

import static com._1warmup.misc.SmallestEvenMultiple.smallestEvenMultiple;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
