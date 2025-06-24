package com._1easy.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 * <p>
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 * <p>
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 */
public class TwoSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSumFaster(new int[]{2, 5, 5, 11}, 10)));
        System.out.println(Arrays.toString(twoSumFaster(new int[]{3, 3}, 6)));
    }

    // 2ms, beats 98%, O(n)
    public static int[] twoSumFaster(int[] nums, int target) {

        // (num, index)
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            int otherNum = target - currentNum;
            if (map.containsKey(otherNum)) {
                ans[0] = map.get(otherNum);
                ans[1] = i;
                break;
            }
            map.put(currentNum, i);
        }

        return ans;
    }


    // 44ms, beats 36%, O(n^2)
    public static int[] twoSum(int[] nums, int target) {

        int len = nums.length;
        int[] ans = new int[2];

        OUTER:
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int valOne = nums[i];
                int valTwo = nums[j];

                if (valOne + valTwo == target) {
                    ans[0] = i;
                    ans[1] = j;
                    break OUTER;
                }
            }
        }

        return ans;
    }

    // 319 ms, Beats 5% :))
    public static int[] twoSumMuchSlower(int[] nums, int target) {

        // loop, save key-val (index, num)
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            int otherNum = target - currentNum;
            if (map.containsValue(otherNum)) {
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if (entry.getValue() == otherNum) {
                        ans[0] = entry.getKey();
                    }
                }
                ans[1] = i;
                break;
            }
            map.put(i, currentNum);
        }

        return ans;
    }
}
