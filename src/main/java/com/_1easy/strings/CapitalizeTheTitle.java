package com._1easy.strings;

/**
 * 2129
 * You are given a string title consisting of one or more words separated by a single space, where each word consists of English letters. Capitalize the string by changing the capitalization of each word such that:
 * <p>
 * If the length of the word is 1 or 2 letters, change all letters to lowercase.
 * Otherwise, change the first letter to uppercase and the remaining letters to lowercase.
 * Return the capitalized title.
 * <p>
 * Example 1:
 * <p>
 * Input: title = "capiTalIze tHe titLe"
 * Output: "Capitalize The Title"
 * Explanation:
 * Since all the words have a length of at least 3, the first letter of each word is uppercase, and the remaining letters are lowercase.
 */
public class CapitalizeTheTitle {

    // 3ms, Beats 78% Runtime
    public String capitalizeTitle(String title) {
        String[] words = title.toLowerCase().split(" ");
        var sb = new StringBuilder();

        for (String word : words) {
            if (word.length() < 3) {
                sb.append(word).append(" ");
            } else {
                String firstLetter = word.substring(0, 1).toUpperCase();
                String rest = word.substring(1);
                sb.append(firstLetter).append(rest).append(" ");
            }
        }

        return new String(sb).stripTrailing();
    }
}
