package _2easy.strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com._2easy.strings.PalindromeNumber.isPalindrome;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PalindromeNumberTest {

    @ParameterizedTest
    @MethodSource("inputProvider")
    void isPalindromeTest(int num, boolean expected) {
        boolean actual = isPalindrome(num);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                // single digit?
                Arguments.of(0, true),
                Arguments.of(9, true),

                Arguments.of(121, true),
                Arguments.of(-121, false),
                Arguments.of(10, false)
        );
    }
}
