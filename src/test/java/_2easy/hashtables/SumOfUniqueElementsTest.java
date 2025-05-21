package _2easy.hashtables;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com._2easy.hashtables.SumOfUniqueElements.sumOfUniqueFastest;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumOfUniqueElementsTest {

    @ParameterizedTest
    @MethodSource("inputProvider")
    void sumOfUniqueTest(int[] input, int expected) {
        int actual = sumOfUniqueFastest(input);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(
                        // 10 + 8 + 7
                        new int[]{10, 6, 9, 6, 9, 6, 8, 7}, 25
                ),
                Arguments.of(// 1 + 2 + 3 - 2
                        new int[]{1, 2, 3, 2}, 4
                ),
                Arguments.of(
                        new int[]{1, 1, 1, 1, 1}, 0
                ),
                Arguments.of(
                        new int[]{1, 2, 3, 4, 5}, 15
                ),
                Arguments.of(
                        new int[]{10}, 10
                )
        );
    }
}
