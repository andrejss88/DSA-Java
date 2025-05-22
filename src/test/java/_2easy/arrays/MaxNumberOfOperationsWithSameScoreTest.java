package _2easy.arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com._1easy.arrays.MaxNumberOfOperationsWithSameScore.maxOperations;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxNumberOfOperationsWithSameScoreTest {

    @ParameterizedTest
    @MethodSource("inputProvider")
    void plusOneTest(int[] input, int expected) {
        int actual = maxOperations(input);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 1, 4, 5}, 2),
                Arguments.of(new int[]{1, 5, 3, 3, 4, 1, 3, 2, 2, 3}, 2),
                Arguments.of(new int[]{5, 3}, 1)
        );
    }
}
