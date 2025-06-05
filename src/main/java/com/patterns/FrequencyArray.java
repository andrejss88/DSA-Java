package com.patterns;

import java.util.Arrays;

public class FrequencyArray {

    public static void main(String[] args) {

        // String
        String s = "abccddd";
        int[] strFreqArray = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            int index = letter - 'a';
            strFreqArray[index] = ++strFreqArray[index];
        }

        System.out.println("Char frequencies: " + Arrays.toString(strFreqArray)); // [1, 1, 2, 3, 0, 0, ...]


        // Number
        int[] nums = new int[]{0, 5, 4, 2, 2, 1, 3, 10, 10, 10};
        int[] numFreqArray = new int[11];  // given the constraint of max 10, create arr of length 11
        int[] numFreqArray2 = new int[11];

        // BETTER and simpler than V2 below
        for (int num : nums) {
            numFreqArray[num]++;
        }

        for (int num : nums) {
            numFreqArray2[num] = ++numFreqArray2[num];
        }

        System.out.println("Num frequencies:   " + Arrays.toString(numFreqArray));
        System.out.println("Num frequencies 2: " + Arrays.toString(numFreqArray2));
    }
}
