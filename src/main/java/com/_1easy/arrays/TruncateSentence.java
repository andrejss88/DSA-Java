package com._1easy.arrays;

/**
 * 1816
 * A sentence is a list of words that are separated by a single space with no leading or trailing spaces.
 * Each of the words consists of only uppercase and lowercase English letters (no punctuation).
 * <p>
 * For example, "Hello World", "HELLO", and "hello world hello world" are all sentences.
 * You are given a sentence s and an integer k. You want to truncate s such that it contains only the first k words. Return s after truncating it.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "Hello how are you Contestant", k = 4
 * Output: "Hello how are you"
 * Explanation:
 * The words in s are ["Hello", "how" "are", "you", "Contestant"].
 * The first 4 words are ["Hello", "how", "are", "you"].
 * Hence, you should return "Hello how are you".
 */
public class TruncateSentence {

    // 1ms, still? :)
    public String truncateSentenceFaster(String s, int k) {

        var sb = new StringBuilder();
        int count = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ') count++;
            if(count == k) break;

            sb.append(c);
        }

        return sb.toString();
    }

    // 1ms, Beats Runtime 76%
    public String truncateSentence(String s, int k) {

        String[] words = s.split(" ");
        var sb = new StringBuilder();

        for(int i = 0; i < k; i++) {
            String word = words[i];
            sb.append(word).append(' ');
        }
        return sb.toString().stripTrailing();
    }
}
