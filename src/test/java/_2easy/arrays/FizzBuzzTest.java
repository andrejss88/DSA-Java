package _2easy.arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com._2easy.arrays.FizzBuzz.fizzBuzz;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {

    @ParameterizedTest
    @MethodSource("inputProvider")
    void reverseStringTest(int input, List<String> expected) {
        List<String> actual = fizzBuzz(input);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(3, List.of("1", "2", "Fizz")),
                Arguments.of(5, List.of("1", "2", "Fizz", "4", "Buzz")),
                Arguments.of(15, List.of("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"))
        );
    }
}
