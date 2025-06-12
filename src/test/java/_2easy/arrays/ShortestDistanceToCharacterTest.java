package _2easy.arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static com._1easy.arrays.ShortestDistanceToCharacter.shortestToChar;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ShortestDistanceToCharacterTest {

    @ParameterizedTest
    @MethodSource("inputProvider")
    void distanceTest(String inputStr, char c, int[] expected) {
        int[] actual = shortestToChar(inputStr, c);
        assertArrayEquals(expected, actual,
                String.format("\n Expected: %s, \n Actual: %s", Arrays.toString(expected), Arrays.toString(actual)));
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(
                        "loveleetcode", 'e', new int[]{3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0}
                ),
                Arguments.of(
                        "abba", 'b', new int[]{1, 0, 0, 1}
                ),
                Arguments.of(
                        "baba", 'b', new int[]{0, 1, 0, 1}
                ),
                Arguments.of(
                        "ee", 'e', new int[]{0, 0}
                ),
                Arguments.of(
                        "e", 'e', new int[]{0}
                ),
                Arguments.of(
                        "love", 'e', new int[]{3, 2, 1, 0}
                ),
                Arguments.of(
                        "elov", 'e', new int[]{0, 1, 2, 3}
                ),
                Arguments.of(
                        "elove", 'e', new int[]{0, 1, 2, 1, 0}
                )
        );
    }
}
