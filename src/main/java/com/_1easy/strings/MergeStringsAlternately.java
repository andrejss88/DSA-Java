package com._1easy.strings;

/**
 * 1768
 * You are given two strings word1 and word2.
 * Merge the strings by adding letters in alternating order, starting with word1.
 * If a string is longer than the other, append the additional letters onto the end of the merged string.
 * <p>
 * Return the merged string.
 * <p>
 * Input: word1 = "ab", word2 = "pqrs"
 * Output: "apbqrs"
 */
public class MergeStringsAlternately {

    public static void main(String[] args) {
        // "apbqrs"
        System.out.println(mergeAlternately("ab", "pqrs"));
    }

    public static String mergeAlternately(String word1, String word2) {

        String shortestWord = word1.length() < word2.length() ? word1 : word2;
        String longestWord = word1.length() > word2.length() ? word1 : word2;

        var sb = new StringBuilder();
        int i;
        for (i = 0; i < shortestWord.length(); i++) {
            sb.append(word1.charAt(i)).append(word2.charAt(i));
        }
        String remainder = longestWord.substring(i);
        return sb.append(remainder).toString();
    }
}
