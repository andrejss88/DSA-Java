package com._1easy.arrays;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 26
 * Example 1:
 * <p>
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * Example 2:
 * <p>
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

    // 1ms
    public static int removeDuplicates(int[] nums) {

        int writeIndex = 1;
        int count = 1;

        for (int secondIndex = 1; secondIndex < nums.length; secondIndex++) {
            int currentNum = nums[secondIndex];
            int numBefore = nums[secondIndex - 1];

            // if true - we found a NEW higher value
            // we want to insert it into the 'writeIndex' which moves at its own pace
            if (currentNum != numBefore) {
                nums[writeIndex] = currentNum;
                writeIndex++;
                count++;
            }
        }

        return count;
    }


    public static int removeDuplicatesWithSet(int[] nums) {

        Set<Integer> set = new LinkedHashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int i = 0;
        for (int num : set) {
            nums[i] = num;
            i++;
        }

        return set.size();
    }
}
