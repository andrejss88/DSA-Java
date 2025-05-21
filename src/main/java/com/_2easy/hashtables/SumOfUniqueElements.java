package com._2easy.hashtables;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1748
 * You are given an integer array nums. The unique elements of an array are the elements that appear exactly once in the array.
 * Return the sum of all the unique elements of nums.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,2]
 * Output: 4
 * Explanation: The unique elements are [1,3], and the sum is 4.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1,1,1,1,1]
 * Output: 0
 * Explanation: There are no unique elements, and the sum is 0
 */
public class SumOfUniqueElements {

    // not my solution - surprisingly fast despite 2 loops,
    // but (probably) only because of specific task constraints - (max length is 100)
    // so even if O(n) complexity, looping over max. length 100 is cheap
    public static int sumOfUniqueFastest(int[] nums) {
        int[] freq = new int[101];
        for (int n : nums) {
            freq[n]++;
        }
        // given {1, 2, 3, 2}
        // we get [0, 1, 2, 1, 0, 0, 0, ...] frequency array
        // One 1 at index 1, Two 2s at index 2, One 3 at index 3...
        // ie map a number from arr1 to its corresponding index in arr2

        // no find all values of "1" (unique) and sum up their indexes (indexes represent the original num)
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (freq[i] == 1) {
                sum += i;
            }
        }

        return sum;
    }

    // beats 75% runtime, 15% memory
    // core improvement - manage everything in a single iteration
    // HashSet's contains(), add() are O(1)
    public static int sumOfUniqueFaster(int[] nums) {

        Set<Integer> set = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();
        int sum = 0;
        // do all three things in a single iteration:
        // detect + remove duplicates + sum up unique
        for (int num : nums) {
            // 2. More duplicates? short-circuit out of the iteration
            if (duplicates.contains(num)) continue;

            if (!set.add(num)) {
                // 1. trick - found 1st duplicate? remove from sum
                sum -= num;
                duplicates.add(num);
                continue;
            }
            sum += num;
        }

        return sum;
    }

    // beats 55% runtime,58% memory
    // core issue - 3 iterations (for(), removeAll(), for() again)
    public static int sumOfUnique(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        Set<Integer> set = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                duplicates.add(num);
            }
        }

        set.removeAll(duplicates);
        int sum = 0;
        for (int num : set) {
            sum += num;
        }

        return sum;
    }

    // asked ChatGpt for this one out of curiosity
    public static int sumOfUniqueWithMap(int[] nums) {

        Map<Integer, Integer> freq = new HashMap<>();
        int sum = 0;
        for (int num : nums) {
//      Returns the value to which the specified key is mapped,
//      or defaultValue if this map contains no mapping for the key.
//      so if we already have a value - return it, if not seen yet - 0
            int count = freq.getOrDefault(num, 0);
            if (count == 0) {
                // First time seeing this number — add to sum
                sum += num;
            } else if (count == 1) {
                // Seen exactly once before — remove from sum
                sum -= num;
            }
            // Update frequency
            freq.put(num, count + 1);
        }
        return sum;
    }
}
