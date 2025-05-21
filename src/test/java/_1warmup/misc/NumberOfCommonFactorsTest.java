package _1warmup.misc;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com._1easy.math.NumberOfCommonFactors.commonFactors;
import static com._1easy.math.NumberOfCommonFactors.commonFactors2;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfCommonFactorsTest {

    @ParameterizedTest
    @CsvSource({
            // always 1 common factor
            "1, 1, 1",
            "2, 1, 1",
            // + 1 common factors if both numbers even (2)
            "2, 2, 2",
            "4, 10, 2",
            // other
            "4, 4, 3",
            "12, 6, 4",
            "25, 30, 2",
    })
    void naiveApproachTest(int a, int b, int expected) {
        int result = commonFactors(a, b);
        assertEquals(expected, result);

        int result2 = commonFactors2(a, b);
        assertEquals(expected, result2);
    }
}
