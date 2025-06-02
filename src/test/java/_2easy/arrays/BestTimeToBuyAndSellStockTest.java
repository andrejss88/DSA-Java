package _2easy.arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com._1easy.arrays.BestTimeToBuyAndSellStock.maxProfit;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BestTimeToBuyAndSellStockTest {

    @ParameterizedTest
    @MethodSource("inputProvider")
    void stockTest(int[] input, int expected) {
        int actual = maxProfit(input);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(
                        new int[]{2, 4, 1, 2}, 2    // both new low and new high, but max profit is still from previous pair
                ),
                Arguments.of(
                        new int[]{7, 1, 5, 3, 6, 4}, 5
                ),
                Arguments.of(
                        new int[]{7, 6, 4, 3, 1}, 0
                ),
                Arguments.of(
                        new int[]{2, 4, 1}, 2  // new low px shouldn't affect existing profit
                ),
                Arguments.of(
                        new int[]{2, 4, 1, 7}, 6    // both new low and new high, new max profit
                )
        );
    }
}
