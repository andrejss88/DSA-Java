package com._1easy.hashtables;

import java.util.HashSet;
import java.util.Set;

/**
 * 884
 * A sentence is a string of single-space separated words where each word consists only of lowercase letters.
 * A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
 * Given two sentences s1 and s2, return a list of all the uncommon words. You may return the answer in any order.
 * <p>
 * Example 1:
 * Input: s1 = "this apple is sweet", s2 = "this apple is sour"
 * Output: ["sweet","sour"]
 * Explanation:
 * The word "sweet" appears only in s1, while the word "sour" appears only in s2.
 * <p>
 * Example 2:
 * Input: s1 = "apple apple", s2 = "banana"
 * Output: ["banana"]
 */
public class UncommonWordsFromTwoSentences {

    // 2ms, Beats 99%
    public String[] uncommonFromSentences(String s1, String s2) {

        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");

        Set<String> uncommon = new HashSet<>();
        Set<String> removed = new HashSet<>();

        for(String word : words1) {
            if(!uncommon.add(word) || removed.contains(word)) {
                uncommon.remove(word);
                removed.add(word);
            }
        }

        for(String word : words2) {
            if(!uncommon.add(word) || removed.contains(word)) {
                uncommon.remove(word);
                removed.add(word);
            }
        }

        return uncommon.toArray(new String[0]);
    }
}
