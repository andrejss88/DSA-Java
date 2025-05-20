package com._2easy.strings;

/**
 * 2108
 * Given an array of strings words, return the first palindromic string in the array. If there is no such string, return an empty string "".
 * A string is palindromic if it reads the same forward and backward.
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["abc","car","ada","racecar","cool"]
 * Output: "ada"
 * Explanation: The first string that is palindromic is "ada".
 * Note that "racecar" is also palindromic, but it is not the first.
 */
public class FindFirstPalindromicStringInArray {

    public String firstPalindrome(String[] words) {

        String foundWord = "";
        for (String word : words) {
            if (isPalindrome(word)) {
                foundWord = word;
                break;
            }
        }
        return foundWord;
    }

    boolean isPalindrome(String word) {

        int left = 0;
        int right = word.length() - 1;
        while (left < right) {

            if (!(word.charAt(left) == word.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
