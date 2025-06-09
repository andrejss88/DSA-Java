package _2easy.arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static com._1easy.arrays.SquaresOfSortedArray.sortedSquaresFaster;
import static com.patterns.sorting.SortingAlgos.selectionSort;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SquaresOfSortedArrayTest {

    @ParameterizedTest
    @MethodSource("inputProvider")
    void selectionSortTest(int[] input, int[] expected) {
        int[] actual = sortedSquaresFaster(input);
        assertArrayEquals(expected, actual,
                String.format("\n Expected: %s, \n Actual: %s", Arrays.toString(expected), Arrays.toString(actual)));
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(
                        new int[]{-5, -3, -2, -1}, new int[]{1, 4, 9, 25}
                ),
                Arguments.of(
                        new int[]{1, 2, 3, 5}, new int[]{1, 4, 9, 25}
                ),
                Arguments.of(
                        new int[]{-4, -1, 0, 3, 10}, new int[]{0, 1, 9, 16, 100}
                ),
                Arguments.of(
                        new int[]{-7, -3, 2, 3, 11}, new int[]{4, 9, 9, 49, 121}
                ),
                Arguments.of(
                        new int[]{-22, -3, 0, 0, 1}, new int[]{0, 0, 1, 9, 484}
                ),
                Arguments.of(
                        new int[]{-22, -3, 0, 0, 1, 2}, new int[]{0, 0, 1, 4, 9, 484}
                )
        );
    }
}
