package com._1warmup.misc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 2427
 * Given two positive integers a and b, return the number of common factors of a and b.
 * An integer x is a common factor of a and b if x divides both a and b.
 * <p>
 * Example 1:
 * Input: a = 12, b = 6
 * Output: 4
 * Explanation: The common factors of 12 and 6 are 1, 2, 3, 6
 */
public class NumberOfCommonFactors {


    public static List<Integer> findFactors(int a) {
        List<Integer> factors = new ArrayList<>();

        for (int i = 1; i <= a; i++) {
            if (a % i == 0) {
                factors.add(i);
            }
        }
        return factors;
    }

    // Very naive approach
    // 1) find factors for each num separately - save to list
    // 2) Find intersection of 2 lists

    public static int commonFactors(int a, int b) {
        List<Integer> factorsA = new ArrayList<>();
        List<Integer> factorsB = new ArrayList<>();

        for (int i = 1; i <= a; i++) {
            if (a % i == 0) {
                factorsA.add(i);
            }
        }

        for (int i = 1; i <= b; i++) {
            if (b % i == 0) {
                factorsB.add(i);
            }
        }

        // intersection trick
        var commonFactors = new HashSet<>(factorsA);
        commonFactors.retainAll(factorsB);

        System.out.println(commonFactors);
        return commonFactors.size();
    }

    // Better naive (someone else's)
    // - only up to lowest of the two
    // - simply check for common factor at the same time
    public static int commonFactors2(int a, int b) {

        int smallestOfTwo = Math.min(a, b);
        int count = 0;

        for (int i = 1; i <= smallestOfTwo; i++) {
            if (a % i == 0 && b % i == 0) {
                count++;
            }
        }
        return count;
    }
}
