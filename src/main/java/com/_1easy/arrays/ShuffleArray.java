package com._1easy.arrays;

/**
 * 1470
 * Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
 * <p>
 * Return the array in the form [x1,y1,x2,y2,...,xn,yn].
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,5,1,3,4,7], n = 3
 * Output: [2,3,5,4,1,7]
 * Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
 */
public class ShuffleArray {

    // beats 100% runtime, 25% memory (because of 2nd array)
    public static int[] shuffle(int[] nums, int n) {

        int[] shuffled = new int[nums.length];
        // first and last elements stay the same
        shuffled[0] = nums[0];
        shuffled[nums.length - 1] = nums[nums.length - 1];

        int newToLeftSideIndex = 1;   // start from 2nd elem of left side
        int newToRightSideIndex = 2;  // always start by moving 2nd elem to 3rd index of new array

        int originalLeftToRightIndex = 1;
        int actionsLeft = n - 1;
        while (actionsLeft > 0) {

            // fill up left half of new array
            shuffled[newToLeftSideIndex] = nums[n];
            // fill up right half of new array
            shuffled[newToRightSideIndex] = nums[originalLeftToRightIndex];

            // update indexes for "right to left" ops
            n++; // every next element of RIGHT half of OLD array...
            newToLeftSideIndex += 2; // move to n+2 position of NEW array

            // update indexes for "left to right" ops
            originalLeftToRightIndex++; // every next element of LEFT half of NEW array
            newToRightSideIndex += 2;   // move to n+2 position of NEW array

            actionsLeft--;
        }
        return shuffled;
    }


    public static int[] shuffleInPlace(int[] nums, int n) {


        // TODO - implement "in place"

        return nums;
    }
}
