package com._1easy.hashtables;

import java.util.TreeMap;

/**
 * 2418
 * You are given an array of strings names, and an array heights that consists of distinct positive integers. Both arrays are of length n.
 * For each index i, names[i] and heights[i] denote the name and height of the ith person.
 * Return names sorted in descending order by the people's heights.
 * Example 1:
 * <p>
 * Input: names = ["Mary","John","Emma"], heights = [180,165,170]
 * Output: ["Mary","Emma","John"]
 * Explanation: Mary is the tallest, followed by Emma and John.
 * Example 2:
 * <p>
 * Input: names = ["Alice","Bob","Bob"], heights = [155,185,150]
 * Output: ["Bob","Alice","Bob"]
 * Explanation: The first Bob is the tallest, followed by Alice and the second Bob.
 */
public class SortThePeople {

    // 7ms, Beats 92%
    public String[] sortPeople(String[] names, int[] heights) {

        int len = names.length;
        TreeMap<Integer, String> map = new TreeMap<>();

        for (int i = 0; i < len; i++) {
            map.put(heights[i], names[i]);
        }

        String[] answer = new String[len];
        int i = 0;
        for (var val : map.descendingMap().values()) {
            answer[i] = val;
            i++;
        }
        return answer;
    }
}
