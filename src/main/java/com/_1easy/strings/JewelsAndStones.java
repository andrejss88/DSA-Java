package com._1easy.strings;

import java.util.HashSet;
import java.util.List;

/**
 * 771
 * You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have.
 * Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.
 * Letters are case-sensitive, so "a" is considered a different type of stone from "A".
 * <p>
 * Example 1:
 * Input: jewels = "aA", stones = "aAAbbbb"
 * Output: 3
 * <p>
 * Example 2:
 * Input: jewels = "z", stones = "ZZ"
 * Output: 0
 */
public class JewelsAndStones {

    public static void main(String[] args) {
        System.out.println(numJewelsInStones2ndAttempt("aA", "aAAbbbb"));
    }

    // plain brute force - apparently the fastest
    public static int numJewelsInStones3rdAttempt(String jewels, String stones) {

        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            for (int j = 0; j < jewels.length(); j++) {
                if (stones.charAt(i) == jewels.charAt(j)) {
                    count++;
                }
            }
        }
        return count;
    }

    // 2nd solution - got rid of one useless conversion (stonesAsNums)
    public static int numJewelsInStones2ndAttempt(String jewels, String stones) {
        // still problematic - passes through entire input twice
        // first with chars(), collecting to list takes time, then internally in HashSet
        // this is apparently much faster - conversion to plain char array
//        HashSet<Character> Jset = new HashSet<>();
//        for (char j : jewels.toCharArray()) {
//            Jset.add(j);
//        }

        HashSet<Integer> jewelsAsNums = new HashSet<>(jewels.chars().boxed().toList());

        int stoneAlsoJewelCount = 0;

        for (int i = 0; i < stones.length(); i++) {
            int c = stones.charAt(i);
            if (jewelsAsNums.contains(c)) {
                stoneAlsoJewelCount++;
            }
        }
        return stoneAlsoJewelCount;
    }

    // first solution - simple but slow
    public static int numJewelsInStones(String jewels, String stones) {
        List<Integer> stonesAsNums = stones.chars().boxed().toList();
        HashSet<Integer> jewelsAsNums = new HashSet<>(jewels.chars().boxed().toList());

        int stoneAlsoJewelCount = 0;
        for (int stone : stonesAsNums) {
            if (jewelsAsNums.contains(stone)) {
                stoneAlsoJewelCount++;
            }
        }
        return stoneAlsoJewelCount;
    }
}
