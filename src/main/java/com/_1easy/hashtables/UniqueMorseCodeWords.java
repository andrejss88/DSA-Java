package com._1easy.hashtables;

import java.util.HashSet;
import java.util.Set;

/**
 * 804
 * Given an array of words, transform words into morse and count UNIQUE morse words (transformations)
 */
public class UniqueMorseCodeWords {

    // no tests
    public static void main(String[] args) {
        int result = uniqueMorseRepresentations(new String[]{"a"});
        System.out.println(result);
    }

    static String[] morseLetters = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
            "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-",
            "...-", ".--", "-..-", "-.--", "--.."};

    // 2ms, beats 95% runtime, 81% memory
    public static int uniqueMorseRepresentations(String[] words) {

        Set<String> morseWords = new HashSet<>();
        var sb = new StringBuilder();

        for (String word : words) {
            for (int j = 0; j < word.length(); j++) {
                // trick: casting (int) 'a' will give 97, and 97-97 gives us the corresponding index in morseLetter array
                // do this for every letter
                sb.append(morseLetters[(int) word.charAt(j) - 97]);
            }

            morseWords.add(sb.toString());
            sb.setLength(0);  // flush the StringBuilder
        }

        return morseWords.size();
    }
}
