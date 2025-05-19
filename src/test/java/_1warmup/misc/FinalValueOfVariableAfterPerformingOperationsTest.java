package _1warmup.misc;

import org.junit.jupiter.api.Test;

import static com._1warmup.misc.FinalValueOfVariableAfterPerformingOperations.finalValueAfterOperations;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FinalValueOfVariableAfterPerformingOperationsTest {

    @Test
    void quickTest1() {
        int result = finalValueAfterOperations(new String[]{"--X","X++","X++"});
        assertEquals(1, result);
    }

    @Test
    void quickTest2() {
        int result = finalValueAfterOperations(new String[]{"X++","++X","--X","X--"});
        assertEquals(0, result);
    }
}
