package com._2easy.arrays;

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

        // String to char[] ? -> "someStr".toCharArray();
    }
}
