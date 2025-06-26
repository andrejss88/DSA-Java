package com._1easy.strings;

public class RotateString {

    public static void main(String[] args) {
        System.out.println(rotateString("abcde", "cdeab"));
        System.out.println(rotateString("abcde", "abced"));
    }

    // not my solution
    // when you concatenate a string with itself (s + s), it contains all possible rotations of the original string.
    // For example, if s = "abcde", then s + s = "abcdeabcde" contains all rotations: "abcde", "bcdea", "cdeab", "deabc", "eabcd".
    public static boolean rotateStringFaster(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        return (s + s).contains(goal);
    }

    // 1ms, second best, Beats 23% only because most are 0ms
    public static boolean rotateString(String s, String goal) {

        if (s.equals(goal)) return true;

        var sb = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            String slice = s.substring(0, i);
            String rest = s.substring(i);
            String rotated = new String(sb.append(rest).append(slice));

            if (rotated.equals(goal)) return true;
            sb.setLength(0);
        }

        return false;
    }
}
