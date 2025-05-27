package _2easy.strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com._1easy.hashtables.RomanToInteger.romanToInt;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanToIntegerTest {

    @ParameterizedTest
    @MethodSource("inputProvider")
    void romanToIntTest(String input, int expected) {
        int actual = romanToInt(input);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(

                // start with I
                Arguments.of("I", 1),
                Arguments.of("II", 2),
                Arguments.of("III", 3),
                Arguments.of("IV", 4),
                Arguments.of("IX", 9),

                // start with X
                Arguments.of("X", 10),
                Arguments.of("XX", 20),
                Arguments.of("XXX", 30),
                Arguments.of("XL", 40),
                Arguments.of("XC", 90),

                // start with X - 4 digits
                Arguments.of("XXII", 22),
                Arguments.of("XCIX", 99)
        );
    }
}
