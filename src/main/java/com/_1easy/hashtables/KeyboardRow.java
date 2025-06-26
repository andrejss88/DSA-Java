package com._1easy.hashtables;

import java.util.*;

/**
 * 500
 * Given an array of strings words, return the words that can be typed using letters of the alphabet on only one row of American keyboard like the image below.
 * Note that the strings are case-insensitive, both lowercased and uppercased of the same letter are treated as if they are at the same row.
 * Example 1:
 * <p>
 * Input: words = ["Hello","Alaska","Dad","Peace"]
 * Output: ["Alaska","Dad"]
 * Explanation:
 * Both "a" and "A" are in the 2nd row of the American keyboard due to case insensitivity.
 * <p>
 * Example 2:
 * Input: words = ["omk"]
 * Output: []
 */
public class KeyboardRow {

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(findWordsFaster(new String[]{"Hello", "Alaska", "Dad", "Peace"}))
        );
    }

    // 0ms, Beats 100% Runtime
    public static String[] findWordsFaster(String[] words) {
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";

        boolean[] freqArr1 = new boolean[26];
        boolean[] freqArr2 = new boolean[26];
        boolean[] freqArr3 = new boolean[26];

        for (char letter : row1.toCharArray()) freqArr1[letter - 'a'] = true;
        for (char letter : row2.toCharArray()) freqArr2[letter - 'a'] = true;
        for (char letter : row3.toCharArray()) freqArr3[letter - 'a'] = true;

        List<String> list = new ArrayList<>();
        boolean[] currentArr = new boolean[26];

        for (String word : words) {
            String loweredWord = word.toLowerCase();
            int firstLetterIndx = loweredWord.charAt(0) - 'a';

            if (freqArr1[firstLetterIndx]) {
                currentArr = freqArr1;
            } else if (freqArr2[firstLetterIndx]) {
                currentArr = freqArr2;
            } else {
                currentArr = freqArr3;
            }

            boolean allMatch = true;
            for (char letter : loweredWord.toCharArray()) {
                int indx = letter - 'a';
                if (!currentArr[indx]) {
                    allMatch = false;
                    break; // go to next word
                }
            }
            if (allMatch) list.add(word);
        }

        String[] answer = new String[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    // 1ms (second best), Beats 38% Runtime
    public static String[] findWords(String[] words) {
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";

        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        Set<Character> set3 = new HashSet<>();

        for (char letter : row1.toCharArray()) set1.add(letter);
        for (char letter : row2.toCharArray()) set2.add(letter);
        for (char letter : row3.toCharArray()) set3.add(letter);

        List<String> list = new ArrayList<>();
        Set<Character> currentSet;
        for (String word : words) {
            String loweredWord = word.toLowerCase();
            char firstLetter = loweredWord.charAt(0);

            if (set1.contains(firstLetter)) {
                currentSet = set1;
            } else if (set2.contains(firstLetter)) {
                currentSet = set2;
            } else {
                currentSet = set3;
            }

            boolean allMatch = true;
            for (char letter : loweredWord.toCharArray()) {
                if (!currentSet.contains(letter)) {
                    allMatch = false;
                    break; // go to next word
                }
            }
            if (allMatch) list.add(word);
        }


        String[] answer = new String[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
