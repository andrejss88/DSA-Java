package com._1easy.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DecompressRunLengthEncodedList {

    public static void main(String[] args) {
        var result = decompressRLElist(new int[]{1, 2, 3, 4});  // [2,4,4,4]
        System.out.println(Arrays.toString(result));

        var result2 = decompressRLElist(new int[]{1, 1, 2, 3}); // [1,3,3]
        System.out.println(Arrays.toString(result2));
    }

    // Slowest possible solution, because I must do an extra full iteration to convert ArrayList back to int[]
    public static int[] decompressRLElist(int[] nums) {

        List<Integer> list = new ArrayList<>(100);

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
