package _2easy.arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static com._2easy.arrays.PlusOne.plusOne;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PlusOneTest {

    @ParameterizedTest
    @MethodSource("charArrayProvider")
    void plusOneTest(int[] input, int[] expected) {
        int[] actual = plusOne(input);
        assertArrayEquals(expected, actual,
                String.format("\n Expected: %s, \n Actual: %s", Arrays.toString(expected), Arrays.toString(actual)));
    }

    static Stream<Arguments> charArrayProvider() {
        return Stream.of(
                // simplest - doesn't end with 9
                Arguments.of(
                        new int[]{8},
                        new int[]{9}
                ),
                Arguments.of(
                        new int[]{8, 8},
                        new int[]{8, 9}
                ),
                Arguments.of(
                        new int[]{7, 9, 8},
                        new int[]{7, 9, 9}
                ),

                // ends with 9 - array expansion happens
                Arguments.of(
                        new int[]{9},
                        new int[]{1, 0}
                ),
                Arguments.of(
                        new int[]{9, 9},
                        new int[]{1, 0, 0}
                ),
                Arguments.of(
                        new int[]{9, 9, 9},
                        new int[]{1, 0, 0, 0}
                ),

                // single digit boundaries - no array expansion
                Arguments.of(
                        new int[]{0},
                        new int[]{1}
                ),

                // ends with 9 - no array expansion

                // only need to +1 next digit: 79 ->80; 89 -> 90
                Arguments.of(
                        new int[]{1, 9},
                        new int[]{2, 0}
                ),
                Arguments.of(
                        new int[]{9, 7, 9},
                        new int[]{9, 8, 0}
                ),
                Arguments.of(
                        new int[]{3, 8, 9},
                        new int[]{3, 9, 0}
                ),

                // must +1 several 9s
                Arguments.of(
                        new int[]{9, 7, 9, 9},
                        new int[]{9, 8, 0, 0}
                )
        );
    }
}
