package _2easy.strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static com._2easy.strings.ReverseString.reverseString;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ReverseStringTest {

    @ParameterizedTest
    @MethodSource("charArrayProvider")
    void reverseStringTest(char[] input, char[] expected) {
        char[] actual = reverseString(input);
        assertArrayEquals(expected, actual,
                String.format("\n Expected: %s, \n Actual: %s", Arrays.toString(expected), Arrays.toString(actual)));
    }

    static Stream<Arguments> charArrayProvider() {
        return Stream.of(
                Arguments.of(
                        new char[]{'h', 'e', 'l', 'l', 'o'},
                        new char[]{'o', 'l', 'l', 'e', 'h'}
                ),
                Arguments.of(
                        new char[]{'H', 'a', 'n', 'n', 'a', 'h'},
                        new char[]{'h', 'a', 'n', 'n', 'a', 'H'}
                ),
                Arguments.of(
                        new char[]{'0'},
                        new char[]{'0'}
                )
        );
    }
}
