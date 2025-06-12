package com.patterns;

import java.util.Arrays;

public class PrefixSum {

    // Prefix sum aka:
    // (ac)cumulative sum, running sum, running total, SUM-SO-FAR
    public static void main(String[] args) {

        // input
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int len = arr.length;

        int[] prefixLeftToRight = new int[len];
        prefixLeftToRight[0] = arr[0];  // 1st val is always the same
        // start from 2nd val
        for (int i = 1; i < len; i++) {
            // previous from pfx + current from original
            prefixLeftToRight[i] = prefixLeftToRight[i - 1] + arr[i];
        }

        // [1,3,6,10,15]
        System.out.println(Arrays.toString(prefixLeftToRight));

        int[] prefixRightToLeft = new int[len];
        int lastIndx = len - 1;


        prefixRightToLeft[0] = arr[lastIndx];
        for (int i = 1, arrIndx = lastIndx - 1; i < len; i++, arrIndx--) {
            prefixRightToLeft[i] = prefixRightToLeft[i - 1] + arr[arrIndx];
        }

        // [5, 9, 12, 14, 15]
        System.out.println(Arrays.toString(prefixRightToLeft));
    }
}


