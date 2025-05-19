package _2easy.strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com._2easy.strings.JewelsAndStones.numJewelsInStones3rdAttempt;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JewelsAndStonesTest {

    @ParameterizedTest
    @CsvSource({
            "aA, aAAbbbb, 3",
            "z, ZZ, 0",
            "z, ZzZ, 1",
            "abc, zDfab, 2",
            "abcz, zDfab, 3"
    })
    void jewelsStonesTest(String jewels, String stones, int expectedCount) {
        int actualCount = numJewelsInStones3rdAttempt(jewels, stones);
        assertEquals(expectedCount, actualCount);
    }
}
