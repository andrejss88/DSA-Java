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
        int[] nums = new int[]{0, 5, 4, 2, 2, 1, 3};
        int[] numFreqArray = new int[10];  // or whatever the constraint for nums[i] max value

        for (int num : nums) {
            int i = num;  // -1 if num[i] starts at 1
            numFreqArray[i] = ++numFreqArray[i];
        }

        System.out.println("Num frequencies: " + Arrays.toString(numFreqArray));
    }
}
