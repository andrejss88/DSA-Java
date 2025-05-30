package com._1easy.hashtables;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1941
 * Given a string s, return true if s is a good string, or false otherwise.
 *
 * A string s is good if all the characters that appear in s have the same number of occurrences (i.e., the same frequency).
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abacbc"
 * Output: true
 * Explanation: The characters that appear in s are 'a', 'b', and 'c'. All characters occur 2 times in s.
 */
public class CheckIfAllCharactersHaveEqualNumberOfOccurrences {

    public static void main(String[] args) {
        System.out.println(areOccurrencesEqualFaster("abacbcd"));
    }

    // 2ms, Runtime Beats 85%
    public static boolean areOccurrencesEqualFaster(String s) {

        int[] freqArr = new int[26];

        for(int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a'; // a -'a' = index 0
            freqArr[index] = ++freqArr[index];
        }

        // get first non-0 value
        int nonZeroVal = 0;
        for(int num : freqArr) {
            if(num != 0) {
                nonZeroVal = num;
                break;
            }
        }

        // we want to know that all non-0 numbers are the same
        for(int num : freqArr) {
            if(num != nonZeroVal && num != 0) {
                return false;
            }
        }
        return true;
    }

    // 8ms with map.getOrDefault(), Runtime beat 43%
    public static boolean areOccurrencesEqual(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            map.put(letter, map.getOrDefault(letter, 0) + 1);
        }
        int anyVal = map.get(s.charAt(0));
        for (int num : map.values()) {
            if (anyVal != num) {
                return false;
            }
        }
        return true;
    }
}
