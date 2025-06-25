package com._1easy.arrays;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentEvenElement {

    public static void main(String[] args) {
        System.out.println(mostFrequentEvenFaster(new int[]{0, 1, 2, 2, 4, 4, 1}));
        System.out.println(mostFrequentEvenFaster(new int[]{4, 4, 4, 9, 2, 4}));
        System.out.println(mostFrequentEvenFaster(new int[]{29, 47, 21, 41, 13, 37, 25, 7}));
        System.out.println(mostFrequentEvenFaster(new int[]{0, 1, 2, 0, 0, 0, 2, 4, 4, 1}));
        System.out.println(mostFrequentEvenFaster(new int[]{8154, 9139, 8194, 3346, 5450, 9190, 133, 8239, 4606, 8671, 8412, 6290}));
    }

    // 7ms, Beats 97%
    public static int mostFrequentEvenFaster(int[] nums) {

        int answer = Integer.MAX_VALUE;
        int highestFrequency = -1;
        int[] freqArr = new int[100001];

        for (int num : nums) {
            if (num % 2 == 0) {
                freqArr[num]++;
            }

            int freq = freqArr[num];
            if (freq == 0) continue;

            if (freq > highestFrequency) {
                answer = num;
                highestFrequency = freq;
            } else if (freq == highestFrequency) {
                answer = Math.min(answer, num);
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    // 17ms, Beats 62% Runtime, 78% Memory
    public static int mostFrequentEven(int[] nums) {

        Map<Integer, Integer> evenNums = new HashMap<>();

        for (int num : nums) {
            if (num % 2 == 0) {
                evenNums.put(num, evenNums.getOrDefault(num, 0) + 1);
            }
        }

        int answer = Integer.MAX_VALUE;
        int highestFrequency = -1;
        if (evenNums.isEmpty()) return highestFrequency;

        for (Map.Entry<Integer, Integer> entry : evenNums.entrySet()) {
            int freq = entry.getValue();
            int num = entry.getKey();
            if (freq > highestFrequency) {
                answer = num;
                highestFrequency = freq;
            } else if (freq == highestFrequency) {
                answer = Math.min(answer, num);
            }
        }

        return answer;
    }
}
