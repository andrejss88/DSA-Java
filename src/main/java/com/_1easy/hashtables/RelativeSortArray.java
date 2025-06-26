package com._1easy.hashtables;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 1122
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
 * <p>
 * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2. Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.
 * <p>
 * Example 1:
 * <p>
 * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * Output: [2,2,2,1,4,3,3,9,6,7,19]
 */
public class RelativeSortArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6}))
        );
        System.out.println(Arrays.toString(
                relativeSortArray(new int[]{28, 6, 22, 8, 44, 17}, new int[]{22, 28, 8, 6}))
        );
    }

    // 2ms, Beats 68%
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int indx = 0;
        int[] answer = new int[arr1.length];
        for (int num : arr2) {
            int frequency = map.get(num);
            for (int i = 0; i < frequency; i++) {
                answer[indx++] = num;
            }
            map.remove(num);
        }

        // Remainder - move to TreeMap (natural order)
        TreeMap<Integer, Integer> orderedMap = new TreeMap<>(map);
        for (Map.Entry<Integer, Integer> entry : orderedMap.entrySet()) {
            int num = entry.getKey();
            int frequency = entry.getValue();
            for (int i = 0; i < frequency; i++) {
                answer[indx++] = num;
            }
        }

        return answer;
    }
}
