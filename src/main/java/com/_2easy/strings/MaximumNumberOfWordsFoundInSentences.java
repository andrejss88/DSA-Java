package com._2easy.strings;

/**
 * 2114
 * You are given an array of strings sentences, where each sentences[i] represents a single sentence.
 * Return the maximum number of words that appear in a single sentence
 * <p>
 * Input: sentences = ["alice and bob love leetcode", "i think so too", "this is great thanks very much"]
 * Output: 6
 */
public class MaximumNumberOfWordsFoundInSentences {

    public static void main(String[] args) {
        int count = mostWordsFound(new String[]{"alice and bob love leetcode", "i think so too", "this is great thanks very much"});
        int count2 = mostWordsFound(new String[]{"please wait", "continue to fight", "continue to win"});

        System.out.println(count);   // 6
        System.out.println(count2);  // 3

        int count3 = mostWordsFound2(new String[]{"alice and bob love leetcode", "i think so too", "this is great thanks very much"});
        int count4 = mostWordsFound2(new String[]{"please wait", "continue to fight", "continue to win"});

        System.out.println(count3);   // 6
        System.out.println(count4);  // 3
    }

    // works, beats 97% runtime, but beats only 10.88% memory (poor space complexity because of .split(" ")
    // extracting regex " " to a static String helps only a tiny bit
    public static int mostWordsFound(String[] sentences) {

        int maxWordCount = 0;
        for (String sentence : sentences) {
            int wordCount = sentence.split(" ").length;
            if (wordCount > maxWordCount) {
                maxWordCount = wordCount;
            }
        }
        return maxWordCount;
    }

    // given "perfect" constraints, we can count spaces between words,
    // and +1 at the end to get count of words
    public static int mostWordsFound2(String[] sentences) {

        int max = 0;
        for (String sentence : sentences) {
            int spaceCount = 0;
            for (char letter : sentence.toCharArray()) {
                if (letter == ' ') {
                    spaceCount++;
                }
            }
            if (spaceCount > max) {
                max = spaceCount;
            }
        }
        return max + 1;
    }
}
