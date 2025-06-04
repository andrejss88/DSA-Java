package com._1easy.strings;

/**
 * 1662
 * Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.
 * <p>
 * A string is represented by an array if the array elements concatenated in order forms the string.
 * Example 1:
 * <p>
 * Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
 * Output: true
 * Explanation:
 * word1 represents string "ab" + "c" -> "abc"
 * word2 represents string "a" + "bc" -> "abc"
 * The strings are the same, so return true.
 */
public class CheckIfTwoStringArraysAreEquivalent {


    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        var sb1 = new StringBuilder();
        var sb2 = new StringBuilder();

        for (String word : word1) {
            sb1.append(word);
        }

        for (String word : word2) {
            sb2.append(word);
        }

        // 0ms
        return sb1.toString().equals(sb2.toString());

        // 1ms - whatever!
//        return sb1.toString().contentEquals(sb2);
    }
}
