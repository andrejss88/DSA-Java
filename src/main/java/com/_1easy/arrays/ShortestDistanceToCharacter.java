package com._1easy.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 821
 * Given a string s and a character c that occurs in s, return an array of integers answer where answer.length == s.length and answer[i] is the distance from index i to the closest occurrence of character c in s.
 * The distance between two indices i and j is abs(i - j), where abs is the absolute value function.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "loveleetcode", c = "e"
 * Output: [3,2,1,0,1,0,0,1,2,2,1,0]
 * Explanation: The character 'e' appears at indices 3, 5, 6, and 11 (0-indexed).
 * The closest occurrence of 'e' for index 0 is at index 3, so the distance is abs(0 - 3) = 3.
 * The closest occurrence of 'e' for index 1 is at index 3, so the distance is abs(1 - 3) = 2.
 * For index 4, there is a tie between the 'e' at index 3 and the 'e' at index 5, but the distance is still the same: abs(4 - 3) == abs(4 - 5) = 1.
 * The closest occurrence of 'e' for index 8 is at index 6, so the distance is abs(8 - 6) = 2.
 */
public class ShortestDistanceToCharacter {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(shortestToChar("loveleetcode", 'e')));  // 0
    }

    // 2ms, Beats Runtime 52% (1ms beats 99%)
    public static int[] shortestToChar(String s, char c) {

        int wordLen = s.length();
        int[] distances = new int[wordLen];

        List<Integer> charIndexes = new ArrayList<>();
        for (int i = 0; i < wordLen; i++) {
            if (s.charAt(i) == c) charIndexes.add(i);
        }

        int indexesListSize = charIndexes.size();
        // String contains only one matching char? - Simpler algo
        if (indexesListSize == 1) {
            int charLocation = charIndexes.getFirst();
            for (int i = 0; i < wordLen; i++) {
                distances[i] = Math.abs(i - charLocation);
            }
            // When there are 2+ matching chars
        } else {
            int wordIndx = 0;
            int firstPointer = 0;
            int secondPointer = 1;
            int closest;
            int firstDistance;
            int secondDistance;
            while (wordIndx < wordLen) {

                firstDistance = Math.abs(wordIndx - charIndexes.get(firstPointer));
                secondDistance = Math.abs(wordIndx - charIndexes.get(secondPointer));

                if (firstDistance < secondDistance) {
                    closest = firstDistance;
                } else {
                    closest = secondDistance;
                    if (firstPointer < indexesListSize - 1) firstPointer++;
                    if (secondPointer < indexesListSize - 1) secondPointer++;
                }

                distances[wordIndx] = closest;
                wordIndx++;
            }
        }
        return distances;
    }
}