package com._2easy.strings;

public class LengthOfLastWord58 {

    // my solution - slow(ish) but clean & simple
    public static int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        return words[words.length - 1].strip().length();
    }

    // the fastest solution is to trim loop backwards until the first space found
    // desirable (efficient) with huge strings

}
