package com.patterns;

import java.util.Arrays;

public class PrefixSum {

    // Prefix sum aka:
    // (ac)cumulative sum, running sum, running total, SUM-SO-FAR
    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 4, 5};

        int[] pfx = new int[arr.length];
        pfx[0] = arr[0];  // 1st val is always the same

        // start from 2nd val
        for (int i = 1; i < arr.length; i++) {
            // previous from pfx + current from original
            pfx[i] = pfx[i - 1]+ arr[i];
        }

        // [1,3,6,10,15]
        System.out.println(Arrays.toString(pfx));

    }
}


