package com._1easy.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 350
 */
public class IntersectionOfTwoArraysII {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }

    // 3ms, Beats 91%
    public static int[] intersect(int[] nums1, int[] nums2) {

        int[] freqArr1 = new int[1001];
        int[] freqArr2 = new int[1001];

        for (int num : nums1) {
            freqArr1[num]++;
        }

        for (int num : nums2) {
            freqArr2[num]++;
        }

        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < freqArr1.length; i++) {
            int valOne = freqArr1[i];
            int valTwo = freqArr2[i];

            // found an intersection
            if (valOne != 0 && valTwo != 0) {
                if (valOne == valTwo) {
                    count = valOne;
                } else {
                    count = Math.min(valOne, valTwo);
                }
            }
            for (int j = 0; j < count; j++) {
                list.add(i);
            }
            count = 0;
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
