package com._1easy.hashtables;

import java.util.*;

/**
 * 387
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 * <p>
 * Example 1:
 * Input: s = "leetcode"
 * Output: 0
 * Explanation:
 * The character 'l' at index 0 is the first character that does not occur at any other index.
 * <p>
 * Example 2:
 * Input: s = "loveleetcode"
 * Output: 2
 */
public class FirstUniqueCharacterInAString {

    public static void main(String[] args) {
        System.out.println(firstUniqCharSlower("leetcode"));
        System.out.println(firstUniqCharSlower("loveleetcode"));
    }

    // NOT my solution - should've gotten this one
    // 6ms, Beats 82%
    public int firstUniqCharFastest(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    // 9ms, Beats 58% Runtime, Beats 96% Memory, O(n)
    public static int firstUniqChar(String s) {

        int[] freqArr = new int[26];
        for (char letter : s.toCharArray()) {
            freqArr[letter - 'a']++;
        }

        Set<Character> unique = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            int num = freqArr[i];
            if (num == 1) {
                unique.add((char) (i + 'a'));
            }
        }

        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (unique.contains(letter)) {
                index = i;
                break;
            }
        }

        return index;
    }

    /**
     * Even though both are O(n), the second one is significantly slower in real life because:
     * <p>
     * - More objects
     * - More memory allocations
     * - More method calls
     * - More hash computations
     * - Less efficient CPU cache use
     */
    // 38ms, beats 11% :)), O(n) too but much slower
    public static int firstUniqCharSlower(String s) {
        // given leetcode
        // l -> [0]
        // e -> [1,2,7]
        // ...
        Map<Character, List<Integer>> map = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            List<Integer> indexList = map.getOrDefault(letter, new ArrayList<>());
            indexList.add(i);

            map.put(letter, indexList);
        }

        for (List<Integer> indexList : map.values()) {
            if (indexList.size() == 1) return indexList.getFirst();
        }

        return -1;
    }

    // NOT my solution - 24ms (internally two loops)
    public static int firstUniqCharSimple(String s) {
        for (char ch : s.toCharArray()) {
            int firstFoundIndex = s.indexOf(ch);
            int lastFoundIndex = s.lastIndexOf(ch);
            if (firstFoundIndex == lastFoundIndex) {
                return firstFoundIndex;
            }
        }
        return -1;
    }

    // NOT my solution
    // 7ms, Beats 61%
    public int firstUniqCharFaster(String s) {

        int ans = Integer.MAX_VALUE;
        // max 26 iterations
        for (char c = 'a'; c <= 'z'; c++) {
            // indexOf will return first index of alphabet and lastIndexOf will return last index
            // if both are equal then it has occurred only once.
            // but our answer is lowest index
            int firstIndex = s.indexOf(c);
            int lastIndex = s.lastIndexOf(c);
            if (firstIndex != -1 && firstIndex == lastIndex) {
                ans = Math.min(ans, firstIndex);
            }
        }

        // If ans remains Integer.MAX_VALUE then there is no unique character
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
