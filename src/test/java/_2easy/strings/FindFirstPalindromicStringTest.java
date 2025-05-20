package _2easy.strings;

import com._2easy.strings.FindFirstPalindromicStringInArray;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindFirstPalindromicStringTest {

    @ParameterizedTest
    @MethodSource("inputProvider")
    void isPalindromeTest(String[] words, String expected) {
        String actual = new FindFirstPalindromicStringInArray().firstPalindrome(words);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                // palindromes
                Arguments.of(new String[]{"abc", "car", "ada", "racecar", "cool"}, "ada"),
                Arguments.of(new String[]{"abc", "car", "racecar", "ada", "cool"}, "racecar"),

                // no palindromes
                Arguments.of(new String[]{"def", "ghi"}, ""),
                Arguments.of(new String[]{"", " "}, "")
        );
    }
}
