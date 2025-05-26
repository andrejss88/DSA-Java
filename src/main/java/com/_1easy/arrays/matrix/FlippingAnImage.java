package com._1easy.arrays.matrix;

import java.util.Arrays;

/**
 * 832
 * Given an n x n binary matrix image, flip the image horizontally, then invert it, and return the resulting image.
 * <p>
 * To flip an image horizontally means that each row of the image is reversed.
 * For example, flipping [1,1,0] horizontally results in [0,1,1].
 * <p>
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
 * For example, inverting [0,1,1] results in [1,0,0].
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: image = [[1,1,0],[1,0,1],[0,0,0]]
 * Output: [[1,0,0],[0,1,0],[1,1,1]]
 * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
 * Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
 */
public class FlippingAnImage {

    public static void main(String[] args) {
        // 0, 1, 1
        System.out.println(Arrays.toString(flip(new int[]{1, 1, 0})));

        // 0,0,1,1
        System.out.println(Arrays.toString(flip(new int[]{1, 1, 0, 0})));

        // 0, 1, 1
        System.out.println(Arrays.toString(invert(new int[]{1, 0, 0})));
    }


    // 0ms, Runtime beats 100%, Memory beats 95%
    public static int[][] flipAndInvertImage(int[][] image) {

        int[][] flippedAndInverted = new int[image.length][image.length];

        for (int i = 0; i < image.length; i++) {
            int[] flipped = flip(image[i]);
            int[] finalState = invert(flipped);
            flippedAndInverted[i] = finalState;
        }
        return flippedAndInverted;
    }

    private static int[] invert(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            if (value == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }

        return arr;
    }

    private static int[] flip(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        int tempLeft;
        int tempRight;

        while (left <= right) {
            tempLeft = arr[left];
            tempRight = arr[right];

            arr[left] = tempRight;
            arr[right] = tempLeft;

            left++;
            right--;
        }
        return arr;
    }

}
