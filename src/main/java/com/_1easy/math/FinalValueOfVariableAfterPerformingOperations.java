package com._1easy.math;

/**
 * 2011
 * Given an array of strings operations containing a list of operations,
 * return the final value of X after performing all the operations.
 * <p>
 * ++X and X++ increments the value of the variable X by 1.
 * --X and X-- decrements the value of the variable X by 1.
 * Initially, the value of X is 0.
 * <p>
 * Example:
 * <p>
 * Input: operations = ["X++","++X","--X","X--"]
 * Output: 0
 */
public class FinalValueOfVariableAfterPerformingOperations {

    public static int finalValueAfterOperations(String[] operations) {

        int result = 0;

        for (String operation : operations) {
            switch (operation) {
                case "X++", "++X" -> result++;
                case "X--", "--X" -> result--;
            }
        }
        return result;
    }
}
