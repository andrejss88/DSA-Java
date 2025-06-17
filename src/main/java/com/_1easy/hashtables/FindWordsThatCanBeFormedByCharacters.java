package com._1easy.hashtables;

import java.util.*;

/**
 * 1160
 * You are given an array of strings words and a string chars.
 * <p>
 * A string is good if it can be formed by characters from chars (each character can only be used once for each word in words).
 * <p>
 * Return the sum of lengths of all good strings in words.
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["cat","bt","hat","tree"], chars = "atach"
 * Output: 6
 * Explanation: The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
 * Example 2:
 * <p>
 * Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * Output: 10
 * Explanation: The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
 */
public class FindWordsThatCanBeFormedByCharacters {

    public static void main(String[] args) {
        System.out.println(countCharactersWithMap(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
    }

    // 6ms, Beats 78% Runtime, Beats 82% Memory
    public static int countCharacters(String[] words, String chars) {

        int lengthSum = 0;
        int[] charCount = new int[26];
        for (char letter : chars.toCharArray()) {
            charCount[letter - 'a']++;
        }

        int[] copy = charCount.clone();
        for (String word : words) {
            charCount = copy.clone(); // reset count array
            int len = word.length();
            int lastIndx = len - 1;
            for (int i = 0; i < len; i++) {
                char letter = word.charAt(i);
                // if letter count is 0 - we ran out of letters, so NOT a good string, go to next word
                if (charCount[letter - 'a'] != 0) {
                    charCount[letter - 'a']--;
                } else {
                    break;
                }
                // guaranteed not to be 0
                if (i == lastIndx) {
                    lengthSum += len;
                }
            }
        }

        return lengthSum;
    }

    // 34ms, Beats 32%
    public static int countCharactersWithMap(String[] words, String chars) {

        int lengthSum = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(char letter : chars.toCharArray()) {
            map.put(letter, map.getOrDefault(letter, 0) + 1);
        }
        Map<Character, Integer> copy;
        for(String word: words) {
            copy = new HashMap<>(map);
            int len = word.length();
            int lastIndx = len - 1;
            for(int i = 0; i < len; i++) {
                char letter = word.charAt(i);
                int left = copy.getOrDefault(letter, 0);
                if(left != 0) {
                    copy.put(letter, copy.get(letter) - 1);  // reduce count by 1
                } else {
                    break;  // out of characters, string is not good
                }
                if(i == lastIndx) {
                    lengthSum += word.length();
                }
            }
        }
        return lengthSum;
    }
}
