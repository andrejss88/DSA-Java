package com._1warmup.misc;

public class SmallestEvenMultiple2413 {

    // Given a positive integer n, return the smallest positive integer
    // that is a multiple of both 2 and n (itself).

    public static int smallestEvenMultiple(int n) {
        if(n % 2 == 0) {
            return n;
        }
        return n * 2;
    }

}
