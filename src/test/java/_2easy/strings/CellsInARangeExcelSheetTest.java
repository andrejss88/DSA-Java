package _2easy.strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com._1easy.strings.CellsInARangeExcelSheet.cellsInRange;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;

public class CellsInARangeExcelSheetTest {

    @ParameterizedTest
    @MethodSource("inputProvider")
    void cellsInaRangeTest(String input, List<String> expected) {
        List<String> actual = cellsInRange(input);
        assertLinesMatch(expected, actual, "\nExpected: " + expected + "\nActual: " + actual);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of("K1:L2", List.of("K1", "K2", "L1", "L2")),
                Arguments.of("A1:F1", List.of("A1", "B1", "C1", "D1", "E1", "F1"))
        );
    }
}
