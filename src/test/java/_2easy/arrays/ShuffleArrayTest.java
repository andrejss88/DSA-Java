package _2easy.arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static com._1easy.arrays.ShuffleArray.shuffle;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ShuffleArrayTest {
    @ParameterizedTest
    @MethodSource("charArrayProvider")
    void plusOneTest(int[] input, int n, int[] expected) {
        int[] actual = shuffle(input, n);
        assertArrayEquals(expected, actual,
                String.format("\n Expected: %s, \n Actual: %s", Arrays.toString(expected), Arrays.toString(actual)));
    }

    static Stream<Arguments> charArrayProvider() {
        return Stream.of(

                Arguments.of(
                        new int[]{2, 5, 1, 3, 4, 7}, 3,
                        new int[]{2, 3, 5, 4, 1, 7}
                ),
                Arguments.of(
                        new int[]{1, 2, 3, 4, 4, 3, 2, 1}, 4,
                        new int[]{1, 4, 2, 3, 3, 2, 4, 1}
                ),
                Arguments.of(
                        new int[]{1, 1, 2, 2}, 2,
                        new int[]{1, 2, 1, 2}
                )
        );
    }
}
