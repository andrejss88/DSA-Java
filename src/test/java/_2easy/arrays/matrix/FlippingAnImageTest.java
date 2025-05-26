package _2easy.arrays.matrix;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static com._1easy.arrays.FindGreatestCommonDivisorOfArray.findGCD;
import static com._1easy.arrays.matrix.FlippingAnImage.flipAndInvertImage;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlippingAnImageTest {

    @ParameterizedTest
    @MethodSource("inputProvider")
    void flippingAnImageTest(int[][] input, int[][] expected) {
        int[][] actual = flipAndInvertImage(input);
        assertArrayEquals(expected, actual,
                String.format("\n Expected: %s, \n Actual: %s", Arrays.deepToString(expected), Arrays.deepToString(actual)));
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(
                        new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}},
                        new int[][]{{1, 0, 0}, {0, 1, 0}, {1, 1, 1}}
                ),
                Arguments.of(
                        new int[][]{{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}},
                        new int[][]{{1, 1, 0, 0}, {0, 1, 1, 0}, {0, 0, 0, 1}, {1, 0, 1, 0}}
                )

        );
    }
}
