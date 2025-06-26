package com._1easy.hashtables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InterSectionOfMultipleArrays {

    public static void main(String[] args) {
        System.out.println(intersectionFaster(new int[][]{
                {3, 1, 2, 4, 5},
                {1, 2, 3, 4},
                {3, 4, 5, 6}
        }));
    }

    // NOT my solution - 2ms, Beats 99%
    public static List<Integer> intersectionFaster(int[][] nums) {
        List<Integer> ans = new ArrayList<>();
        int[] count = new int[1001];
        for (int[] arr : nums)
            for (int i : arr)
                count[i]++;

        for (int i = 0; i < count.length; i++)
            // smart - build a 1D freq Array, and check if value == length of input matrix (ie num of cols)
            if (count[i] == nums.length)
                ans.add(i);

        return ans;
    }

    // 4ms, Beats 75%
    public static List<Integer> intersection(int[][] nums) {

        int matrixLen = nums.length;
        boolean[][] matrix = new boolean[matrixLen][1001];

        for (int i = 0; i < matrixLen; i++) {
            int[] row = nums[i];
            for (int j = 0; j < row.length; j++) {
                int position = nums[i][j];
                matrix[i][position] = true;
            }
            System.out.println();
        }
        System.out.println(Arrays.deepToString(matrix));


//        These two columns (indexes 3 and 4) are the
//        only ones that have only "true", hence the intersection
//[                       |   |
//[false, true,  true, true, true, true,  false],
//[false, true,  true, true, true, false, false],
//[false, false, false,true, true, true,  true]
//]

        List<Integer> list = new ArrayList<>();
        int numCols = matrix[0].length;
        for (int col = 0; col < numCols; col++) {
            boolean allTrue = true;             // numCols is length of any row (assuming same length)
            for (boolean[] booleans : matrix) { // numRows is length of matrix
                boolean value = booleans[col];
                if (!value) {  // if false - move to next col
                    allTrue = false;
                    break;
                }
            }
            if (allTrue) list.add(col);
        }
        return list;
    }
}
