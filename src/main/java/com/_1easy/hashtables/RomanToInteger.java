package com._1easy.hashtables;

import java.util.Map;

/**
 * 13
 * Given a roman numeral, convert it to an integer.
 * Example 1:
 * <p>
 * Input: s = "III"
 * Output: 3
 * Explanation: III = 3.
 * Example 2:
 * <p>
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 3:
 * <p>
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class RomanToInteger {

    // to make the solution as fast as possible
    // replace Map with "int char2num(char a)" that switches on roman and returns ints
    static Map<Character, Integer> roman = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );

    // Failed to solve on my own
    public static int romanToInt(String s) {

        int number = 0;

        // loop over all chars 2 at a time,
        // except the LAST one (-1) to avoid ArrayIndexOutOfBounds
        for (int i = 0; i < s.length() - 1; i++) {
            int first = roman.get(s.charAt(i));
            int second = roman.get(s.charAt(i + 1));
            // if X and X -> add first X (do nothing with the other)
            // if V and I -> add V       (do nothing with the other)
            if (first >= second) {
                number += first;
            } else {
                // if I and X - deduct I, we will add X in the next step
                number -= first;
            }
        }

        // add the very last char now and return
        return number + roman.get(s.charAt(s.length() - 1));
    }
}
