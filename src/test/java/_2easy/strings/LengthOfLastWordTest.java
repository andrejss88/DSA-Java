package _2easy.strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com._2easy.strings.LengthOfLastWord58.lengthOfLastWord;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LengthOfLastWordTest {

    @ParameterizedTest
    @CsvSource({
            "Hello World, 5",
            "   fly me   to   the moon  , 4",
            "luffy is still joyboy, 6",
    })
    void lastWordTest(String string, int expectedLength) {
        int lastWordLength = lengthOfLastWord(string);
        assertEquals(expectedLength, lastWordLength);
    }
}
