package com._1easy.hashtables;

import java.util.HashSet;
import java.util.Set;

/**
 * 1684
 * You are given a string allowed consisting of distinct characters and an array of strings words. A string is consistent if all characters in the string appear in the string allowed.
 * Return the number of consistent strings in the array words.
 * <p>
 * Example 1:
 * <p>
 * Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
 * Output: 2
 * Explanation: Strings "aaab" and "baa" are consistent since they only contain characters 'a' and 'b'.
 */
public class CountNumberOfConsistentStrings {

    public static void main(String[] args) {

        System.out.println(countConsistentStringsFaster("cad", new String[]{"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"}));  // 4
        System.out.println(countConsistentStringsFaster("ab", new String[]{"ad", "bd", "aaab", "baa", "badab"}));  // 2
        System.out.println(countConsistentStringsFaster("abc", new String[]{"a", "b", "c", "ab", "ac", "bc", "abc"}));  // 7
    }

    // Reasonable solution using the expected "Hash Something"
    // 12ms, Runtime beats 65%, Memory beats 84%
    public static int countConsistentStrings(String allowed, String[] words) {

        Set<Character> allowedChars = new HashSet<>();
        for (char c : allowed.toCharArray()) {
            allowedChars.add(c);
        }

        int count = 0;
        NEXT_WORD:
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                char letter = word.charAt(i);
                if (!allowedChars.contains(letter)) {
                    continue NEXT_WORD; // not a word we want - move to the next one
                }
            }
            count++; // got this far? Word is consistent
        }
        return count;
    }

    // 5ms, Runtime Beats 95%, Memory 73%
    public static int countConsistentStringsFaster(String allowed, String[] words) {

        char[] allowedArr = new char[]{
                ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
                ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
                ' ', ' ', ' ', ' ', ' ', ' '
        };

        for (int i = 0; i < allowed.length(); i++) {
            char letter = allowed.charAt(i);
            allowedArr[letter - 'a'] = letter;
        }

        int count = 0;
        NEXT_WORD:
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                // from any char, subtract 'a' (97) to get an index for the array
                // e.g. 'a' (97) - 'a' (97) = 0 index
                // e.g. 'b' (98) - 'a' (97) = 1 index
                int charAsInt = word.charAt(i) - 'a';
                if (allowedArr[charAsInt] == ' ') {
                    continue NEXT_WORD;
                }
            }
            count++;
        }
        return count;
    }

    // 15ms, Runtime Beats 30%, Memory beats 73%
    // SLOWER because indexOf() uses a loop, so O(n), but a set.contains() is O(1)
    public static int countConsistentStringsSlower(String allowed, String[] words) {
        int count = 0;
        NEXT_WORD:
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                char letter = word.charAt(i);
                // use "str".indexOf() instead of set.contains()
                if (allowed.indexOf(letter) == -1) {
                    continue NEXT_WORD;
                }
            }
            count++;
        }
        return count;
    }
}
