package com._1easy.arrays;

/**
 * 3442
 * You are given a string s consisting of lowercase English letters.
 * Your task is to find the maximum difference diff = freq(a1) - freq(a2) between the frequency of characters a1 and a2 in the string such that:
 * a1 has an odd frequency in the string.
 * a2 has an even frequency in the string.
 * Return this maximum difference.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "aaaaabbc"
 * <p>
 * Output: 3
 * <p>
 * Explanation:
 * <p>
 * The character 'a' has an odd frequency of 5, and 'b' has an even frequency of 2.
 * The maximum difference is 5 - 2 = 3.
 */
public class MaximumDifferenceBetweenEvenAndOddFrequency {

    public static void main(String[] args) {
        System.out.println(maxDifference("aaaaabbc"));
    }

    public static int maxDifference(String s) {

        int[] freqArray = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            freqArray[index]++;
        }

        int maxOdd = 0;
        int minEven = 101;
        for (int num : freqArray) {
            if (num == 0) continue;
            if (num % 2 == 0) {
                minEven = Math.min(minEven, num);
            } else {
                maxOdd = Math.max(maxOdd, num);
            }
        }

        return maxOdd - minEven;
    }
}
