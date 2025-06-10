package com._1easy.arrays.heap;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class RelativeRanks {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRelativeRanks(new int[]{10, 3, 8, 9, 4})));
        System.out.println(Arrays.toString(findRelativeRanks(new int[]{5,4,3,2,1})));
    }

    // 7ms, beats 93%
    public static String[] findRelativeRanks(int[] score) {

        TreeMap<Integer, Integer> scores = new TreeMap<>();
        for (int i = 0; i < score.length; i++) {
            scores.put(score[i], i);
        }

        String[] output = new String[score.length];
        int firstThree = 3;
        int fourthAndWorse = 4;

        for (Map.Entry<Integer, Integer> entry : scores.descendingMap().entrySet()) {
            int index = entry.getValue();

            if (firstThree > 0) {
                output[index] = switch (firstThree) {
                    case 3 -> "Gold Medal";
                    case 2 -> "Silver Medal";
                    default -> "Bronze Medal";
                };
                firstThree--;
            } else {
                output[index] = String.valueOf(fourthAndWorse++);
            }
        }
        return output;
    }
}
