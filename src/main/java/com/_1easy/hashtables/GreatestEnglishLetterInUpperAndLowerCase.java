package com._1easy.hashtables;

/**
 * 2309
 * Given a string of English letters s, return the greatest English letter which occurs as both a lowercase and uppercase letter in s. The returned letter should be in uppercase. If no such letter exists, return an empty string.
 * <p>
 * An English letter b is greater than another letter a if b appears after a in the English alphabet.
 * Example 1:
 * <p>
 * Input: s = "lEeTcOdE"
 * Output: "E"
 * Explanation:
 * The letter 'E' is the only letter to appear in both lower and upper case
 */
public class GreatestEnglishLetterInUpperAndLowerCase {

    public static void main(String[] args) {
        System.out.println(greatestLetter("lEeTcOdE"));
    }

    // 4ms, Beats 80%
    public static String greatestLetter(String s) {

        int offset = 26;
        int[] freqArr = new int[52];

        for (char letter : s.toCharArray()) {
            if (Character.isUpperCase(letter)) {
                freqArr[letter - 'A' + offset]++;
            } else {
                freqArr[letter - 'a']++;
            }
        }


        for (int lower = 25, upper = freqArr.length - 1; lower >= 0; lower--, upper--) {
            int lowerVal = freqArr[lower];
            int higherVal = freqArr[upper];
            if (lowerVal != 0 && higherVal != 0) {
                char c = (char) (upper + 'A' - offset);
                return String.valueOf(c);
            }
        }

        return "";
    }
}
