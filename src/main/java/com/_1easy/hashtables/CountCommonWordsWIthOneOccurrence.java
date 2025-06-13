package com._1easy.hashtables;

import java.util.HashSet;
import java.util.Set;

/**
 * 2085
 * <p>
 * Given two string arrays words1 and words2, return the number of strings that appear exactly once in each of the two arrays.
 * <p>
 * Example 1:
 * <p>
 * Input: words1 = ["leetcode","is","amazing","as","is"], words2 = ["amazing","leetcode","is"]
 * Output: 2
 * Explanation:
 * - "leetcode" appears exactly once in each of the two arrays. We count this string.
 * - "amazing" appears exactly once in each of the two arrays. We count this string.
 * - "is" appears in each of the two arrays, but there are 2 occurrences of it in words1. We do not count this string.
 * - "as" appears once in words1, but does not appear in words2. We do not count this string.
 * Thus, there are 2 strings that appear exactly once in each of the two arrays.
 */
public class CountCommonWordsWIthOneOccurrence {

    // 3ms, Beats 100%
    public static int countWords(String[] words1, String[] words2) {

        Set<String> set1 = new HashSet<>();
        Set<String> removed = new HashSet<>();

        for(String word : words1) {
            if(!set1.add(word) || removed.contains(word)) {
                set1.remove(word);
                removed.add(word);
            }
        }

        Set<String> common = new HashSet<>();
        for(String word : words2) {
            if(set1.contains(word) && !removed.contains(word)) {  // protects against dupes in 1st set
                if(!common.add(word) || removed.contains(word)) {
                    common.remove(word);
                    removed.add(word);
                }
            }
        }

        return common.size();
    }
}
