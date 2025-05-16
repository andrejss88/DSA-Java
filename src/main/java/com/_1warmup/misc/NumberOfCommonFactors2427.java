package com._1warmup.misc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class NumberOfCommonFactors2427 {

    public static void main(String[] args) {
        System.out.println(findFactors(1));
        System.out.println(findFactors(2));
        System.out.println(findFactors(4));
        System.out.println(findFactors(18));
    }

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
