package com._1easy.hashtables;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 3541
 * You are given a string s consisting of lowercase English letters ('a' to 'z').
 * Your task is to:
 * Find the vowel (one of 'a', 'e', 'i', 'o', or 'u') with the maximum frequency.
 * Find the consonant (all other letters excluding vowels) with the maximum frequency.
 * Return the sum of the two frequencies.
 * <p>
 * Example 1:
 * Input: s = "successes"
 * Output: 6
 * Explanation:
 * The vowels are: 'u' (frequency 1), 'e' (frequency 2). The maximum frequency is 2.
 * The consonants are: 's' (frequency 4), 'c' (frequency 2). The maximum frequency is 4.
 * The output is 2 + 4 = 6.
 */
public class FindMostFrequentVowelAndConsonant {

    public static void main(String[] args) {
        System.out.println(maxFreqSum("successes")); // 6
        System.out.println(maxFreqSum("aeiaeia")); // 3
    }

    // 1ms, Beats 100%, Memory beats 43%
    public static int maxFreqSumFaster(String s) {

        // given "aeiaeia"
        // we will get [3, 0, 0, 0, 2, etc.] (3 'a', 2 'e', etc.)
        int[] freqArray = new int[26];
        for(int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            int index = letter - 'a';
            freqArray[index] = ++freqArray[index];
        }

        int maxVowel = 0;
        int maxConsonant = 0;

        for(int i = 0; i < freqArray.length; i++){
            if(i == 0 || i == 4 || i == 8 || i == 14 || i == 20) {  // vowel index
                maxVowel = Math.max(maxVowel, freqArray[i]);
            } else {
                maxConsonant = Math.max(maxConsonant, freqArray[i]);
            }
        }
        return maxVowel + maxConsonant;
    }

    // 4ms, Runtime Beats 28%, Memory beats 11%
    public static int maxFreqSum(String s) {

        Map<Character, Integer> consonants = new HashMap<>();
        Map<Character, Integer> vowels = new HashMap<>();
        vowels.put('a', 0);
        vowels.put('e', 0);
        vowels.put('i', 0);
        vowels.put('o', 0);
        vowels.put('u', 0);

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);

            if (vowels.containsKey(letter)) {
                vowels.put(letter, vowels.get(letter) + 1);
            } else {
                var val = consonants.get(letter);
                if (val == null) {
                    consonants.put(letter, 1);
                } else {
                    consonants.put(letter, consonants.get(letter) + 1);
                }
            }
        }

        int maxVowelCount = 0;
        for (int count : vowels.values()) {
            maxVowelCount = Math.max(count, maxVowelCount);
        }
        int maxConsonantCount = 0;
        for (int count : consonants.values()) {
            maxConsonantCount = Math.max(count, maxConsonantCount);
        }

        return maxVowelCount + maxConsonantCount;
    }
}
