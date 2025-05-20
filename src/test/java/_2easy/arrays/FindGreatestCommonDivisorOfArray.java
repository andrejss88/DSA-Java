package _2easy.arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com._2easy.arrays.FindGreatestCommonDivisorOfArray.findGCD;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindGreatestCommonDivisorOfArray {

    @ParameterizedTest
    @MethodSource("inputProvider")
    void findGreatestCommonDivisorOfArrayTest(int[] input, int expected) {
        int actual = findGCD(input);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(
                        new int[]{2, 5, 6, 9, 10}, 2
                ),
                Arguments.of(
                        new int[]{7, 5, 6, 8, 3}, 1
                ),
                Arguments.of(
                        new int[]{3, 3}, 3
                ),
                Arguments.of(
                        new int[]{6, 7, 9}, 3
                )
        );
    }
}
