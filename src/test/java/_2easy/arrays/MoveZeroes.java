package _2easy.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 283
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Note that you must do this in-place without making a copy of the array.
 * Example 1:
 * <p>
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 */
public class MoveZeroes {

    public static void main(String[] args) {
        moveZeroesFastest(new int[]{0, 1, 0, 3, 12});
        moveZeroesFastest(new int[]{0, 1, 3, 12});
        moveZeroesFastest(new int[]{1, 3, 12});
        moveZeroesFastest(new int[]{0});
        moveZeroesFastest(new int[]{0, 0});
        moveZeroesFastest(new int[]{0, 0, 1});
        moveZeroesFastest(new int[]{1, 0, 0});
        moveZeroesFastest(new int[]{1, 2, 3, 0, 0, 0, 0, 0});
        moveZeroesFastest(new int[]{0, 0, 0, 0, 0, 1, 2, 3});
        moveZeroesFastest(new int[]{0, 0, 0, 1, 2, 3, 0, 0, 0});
        moveZeroesFastest(new int[]{2, 1});
    }

    /**
     * Main idea
     * 1) Find the first zero (place from which we will overwrite everything)
     * 2) Keep looping - overwrite everything with non-zeroes, remember how many (say, 5)
     * 3) Loop again, from position 5 - overwrite all with zeroes
     */
    // 2ms, Beats 81%
    public static void moveZeroesFastest(int[] nums) {

        boolean firstZeroNotFound = true;
        int firstZeroIndex = 0;
        int nonZeroValueCount = 0;

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (firstZeroNotFound && val == 0) {
                firstZeroIndex = i;
                firstZeroNotFound = false;
            }

            if (val != 0) {
                nums[firstZeroIndex++] = val;
                nonZeroValueCount++;
            }
        }

        for (int i = nonZeroValueCount; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    // 4ms, Beats 13% (majority in 2,3ms buckets)
    // Uses extra space
    public static void moveZeroesFaster(int[] nums) {

        List<Integer> valueArr = new ArrayList<>();
        for (int num : nums) {
            if (num != 0) valueArr.add(num);
        }

        int i;
        for (i = 0; i < valueArr.size(); i++) {
            nums[i] = valueArr.get(i);
        }

        for (int indexForZero = i; indexForZero < nums.length; indexForZero++) {
            nums[indexForZero] = 0;
        }
    }

    // 32ms, Beats Runtime 8% only :/
    public static void moveZeroes(int[] nums) {
        int leftIndex = 0;
        int rightIndex = 1;

        while (rightIndex < nums.length) {

            int leftVal = nums[leftIndex];
            int rightVal = nums[rightIndex];

            if (leftVal != 0 && rightVal != 0) {
                leftIndex++;
                rightIndex++;
                // deliberately keeping as separate branch (with same action) for easier debugging if needed
            } else if (leftVal != 0 && rightVal == 0) {
                leftIndex++;
                rightIndex++;
            } else if (leftVal == 0 && rightVal != 0) {
                nums[leftIndex] = rightVal;
                nums[rightIndex] = leftVal;
                leftIndex++;
                rightIndex++;
                // last option - both zeroes
            } else {
                for (int i = rightIndex; i < nums.length; i++) {
                    int nextVal = nums[i];
                    if (nextVal != 0) {
                        nums[leftIndex] = nextVal;
                        nums[i] = leftVal;
                        leftIndex++;
                        rightIndex++;
                        break;
                    }
                    // reached end of arr? all remaining values are zeroes, job done
                    if (i == nums.length - 1) {
//                        System.out.println(Arrays.toString(nums));
                        return;
                    }
                }
            }
        }
//        System.out.println(Arrays.toString(nums));
    }
}
