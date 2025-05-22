package com._1easy.arrays;

public class MaxNumberOfOperationsWithSameScore {


    public static int maxOperations(int[] nums) {

        // before loop - get values first, second, save to sum
        int sum = nums[0] + nums[1];
        // init count = 1 (smallest possible count as per constraint)
        int count = 1;

        // init two pointers first=2, second=3 (we already have first two, so start later)
        int first = 2;
        int second = 3;

        while (second < nums.length) {
            int val1 = nums[first];
            int val2 = nums[second];

            if ((val1 + val2) == sum) {
                count++;
                first += 2;
                second += 2;
            } else {
                break;
            }
        }
        return count;
    }
}
