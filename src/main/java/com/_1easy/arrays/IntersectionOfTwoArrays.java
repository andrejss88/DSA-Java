package com._1easy.arrays;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 349
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 * <p>
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Explanation: [4,9] is also accepted.
 */
public class IntersectionOfTwoArrays {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(intersectionFastest(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(intersectionFastest(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }

    // 2ms, Beats Runtime 96%, Beats Memory 73%
    public static int[] intersectionFastest(int[] nums1, int[] nums2) {

        int[] freqArrOne = new int[1001];
        for (int num : nums1) {
            freqArrOne[num] = ++freqArrOne[num];
        }

        int[] freqArrTwo = new int[1001];
        for(int num : nums2) {
            freqArrTwo[num] = ++freqArrTwo[num];
        }

        List<Integer> common = new ArrayList<>();
        for(int i = 0; i < freqArrOne.length; i++) {
            int valOne = freqArrOne[i];
            int valTwo = freqArrTwo[i];
            if( valOne != 0 && valTwo != 0) {
                common.add(i);
            }
        }

        // now we know size of intersection AND indices for those values
        int[] intersection = new int[common.size()];
        for(int i = 0; i < common.size(); i++) {
            intersection[i] = common.get(i);
        }
        return intersection;

    }

    // 3ms, Beats 53% Runtime, Beats 14% Memory
    // Freq Array + Set solution
    public static int[] intersection(int[] nums1, int[] nums2) {

        int[] freqArr = new int[1001];
        for (int num : nums1) {
            freqArr[num] = ++freqArr[num];
        }

        Set<Integer> intersection = new HashSet<>();

        for (int num : nums2) {
            if (freqArr[num] != 0) {
                intersection.add(num);
            }
        }

        return intersection.stream().mapToInt(Integer::intValue).toArray();
    }

    // 4ms, simplest and cleanest
    // slightly slower than freqArr because of constant-time array access and no hashing overhead
    // OK and practical with larger/unbounded integers
    public static int[] intersectionSlower(int[] nums1, int[] nums2) {

        Set<Integer> setOne = new HashSet<>();
        Set<Integer> interSection = new HashSet<>();

        for(int num: nums1) {
            setOne.add(num);
        }

        for(int num: nums2) {
            if(setOne.contains(num)) {
                interSection.add(num);
            }
        }

        return interSection.stream().mapToInt(Integer::intValue).toArray();
    }

    // 6ms! Slowest!
    // Advantage - single pass by going through both arrays at the same time
    // Major disadvantage - too many .contains() checks, which is much slower than arr[i] checks in practice
    public static int[] intersectionEvenSlowest(int[] nums1, int[] nums2) {

        Set<Integer> setOne = new HashSet<>();
        Set<Integer> setTwo = new HashSet<>();
        Set<Integer> interSection = new HashSet<>();

        int one = 0;
        int two = 0;

        while(one < nums1.length || two < nums2.length) {

            if(one < nums1.length) {
                int val = nums1[one];
                setOne.add(val);
                if(setTwo.contains(val)) interSection.add(val);

                one++;
            }

            if(two < nums2.length) {
                int val = nums2[two];
                setTwo.add(val);
                if(setOne.contains(val)) interSection.add(val);

                two++;
            }
        }
        return interSection.stream().mapToInt(Integer::intValue).toArray();
    }
}