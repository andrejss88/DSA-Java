package com._1easy.strings;

/**
 * 1528
 * Shuffle string letters according to values of int[] indices
 */
public class ShuffleString {

    // no tests, easy enough
    public static void main(String[] args) {

        System.out.println(restoreString("codeleet", new int[]{4, 5, 6, 7, 0, 2, 1, 3}));  // leetcode
        System.out.println(restoreString("abc", new int[]{0, 1, 2}));                       // abc
    }

    // 1ms, Beats 69% runtime, 40% memory
    // Only thing that makes it faster (0ms) in LeetCode is
    // changing String.valueOf(str) -> new String(str);
    public static String restoreString(String s, int[] indices) {

        char[] str = new char[indices.length];

        for (int i = 0; i < indices.length; i++) {
            int newIndex = indices[i];
            str[newIndex] = s.charAt(i);
        }

        return String.valueOf(str);
    }
}
