package _2easy.arrays;

import java.util.Arrays;

/**
 * 905
 * Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
 * Return any array that satisfies this condition.
 * Example 1:
 * <p>
 * Input: nums = [3,1,2,4]
 * Output: [2,4,3,1]
 * Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 */
public class SortArrayByParity {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParityTwoPointers(new int[] {1,3})));
    }

    // 0ms, O(1) extra space
    public static int[] sortArrayByParityTwoPointers(int[] nums) {

        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        while (leftIndex < rightIndex) {

            int leftVal = nums[leftIndex];
            int rightVal = nums[rightIndex];

            // if both are EVEN - move only LEFT pointer, continue;
            if (leftVal % 2 == 0 && rightVal % 2 == 0) {
                leftIndex++;
                // if both are ODD - move only RIGHT pointer, continue;
            } else if (leftVal % 2 != 0 && rightVal % 2 != 0) {
                rightIndex--;

                // if left is ODD && right is EVEN - swap them using temp var, move both pointers inward, continue;
            } else if (leftVal % 2 != 0) {
                nums[leftIndex] = rightVal;
                nums[rightIndex] = leftVal;
                leftIndex++;
                rightIndex--;
            }
            // last option - if left is EVEN && right is ODD - move both pointers inward, continue;
            else {
                leftIndex++;
                rightIndex--;
            }
        }
        return nums;
    }

    // 0ms, extra space used
    public int[] sortArrayByParity(int[] nums) {

        int len = nums.length;
        int[] outArr = new int[len];
        int[] oddInts = new int[len];
        int oddCount = 0;
        int evenCount = 0;

        for (int num : nums) {
            if (num % 2 == 0) {
                outArr[evenCount] = num;
                evenCount++;
            } else {
                oddInts[oddCount] = num;
                oddCount++;
            }
        }

        for (int i = 0; i < oddCount; i++) {
            outArr[i + evenCount] = oddInts[i];
        }

        return outArr;
    }
}
