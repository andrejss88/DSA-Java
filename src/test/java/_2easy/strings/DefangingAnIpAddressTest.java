package _2easy.strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com._2easy.strings.DefangingAnIpAddress.defangIPaddr;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefangingAnIpAddressTest {

    @ParameterizedTest
    @MethodSource("inputProvider")
    void ipTest(String input, String expected) {
        String actual = defangIPaddr(input);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of("1.1.1.1", "1[.]1[.]1[.]1"),
                Arguments.of("255.100.50.0", "255[.]100[.]50[.]0")
        );
    }
}
