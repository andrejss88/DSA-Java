package com._1easy.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * 1812
 * You are given coordinates, a string that represents the coordinates of a square of the chessboard.
 * Return true if the square is white, and false if the square is black.
 * <p>
 * Example 1:
 * Input: coordinates = "a1"
 * Output: false
 */
public class DetermineColorChessboard {

    static HashSet<Character> whiteOnEven = new HashSet<>(Set.of('a', 'c', 'e', 'g'));
    static HashSet<Character> whiteOnOdd = new HashSet<>(Set.of('b', 'd', 'f', 'h'));

    public static boolean squareIsWhite(String coordinates) {
        char letter = coordinates.charAt(0);
        char number = coordinates.charAt(1);

        // whites on even
        if (number % 2 == 0 && whiteOnEven.contains(letter)) {
            return true;
            // whites on odd
        } else if (!(number % 2 == 0) && whiteOnOdd.contains(letter)) {
            return true;
        }

        // otherwise black
        return false;
    }
}
