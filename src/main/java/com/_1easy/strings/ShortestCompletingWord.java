package com._1easy.strings;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class ShortestCompletingWord {

    // so we have                    s
    // licenseFreqArray [0,0,0,0,1,0,2]
    // worrrrdFreqArray [0,0,0,0,1,0,1]
    // System.out.println(Arrays.toString(licenseCountArr));
    // System.out.println(Arrays.toString(licenseCountArr));

    public static void main(String[] args) {

        // according
        System.out.println(
                shortestCompletingWordFaster("GrC8950", new String[]{"measure", "other", "every", "base", "according", "level", "meeting", "none", "marriage", "rest"}));
        // pest
        System.out.println(
                shortestCompletingWordFaster("1s3 456", new String[]{"looks", "pest", "stew", "show"}));

        // steps
        System.out.println(
                shortestCompletingWordFaster("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}));
    }

    // 5ms, beats runtime 63%
    // Not using TreeSet with a custom comparator helps
    public static String shortestCompletingWordFaster(String licensePlate, String[] words) {

        String lowerLicence = licensePlate.toLowerCase();

        int[] licenseCountArr = new int[26];
        for (int i = 0; i < lowerLicence.length(); i++) {
            char c = lowerLicence.charAt(i);
            if (Character.isLetter(c)) {
                int index = c - 'a';
                licenseCountArr[index]++;
            }
        }

        List<String> matchedWords = new ArrayList<>();
        int shortestLength = 1001;
        for (String word : words) {

            int[] wordCountArr = new int[26];
            for (int i = 0; i < word.length(); i++) {
                wordCountArr[word.charAt(i) - 'a']++;
            }

            boolean foundWord = true;
            for (int i = 0; i < licenseCountArr.length; i++) {
                int licenseVal = licenseCountArr[i];
                int wordVal = wordCountArr[i];

                // don't care about missing chars in license plate
                if (licenseVal == 0) continue;
                if (licenseVal > wordVal) {
                    foundWord = false;
                    break;  // word doesn't have a char in license plate
                }
            }
            if (foundWord) {
                matchedWords.add(word);
                shortestLength = Math.min(shortestLength, word.length());
            }
        }
        for (String word : matchedWords) {
            if (word.length() == shortestLength) return word;
        }
        return "no word found";
    }

    // 7ms, Beats Runtime 37% only :/
    public static String shortestCompletingWord(String licensePlate, String[] words) {

        String lowerLicence = licensePlate.toLowerCase();

        int[] licenseCountArr = new int[26];
        for (int i = 0; i < lowerLicence.length(); i++) {
            char c = lowerLicence.charAt(i);
            if (Character.isLetter(c)) {
                int index = c - 'a';
                licenseCountArr[index]++;
            }
        }

        TreeSet<String> matchedWords = new TreeSet<>(Comparator.comparingInt(String::length));
        for (String word : words) {

            int[] wordCountArr = new int[26];
            for (int i = 0; i < word.length(); i++) {
                wordCountArr[word.charAt(i) - 'a']++;
            }

            boolean foundWord = true;
            for (int i = 0; i < licenseCountArr.length; i++) {
                int licenseVal = licenseCountArr[i];
                int wordVal = wordCountArr[i];

                // don't care about missing chars in license plate
                if (licenseVal == 0) continue;
                if (licenseVal > wordVal) {
                    foundWord = false;
                    break;  // word doesn't have a char in license plate
                }
            }
            if (foundWord) {
                matchedWords.add(word);
            }
        }
        return matchedWords.first();
    }
}


