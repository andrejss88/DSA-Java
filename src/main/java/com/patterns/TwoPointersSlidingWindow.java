package com.patterns;

public class TwoPointersSlidingWindow {

    public static void main(String[] args) {


    }


    /**
     * Sliding window general pattern:
     * <p>
     * first = 0, second = 1
     * <p>
     * while(second < arr.length) {}  <-- so that 2nd pointer doesn't cause ArrayIndexOutOfBoundsException
     *
     * second++ to advance second pointer (extend window)
     *
     * first++; second = first + 1; to move the window forward and reset its size to minimum
     */

    private static int numIdenticalPairs(int[] nums) {

        int first = 0;
        int second = 1;
        int count = 0;
        int arrEnd = nums.length - 1;

        while (second < nums.length) {
            if (nums[first] == nums[second]) {
                count++;
            }

            if (second != arrEnd) {
                second++;  // advance 2nd pointer and go for another iteration
            } else {
                first++;
                second = first + 1;  // (reset second to be always ahead of first)
            }
        }
        return count;
    }
}
