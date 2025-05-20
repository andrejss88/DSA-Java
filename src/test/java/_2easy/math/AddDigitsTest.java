package _2easy.math;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com._1warmup.misc.AddDigits.addDigits;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddDigitsTest {

    @ParameterizedTest
    @CsvSource({
            "38, 2",
            "4595, 5",
            "0, 0",
            "9, 9",
    })
    void addDigitsTest(int input, int expectedResult) {
        int actual = addDigits(input);
        assertEquals(expectedResult, actual);
    }
}
