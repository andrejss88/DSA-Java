package _2easy.strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com._2easy.strings.ValidPalindrome.isPalindrome;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidPalindromeTest {

    @ParameterizedTest
    @MethodSource("inputProvider")
    void isPalindromeTest(String string, boolean expected) {
        boolean actual = isPalindrome(string);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of("0P", false),
                Arguments.of("A man, a plan, a canal: Panama", true),
                Arguments.of("race a car", false),
                Arguments.of(" ", true),
                Arguments.of("aa", true)
        );
    }
}
