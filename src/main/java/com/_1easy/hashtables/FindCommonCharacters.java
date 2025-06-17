package com._1easy.hashtables;

import java.util.ArrayList;
import java.util.List;

/**
 * 1002
 * Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). You may return the answer in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["bella","label","roller"]
 * Output: ["e","l","l"]
 * Example 2:
 * <p>
 * Input: words = ["cool","lock","cook"]
 * Output: ["c","o"]
 */
public class FindCommonCharacters {

    public static void main(String[] args) {
        System.out.println(commonChars(new String[]{"acabcddd", "bcbdbcbd", "baddbadb", "cbdddcac", "aacbcccd", "ccccddda", "cababaab", "addcaccd"}));
        System.out.println(commonChars(new String[]{"cool", "lock", "cook"}));
        System.out.println(commonChars(new String[]{"bella", "label", "roller"}));
    }

    public static List<String> commonChars(String[] words) {
        int wordCount = words.length;
        int[][] matrix = new int[wordCount][26];

        for (int i = 0; i < wordCount; i++) {
            int[] freqArr = new int[26];
            for (char letter : words[i].toCharArray()) {
                freqArr[letter - 'a']++;
            }
            matrix[i] = freqArr;
        }

        int numRows = matrix.length;
        int numCols = matrix[0].length;

        List<String> answer = new ArrayList<>();

        for (int col = 0; col < numCols; col++) {
            int firstVal = matrix[0][col];
            if (firstVal == 0) continue;
            int valSum = firstVal;
            for (int row = 1; row < numRows; row++) {
                int otherVal = matrix[row][col];
                if (otherVal == 0) {
                    valSum = 0;
                    break;
                }
                valSum += otherVal;
            }
            if (valSum >= wordCount) {
                int letterCount = valSum / wordCount;
                char letter = (char) (col + 'a');
                for (int i = 0; i < letterCount; i++) answer.add(String.valueOf(letter));
            }
        }

        return answer;
    }
}
