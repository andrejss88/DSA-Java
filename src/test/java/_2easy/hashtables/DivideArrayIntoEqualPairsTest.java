package _2easy.hashtables;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com._1easy.hashtables.DivideArrayIntoEqualPairs.divideArrayFaster;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DivideArrayIntoEqualPairsTest {

    @ParameterizedTest
    @MethodSource("inputProvider")
    void divideArrayTest(int[] input, boolean expected) {
        boolean actual = divideArrayFaster(input);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(

                        new int[]{3, 2, 3, 2, 2, 2}, true
                ),
                Arguments.of(

                        new int[]{1, 2, 3, 4}, false
                ),
                Arguments.of(

                        new int[]{1, 2, 3, 4, 1, 2, 3, 4, 3, 3}, true
                )
        );
    }
}
