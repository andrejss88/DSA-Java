package com._1easy.hashtables;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * 1832
 * A pangram is a sentence where every letter of the English alphabet appears at least once.
 * <p>
 * Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.
 * Example 1:
 * <p>
 * Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
 * Output: true
 * Explanation: sentence contains at least one of every letter of the English alphabet.
 */
public class CheckIfSentenceIsPangram {

    public static void main(String[] args) {

        System.out.println(checkIfPangramFaster("thequickbrownfoxjumpsoverthelazydog")); // true
        System.out.println(checkIfPangramFaster("uwqohxamknblecdtzpisgvyfjr")); // true
        System.out.println(checkIfPangramFaster("leetcode"));
    }

    // NOT my solution - never saw looping using chars like that :)
    public static boolean checkIfPangramFastest(String sentence) {
        if (sentence.length() < 26) return false;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            // if we fail to find at least one letter in the entire sentence -> not a pangram
            if (sentence.indexOf(ch) < 0) {
                return false;
            }
        }
        return true;
    }

    // 1ms, beats runtime 81%, beats memory 30% (only)
    // when frequencyArr is a non-static class field
    // here I place it INSIDE, because otherwise it must become static (thus shared between method usages)
    public static boolean checkIfPangramFaster(String sentence) {

        char[] frequencyArr = new char[]{
                ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
                ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
                ' ', ' ', ' ', ' ', ' ', ' '
        };

        // adding just this check increases memory beat from 30% to 64%
        if (sentence.length() < 26) return false;

        int i = 0;
        int letterCount = 0;
        while (i < sentence.length()) {
            int charAsInt = sentence.charAt(i) - 97;
            if (frequencyArr[charAsInt] == ' ') {
                // populate the frequency array with the letter. This will happen at most once per unique letter.
                frequencyArr[charAsInt] = sentence.charAt(i);
                letterCount++;
            }
            // we want to stop early as soon as we find all a-z letters at least once
            if (letterCount == 26) {
                return true;
            }
            i++;
        }
        return false;
    }

    static Set<Character> lowercaseLetters = Set.of(
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z'
    );

    // the most realistic solution in a real code base - clean and simple
    // but slow as per LeetCode gods
    // 4ms, runtime beats 26%, memory beats 47%
    public static boolean checkIfPangram(String sentence) {
        Set<Character> sentenceChars = sentence.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        return sentenceChars.containsAll(lowercaseLetters);
    }
}
