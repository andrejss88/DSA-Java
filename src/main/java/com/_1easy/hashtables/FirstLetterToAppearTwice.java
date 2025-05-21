package com._1easy.hashtables;

import java.util.HashSet;
import java.util.Set;

/**
 * 2351
 * Given a string s consisting of lowercase English letters, return the first letter to appear twice.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abccbaacz"
 * Output: "c"
 * <p>
 * Example 2:
 * <p>
 * Input: s = "abcdd"
 * Output: "d"
 */
public class FirstLetterToAppearTwice {

    public static void main(String[] args) {
        System.out.println(repeatedCharacter("abccbaacz"));  // c
        System.out.println(repeatedCharacter("abcdd"));  //d
    }

    // no tests - easy enough
    public static char repeatedCharacter(String s) {

        Set<Character> set = new HashSet<>();
        char letter = ' ';
        for (int i = 0; i < s.length(); i++) {
            letter = s.charAt(i);
            if (!set.add(letter)) {
                break; // found first duplicate - exit
            }
        }
        return letter;
    }
}
