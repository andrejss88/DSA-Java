package com._1easy.strings;

/**
 * 14 Longest Common Prefix
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * <p>
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefixFastest(new String[]{"flower", "flow", "flight"}));
    }

    // 0ms, not my solution
    public static String longestCommonPrefixFastest(String[] strs) {

        String prefix = strs[0];
        for (int index = 1; index < strs.length; index++) {
            while (strs[index].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    // 1ms (2nd fastest), Beats 64% Runtime
    public static String longestCommonPrefix(String[] strs) {

        char[][] matrix = new char[strs.length][201];

        for (int i = 0; i < strs.length; i++) {
            String word = strs[i];
            if (word.isEmpty()) return "";
            char[] letters = word.toCharArray();
            for (int j = 0; j < letters.length; j++) {
                char letter = letters[j];
                matrix[i][j] = letter;
            }
        }
        // then go through matrix COLUMN first
        char nul = '\u0000';
        var sb = new StringBuilder();
        int numRows = matrix.length;
        int numCols = matrix[0].length;

        OUTER:
        for (int col = 0; col < numCols; col++) {
            char firstWordLetter = matrix[0][col];
            if (firstWordLetter == nul) break;
            for (int row = 1; row < numRows; row++) {
                char nextWordLetter = matrix[row][col];
                if (firstWordLetter != nextWordLetter) break OUTER;
            }
            // if we get this far - no break happened, append letter
            sb.append(firstWordLetter);
        }
        return sb.toString();
    }
}
