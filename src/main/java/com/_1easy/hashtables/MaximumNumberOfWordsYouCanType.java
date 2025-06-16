package com._1easy.hashtables;

/**
 * 1935
 * <p>
 * There is a malfunctioning keyboard where some letter keys do not work. All other keys on the keyboard work properly.
 * <p>
 * Given a string text of words separated by a single space (no leading or trailing spaces) and a string brokenLetters of all distinct letter keys that are broken, return the number of words in text you can fully type using this keyboard.
 * <p>
 * Example 1:
 * <p>
 * Input: text = "hello world", brokenLetters = "ad"
 * Output: 1
 * Explanation: We cannot type "world" because the 'd' key is broken.
 * Example 2:
 * <p>
 * Input: text = "leet code", brokenLetters = "lt"
 * Output: 1
 * Explanation: We cannot type "leet" because the 'l' and 't' keys are broken.
 */
public class MaximumNumberOfWordsYouCanType {

    // 2ms - Beats 90%
    // Logic: start with the assumption that ALL words can be typed
    // Then reduce their count as we find words with broken letters
    public int canBeTypedWords(String text, String brokenLetters) {

        String[] words = text.split(" ");
        int count = words.length;

        if(brokenLetters.isEmpty()) return count;

        for (String word : words) {
            for (char letter : brokenLetters.toCharArray()) {
                // broken letter present
                if (word.indexOf(letter) != -1) {
                    count--;
                    break;
                }
            }
        }

        return count;
    }
}
