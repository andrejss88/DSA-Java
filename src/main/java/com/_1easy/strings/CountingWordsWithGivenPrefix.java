package com._1easy.strings;

/**
 * 2185
 * You are given an array of strings words and a string pref.
 * Return the number of strings in words that contain pref as a prefix.
 * A prefix of a string s is any leading contiguous substring of s.
 * Example 1:
 * <p>
 * Input: words = ["pay","attention","practice","attend"], pref = "at"
 * Output: 2
 * Explanation: The 2 strings that contain "at" as a prefix are: "attention" and "attend".
 */
public class CountingWordsWithGivenPrefix {

    public static void main(String[] args) {
        System.out.println(prefixCount(new String[]{"pay", "attention", "practice", "attend"}, "at"));
    }

    // 0ms
    public static int prefixCountFaster(String[] words, String pref) {

        int count = 0;
        for (String word : words) {
            // use .startsWith() - checks for length internally
            if (word.startsWith(pref)) count++;
        }
        return count;
    }

    // 1ms - only Beats 35%? most are 0ms?
    public static int prefixCount(String[] words, String pref) {

        int count = 0;

        int len = pref.length();

        for (String word : words) {
            if (word.length() < len) continue;
            String prefix = word.substring(0, len);
            if (prefix.equals(pref)) count++;
        }

        return count;
    }
}
