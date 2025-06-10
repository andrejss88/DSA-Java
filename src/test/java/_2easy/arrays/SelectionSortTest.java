package _2easy.arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static com.patterns.sorting.SelectionSort.selectionSort;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SelectionSortTest {

    @ParameterizedTest
    @MethodSource("inputProvider")
    void selectionSortTest(int[] input, int[] expected) {
        int[] actual = selectionSort(input);
        assertArrayEquals(expected, actual,
                String.format("\n Expected: %s, \n Actual: %s", Arrays.toString(expected), Arrays.toString(actual)));
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(
                        new int[]{5, 8, 9, 1, 2}, new int[]{1, 2, 5, 8, 9}
                ),
                Arguments.of(
                        new int[]{5, 8, 2, 1, 9 }, new int[]{1, 2, 5, 8, 9}
                ),
                Arguments.of(
                        new int[]{1, 2}, new int[]{1, 2}
                ),
                Arguments.of(
                        new int[]{1, 3, 5, 7}, new int[]{1, 3, 5, 7}
                ),
                Arguments.of(
                        new int[]{2, 1}, new int[]{1, 2}
                )

        );
    }
}
