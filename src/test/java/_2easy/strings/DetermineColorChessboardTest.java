package _2easy.strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com._1easy.strings.DetermineColorChessboard.squareIsWhite;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DetermineColorChessboardTest {

    @ParameterizedTest
    @CsvSource({
            "a1, false",
            "c5, false",
            "h3, true",
            "g4, true",
    })
    void chessboardTest(String coordinates, boolean expectedResult) {
        boolean actual = squareIsWhite(coordinates);
        assertEquals(expectedResult, actual);
    }
}
