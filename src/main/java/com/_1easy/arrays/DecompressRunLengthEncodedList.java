package com._1easy.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DecompressRunLengthEncodedList {

    // no tests
    public static void main(String[] args) {
        var result = decompressRLElist(new int[]{1, 2, 3, 4});  // [2,4,4,4]
        System.out.println(Arrays.toString(result));

        var result2 = decompressRLElistFastest(new int[]{1, 1, 2, 3}); // [1,3,3]
        System.out.println(Arrays.toString(result2));
    }

    // NOT my solution - fastest and shortest
    public static int[] decompressRLElistFastest(int[] nums) {

        // first - determine the output arr size
        // I figured the same
        int arrSize = 0;
        for (int i = 0; i < nums.length; i += 2) {
            arrSize += nums[i];
        }

        int[] result = new int[arrSize];

        int startIdx = 0;
        for (int i = 0; i < nums.length; i += 2) {
            // fill the output arr, from index, to index, with value x
            Arrays.fill(result, startIdx, startIdx + nums[i], nums[i + 1]);
            startIdx += nums[i];
        }
        return result;
    }


    // much better
    // 1ms, beats 86% runtime, 82% memory
    // memory improvement most like because I avoid boxing/unboxing int -> Integer -> int
    public static int[] decompressRLElist(int[] nums) {

        int first = 0;
        int second = 1;

        // iterate once - collect frequencies and values separately
        // also sum up frequencies
        int inputArrLength = nums.length;
        int[] freqArr = new int[inputArrLength / 2];
        int[] valArr = new int[inputArrLength / 2];
        int freqSum = 0;

        int i = 0;
        while (second < inputArrLength) {
            freqArr[i] = nums[first];
            valArr[i] = nums[second];

            freqSum += nums[first];

            i++;
            first += 2;
            second += 2;
        }

        // create newArr with length freqSum
        int[] newArr = new int[freqSum];

        // loop over both freqArr and valArr at the same time
        int newArrIndex = 0;
        for (int freqIndex = 0, valIndex = 0; freqIndex < inputArrLength / 2; freqIndex++, valIndex++) {

            int freqValue = freqArr[freqIndex];
            while (freqValue > 0) {
                // keep populating newArr with vals from valArr
                newArr[newArrIndex] = valArr[valIndex];
                freqValue--;
                newArrIndex++;
            }
        }
        return newArr;
    }

    // Slowest possible solution, because I must do an extra full iteration to convert ArrayList back to int[]
    // 7ms, beats 12% Runtime, Memory 28% (without correct initial capacity, memory beat is 18%)
    public static int[] decompressRLElistSlow(int[] nums) {

        // given an arr of even length, and 9 the biggest digit, then new max length is  nums.length / 2 * 9
        // so we know the max possible length!
        List<Integer> list = new ArrayList<>(nums.length / 2 * 9);

        int first = 0;
        int second = 1;

        while (second < nums.length) {

            int count = nums[first];
            int val = nums[second];
            int j = 0;
            // 2nd loop
            // use first as number of iterations, second as the value
            while (j < count) {
                list.add(val);
                j++;
            }
            first += 2;
            second += 2;
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}
