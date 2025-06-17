package com.patterns;

import java.util.Arrays;

public class FrequencyArray {

    public static void main(String[] args) {

        // String - only lower case letters
        String s = "abccddd";
        int[] strFreqArray = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';  // given 'a', then 'a' - 'a' -> 0 index
            strFreqArray[index]++;
        }

        System.out.println("Char frequencies: " + Arrays.toString(strFreqArray)); // [1, 1, 2, 3, 0, 0, ...]

        // String - lower and upper
        int lowerLetterOffset = 26;
        int[] freqArr = new int[52];

        for (char letter : "acYZ".toCharArray()) {
            if (Character.isUpperCase(letter)) {
                freqArr[letter - 'A' + lowerLetterOffset]++;
            } else {
                freqArr[letter - 'a']++;
            }
        }
        System.out.println("Char lower/upper:" + Arrays.toString(freqArr));  // [1,0,1....1,1]


        // Number - BEST USED ON CONSTRAINTS 0<=n
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

        // Number - incl. NEGATIVE numbers
        int offset = 10;  // half of freqArr length
        int[] negPosFreqArray = new int[21];

        int[] negPosNums = new int[] {-3,-2,-1,3};
        for (int num : negPosNums) {
            negPosFreqArray[num + offset]++;
        }

        System.out.println("NegPos frequencies: " + Arrays.toString(negPosFreqArray));

    }
}
