package com.patterns;

public class MatrixTraversal {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Column first");
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        // outer loop iterates over columns and the inner loop iterates over rows
        for (int col = 0; col < numCols; col++) {     // numCols is length of any row (assuming same length)
            for (int row = 0; row < numRows; row++) { // numRows is length of matrix
                System.out.print(matrix[row][col] + " ");
            }
        }

        System.out.println("\nRow first");
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
        }
    }
}
