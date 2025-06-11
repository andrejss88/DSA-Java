package com._2medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1769
 * You have n boxes. You are given a binary string boxes of length n, where boxes[i] is '0' if the ith box is empty, and '1' if it contains one ball.
 * In one operation, you can move one ball from a box to an adjacent box. Box i is adjacent to box j if abs(i - j) == 1. Note that after doing so, there may be more than one ball in some boxes.
 * Return an array answer of size n, where answer[i] is the minimum number of operations needed to move all the balls to the ith box.
 * Each answer[i] is calculated considering the initial state of the boxes.
 * <p>
 * Example 1:
 * <p>
 * Input: boxes = "110"
 * Output: [1,1,3]
 * Explanation: The answer for each box is as follows:
 * 1) First box: you will have to move one ball from the second box to the first box in one operation.
 * 2) Second box: you will have to move one ball from the first box to the second box in one operation.
 * 3) Third box: you will have to move one ball from the first box to the third box in two operations, and move one ball from the second box to the third box in one operation.
 */
public class MinimumNumberOfOperationsToMoveAllBallsToEachBox {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(minOperations("001011")));
    }

    //i 0,1,2,3,4,5
    // [0,0,1,0,1,1]
    // [11,8,5,4,3,4] -> (2 + 4 + 5), (1 + 3 + 4), (0 + 2 + 3),

    // loop again, and for each index
    // i:0 -> abs(2-i) + abs(4-i) + abs(5-i) = 11
    // i:1 -> abs(2-i) + abs(4-i) + abs(5-i) = 8
    // i:2 -> abs(2-i) + abs(4-i) + abs(5-i) = 5
    // i:3 -> abs(2-i) + abs(4-i) + abs(5-i) =
    //             1   +     1    +   2      = 4

    // 178ms, beats 6%? What?
    public static int[] minOperations(String boxes) {
        char[] charBoxes = boxes.toCharArray();
        int len = charBoxes.length;

        List<Integer> nonZeroIndexes = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (charBoxes[i] == '1') {
                nonZeroIndexes.add(i);  // 2,4,5
            }
        }

        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            int operationsNum = 0;
            for (int nonZeroIndex : nonZeroIndexes) {
                operationsNum += Math.abs(nonZeroIndex - i);
            }

            answer[i] = operationsNum;
        }

        return answer;
    }
}
