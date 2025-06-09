package com._1easy.strings;

/**
 * 2042
 * <p>
 * Input: s = "1 box has 3 blue 4 red 6 green and 12 yellow marbles"
 * Output: true
 * Explanation: The numbers in s are: 1, 3, 4, 6, 12.
 * They are strictly increasing from left to right: 1 < 3 < 4 < 6 < 12.
 * Example 2:
 * <p>
 * Input: s = "hello world 5 x 5"
 * Output: false
 * Explanation: The numbers in s are: 5, 5. They are not strictly increasing.
 */
public class CheckIfNumbersAreAscendingInSentence {

    public static void main(String[] args) {
        System.out.println(areNumbersAscending2("a puppy has 2 eyes and 4 legs"));  // true
        System.out.println(areNumbersAscending2("1 2"));  // true
        System.out.println(areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles"));  // true
        System.out.println(areNumbersAscending("hello world 5 x 5"));  // false
        System.out.println(areNumbersAscending("2 happy 2 ice days"));  // false
        System.out.println(areNumbersAscending("t j r i m a v 7 x k e k w m f y d x c f m s t p n l m j b l r b h b f h y l d n o v h z v o g f k o c " +
                "s r j m y m y n f m z u y i v z p g e l e p e p q r r d x f p b s j n x v t i s h r y u y a b y 6"));
    }

    // NOT my solution - with a bit of logic,
    // it's enough to check if the FIRST char is a number
    public static boolean areNumbersAscendingSimplest(String s) {

        int previous = 0;
        String[] words = s.split(" ");

        for (String str : words) {
            if (Character.isDigit(str.charAt(0))) {  // guaranteed to be a number
                int number = Integer.parseInt(str);

                if (number <= previous)
                    return false;

                previous = number;
            }
        }
        return true;
    }

    // also 1ms
    public static boolean areNumbersAscending2(String s) {

        String[] words = s.split(" ");

        int max = 0;
        for (String word : words) {

            if (word.length() > 2) continue;

            int latest = 0;
            if (word.length() == 1 && Character.isDigit(word.charAt(0))) {
                latest = Integer.parseInt(word);
                // word length is exactly 2, no need to check it
            } else if (Character.isDigit(word.charAt(0)) && Character.isDigit(word.charAt(1))) {
                latest = Integer.parseInt(word);
            } else {
                continue;
            }

            if (latest <= max) return false;
            max = latest;
        }

        return true;
    }

    // 1ms, Beats Runtime 90%
    public static boolean areNumbersAscending(String s) {

        var sb = new StringBuilder();
        int max = 0;
        // check all but the last letter
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            int currentNum;

            // if last letter - check separately
            if (Character.isDigit(letter) && i == s.length() - 1) {
                sb.append(letter);
                currentNum = Integer.parseInt(sb.toString());
                return currentNum > max;
            }

            if (Character.isDigit(letter)) {
                char nextLetter = s.charAt(i + 1);
                if (Character.isDigit(nextLetter)) {
                    sb.append(letter).append(nextLetter);
                    i++;
                } else {
                    sb.append(letter);
                }
                currentNum = Integer.parseInt(sb.toString());

                if (currentNum <= max) return false;
                max = currentNum;
                sb.setLength(0);
            }
        }
        return true;
    }
}

