package com;

import java.util.*;
import java.util.stream.IntStream;

public class SyntaxCheatSheet {

    public static void main(String[] args) {

        // create empty array of X length - all elems initialized to type default (0, false, null)
        double[] doubles = new double[2];
        int[] ints = new int[5];
        String[] strings = new String[1];

        // create and init array
        int[] myIntArray = {1, 2, 3};
        int [] myIntArray2 = IntStream.rangeClosed(0, 100).toArray(); // From 0 to 100
        int [] myIntArray3 =IntStream.of(12,25,36,85,28,96,47).sorted().toArray(); // Sort

        // String to char[] ?
        // 1) -> "someStr".toCharArray();
        // 2) -> like below
        String s = "someStr";
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            char currFirst = s.charAt(left);
            char currLast = s.charAt(right);
            // ...
            left++;
            right--;
        }

        // char to code point? (int) 'K'
        // string or char to int?
        System.out.println('9' - '0');  // 9 as int
        System.out.println('b' - 'a');  // 1 - the ASCII code point of char 'b' (98-97=1)
        // or
        int explicitlyConverted = Character.getNumericValue(s.charAt(0));
        // or
        int firstDigit = Character.getNumericValue(String.valueOf(123).charAt(0));

        // char[] to List<Character>
        List<Character> chars = "aeiou".chars().mapToObj(c -> (char) c).toList();

        // Unique or duplicates? Think HashSet or HashMap

        // Frequency?
        // -> Frequency array for small inputs / constraints
        // -> Otherwise HashMap


        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(1, 3, 5, 7, 9));

        // Backward Iteration (just treeSet for forward)
        System.out.println("TreeSet Backward:");
        for (Integer num : treeSet.descendingSet()) {
            System.out.println(num);
        }

        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "One");
        treeMap.put(3, "Three");
        treeMap.put(5, "Five");

        // Backward Iteration (forward without .descendingMap())
        System.out.println("\nTreeMap Backward:");
        for (Map.Entry<Integer, String> entry : treeMap.descendingMap().entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
