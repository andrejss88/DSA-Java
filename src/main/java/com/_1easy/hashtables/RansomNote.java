package com._1easy.hashtables;

import java.util.HashMap;
import java.util.Map;

/**
 * 383
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 * Each letter in magazine can only be used once in ransomNote.
 * Example 1:
 * <p>
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 * <p>
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 * <p>
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 */
public class RansomNote {

    public static void main(String[] args) {
        System.out.println(canConstructFaster("abz", "az"));
    }

    // 2ms, Beats 81%
    // 1ms with add length check at the start
    public static boolean canConstructFaster(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        int[] freqArray = new int[26];
        for (char letter : magazine.toCharArray()) {
            freqArray[letter - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char letter = ransomNote.charAt(i);
            int index = letter - 'a';
            int count = freqArray[index];

            if (count == 0) {
                return false;
            } else {
                freqArray[index]--;
            }
        }

        return true;
    }

    // 10ms, Beats 56%
    public static boolean canConstruct(String ransomNote, String magazine) {

        Map<Character, Integer> map = new HashMap<>();
        for (char letter : magazine.toCharArray()) {
            map.put(letter, map.getOrDefault(letter, 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char letter = ransomNote.charAt(i);
            int count = map.getOrDefault(letter, 0);

            if (count == 0) {
                return false;
            } else {
                map.put(letter, map.get(letter) - 1);
            }
        }

        return true;
    }
}
