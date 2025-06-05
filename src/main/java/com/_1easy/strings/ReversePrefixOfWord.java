package com._1easy.strings;

/**
 * 2000 Reverse Prefix of Word
 * Given a 0-indexed string word and a character ch, reverse the segment of word that starts at index 0 and ends at the index of the first occurrence of ch (inclusive).
 * If the character ch does not exist in word, do nothing.*
 * Example 1:
 * <p>
 * Input: word = "abcdefd", ch = "d"
 * Output: "dcbaefd"
 * Explanation: The first occurrence of "d" is at index 3.
 * Reverse the part of word from 0 to 3 (inclusive), the resulting string is "dcbaefd".
 */
public class ReversePrefixOfWord {


    public static void main(String[] args) {
        System.out.println(reversePrefix("abcdefd", 'd'));  // dcbaefd
    }

    public static String reversePrefix(String word, char ch) {
        int charIndex = -1;

        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (letter == ch) {
                charIndex = i;
                break;
            }
        }

        if (charIndex == -1) return word;

        String prefix = word.substring(0, charIndex + 1);
        var sb = new StringBuilder(prefix);
        String reversedPrefix = sb.reverse().toString();
        String restOfWord = word.substring(charIndex + 1);

        return reversedPrefix + restOfWord;
    }
}
