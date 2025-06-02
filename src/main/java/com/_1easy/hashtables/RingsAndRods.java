package com._1easy.hashtables;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RingsAndRods {

    public static void main(String[] args) {

        System.out.println(countPoints("B0R0G0R9R0B0G0")); // 1
    }


    // 1ms, Runtime Beats 58%, Memory 69%
    public static int countPoints(String rings) {

        Map<Character, Set<Character>> map = new HashMap<>();

        for (int color = 0, rodNum = 1; rodNum < rings.length(); color += 2, rodNum += 2) {

            char rodChar = rings.charAt(rodNum);
            char colorChar = rings.charAt(color);

            var colorSet = map.getOrDefault(rodChar, new HashSet<>());
            colorSet.add(colorChar);

            map.put(rodChar, colorSet);
        }

        int count = 0;

        for (var setCollection : map.values()) {
            if (setCollection.size() == 3) count++;
        }

        return count;
    }
}
