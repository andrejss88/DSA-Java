package com._1easy.hashtables;

import java.util.HashMap;
import java.util.Map;

/**
 * 242
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, using all the original letters exactly once.
 * Example 1:
 * <p>
 * Input: s = "anagram", t = "nagaram"
 * <p>
 * Output: true
 */
public class ValidAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagramWithMap("anagram", "nagaram"));
    }

    // 2ms - Beats 97%
    public static boolean isAnagram(String s, String t) {

        int[] sArr = new int[26];
        for(char letter : s.toCharArray()) sArr[letter - 'a']++;

        int[] tArr = new int[26];
        for(char letter : t.toCharArray()) tArr[letter - 'a']++;

        for(int i = 0; i < 26; i++) {
            if(sArr[i] != tArr[i]) return false;
        }

        return true;
    }

    // 13ms, Beats 31%
    public static boolean isAnagramWithMap(String s, String t) {

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for(char letter : s.toCharArray()) {
            sMap.put(letter, sMap.getOrDefault(letter, 0) + 1);
        }

        for(char letter : t.toCharArray()) {
            tMap.put(letter, tMap.getOrDefault(letter, 0) + 1);
        }

        for(char i = 'a'; i <= 'z'; i++) {
            int sVal = sMap.getOrDefault(i, 0);
            int tVal = tMap.getOrDefault(i, 0);
            if (sVal != tVal) return false;
        }
        return true;
    }
}
