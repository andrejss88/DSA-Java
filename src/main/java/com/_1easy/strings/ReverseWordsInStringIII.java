package com._1easy.strings;

/**
 * 557
 * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 */
public class ReverseWordsInStringIII {

    public static void main(String[] args) {
        // "s'teL ekat edoCteeL tsetnoc"
        System.out.println(reverseWordsSlower("Let's take LeetCode contest"));
    }

    // LOL! So much effort in an attempt to speed up
    // And got 8ms, Runtime beats 34%, Memory beats 93%
    // but at least it's a solution that doesn't use SB's reverse(), and SB can be dropped entirely
    public static String reverseWordsSlower(String s) {

        var sb = new StringBuilder();
        int wordStartIndex = 0;
        int wordEndIndex;

        // keep looping until we find the next space
        for (int i = 0; i < s.length(); i++) {
            // for all cases except last word
            if (s.charAt(i) == ' ') {
                // reverse the word: make one step back from ' ' and keep looping backward
                wordEndIndex = i - 1;
                for (int j = wordEndIndex; j >= wordStartIndex; j--) {
                    sb.append(s.charAt(j));
                }
                sb.append(' ');
                wordStartIndex = i + 1;  // move past the ' ' found
            }

            // we reached the end, time to handle last word
            if (i == s.length() - 1) {
                for (int k = i; k >= wordStartIndex; k--) {
                    sb.append(s.charAt(k));
                }
            }
        }
        return sb.toString();
    }

    // 4ms, Runtime beat 86%, Memory Beat 93%
    public static String reverseWords(String s) {

        String[] words = s.split(" ");
        var sb = new StringBuilder();
        var sb2 = new StringBuilder();
        for (String word : words) {
            sb.append(word).reverse().append(" ");
            sb2.append(sb);
            sb.setLength(0);
        }
        return sb2.toString().stripTrailing();
    }
}
