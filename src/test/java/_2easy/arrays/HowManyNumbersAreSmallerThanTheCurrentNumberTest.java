package _2easy.arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static com._1easy.arrays.MaxNumberOfOperationsWithSameScore.maxOperations;
import static com._1easy.hashtables.HowManyNumbersAreSmallerThanTheCurrentNumber.smallerNumbersThanCurrent2;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HowManyNumbersAreSmallerThanTheCurrentNumberTest {

    @ParameterizedTest
    @MethodSource("inputProvider")
    void plusOneTest(int[] input, int[] expected) {
        int[] actual = smallerNumbersThanCurrent2(input);
        assertArrayEquals(expected, actual,
                String.format("\n Expected: %s, \n Actual: %s", Arrays.toString(expected), Arrays.toString(actual)));
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(
                        new int[]{0, 8, 9, 7, 0}, new int[]{0, 3, 4, 2, 0}
                ),
                Arguments.of(
                        new int[]{5, 0, 10, 0, 10, 6}, new int[]{2, 0, 4, 0, 4, 3}
                ),
                Arguments.of(
                        new int[]{8, 1, 2, 2, 3}, new int[]{4, 0, 1, 1, 3}
                ),
                Arguments.of(
                        new int[]{6, 5, 4, 8}, new int[]{2, 1, 0, 3}
                ),
                Arguments.of(
                        new int[]{7, 7, 7, 7}, new int[]{0, 0, 0, 0}
                )
        );
    }
}
