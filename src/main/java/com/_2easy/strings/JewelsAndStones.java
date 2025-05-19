package com._2easy.strings;

import java.util.HashSet;
import java.util.List;

/**
 * 771
 * You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.
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
