package _2easy.strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com._1easy.strings.ValidPalindrome.isPalindromeFaster;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidPalindromeTest {

    @ParameterizedTest
    @MethodSource("inputProvider")
    void isPalindromeTest(String string, boolean expected) {
        boolean actual = isPalindromeFaster(string);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                // empty or blank
                Arguments.of("", true),
                Arguments.of(" ", true),

                // simple palindromes
                Arguments.of("aa", true),
                Arguments.of("abccba", true),

                // simple non-palindromes
                Arguments.of("race a car", false),
                Arguments.of("0P", false),

                // complex palindromes
                Arguments.of("A man, a plan, a canal: Panama", true),

                // complex non-palindromes
                Arguments.of("A man, a plan, b canal: Panama", false)
        );
    }
}
