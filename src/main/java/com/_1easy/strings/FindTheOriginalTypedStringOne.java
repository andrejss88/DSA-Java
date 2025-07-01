package com._1easy.strings;

/**
 * 3330
 * Alice is attempting to type a specific string on her computer. However, she tends to be clumsy and may press a key for too long, resulting in a character being typed multiple times.
 * Although Alice tried to focus on her typing, she is aware that she may still have done this at most once.
 * You are given a string word, which represents the final output displayed on Alice's screen.
 * Return the total number of possible original strings that Alice might have intended to type.
 * <p>
 * Example 1:
 * Input: word = "abbcccc"
 * Output: 5
 * Explanation:
 * The possible strings are: "abbcccc", "abbccc", "abbcc", "abbc", and "abcccc".
 * <p>
 * Example 2:
 * Input: word = "abcd"
 * Output: 1
 * Explanation:
 * The only possible string is "abcd".
 */
public class FindTheOriginalTypedStringOne {


    // 1ms, Beats 87% Runtime
    public static int possibleStringCount(String word) {

        int answer = 1;

        for(int i = 1; i < word.length(); i++) {
            char previous = word.charAt(i - 1);
            char current = word.charAt(i);

            if(previous == current) answer++;
        }

        return answer;
    }
}