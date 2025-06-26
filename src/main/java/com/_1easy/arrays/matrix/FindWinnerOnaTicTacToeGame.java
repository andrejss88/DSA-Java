package com._1easy.arrays.matrix;

import java.util.Arrays;

/**
 * 1275
 * Example 1:
 * Input: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
 * Output: "A"
 * Explanation: A wins, they always play first.
 * <p>
 * Example 2:
 * Input: moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
 * Output: "B"
 * Explanation: B wins.
 */
public class FindWinnerOnaTicTacToeGame {

    public static void main(String[] args) {
        String result = tictactoe(new int[][]{
                {0, 0}, {2, 0}, {1, 1}, {2, 1}, {2, 2}
        });
        System.out.println(result);
        String result2 = tictactoe(new int[][]{
                {0, 0}, {1, 1}, {0, 1}, {0, 2}, {1, 0}, {2, 0}
        });
        System.out.println(result2);
        String result3 = tictactoe(new int[][]{
                {2, 2}, {1, 2}, {2, 1}, {1, 1}, {2, 0}
        });
        System.out.println(result3);
    }

    // Beats 100%
    public static String tictactoe(int[][] moves) {

        int movesLen = moves.length;
        char A = 'A';
        char B = 'B';
        String aString = "A";
        String bString = "B";
        String draw = "Draw";
        String pending = "Pending";

        char[][] matrix = new char[3][3];

        // with a loop over moves, place A and B alternately
        for (int i = 0; i < movesLen; i++) {
            int[] move = moves[i];
            int x = move[0];
            int y = move[1];
            if (i % 2 == 0) {
                matrix[x][y] = A;
            } else {
                matrix[x][y] = B;
            }
        }

        System.out.println(Arrays.deepToString(matrix));

        // now validate
        // if moves < 5 -> Pending (impossible to finish in 4 moves)
        if (movesLen < 5) return pending;

        // loop row-by-row - check if A or B wins
        for (int i = 0; i < 3; i++) {
            // check rows (horizontal)
            char hCell1 = matrix[i][0];
            char hCell2 = matrix[i][1];
            char hCell3 = matrix[i][2];

            if (hCell1 == A && hCell2 == A && hCell3 == A) return aString;
            if (hCell1 == B && hCell2 == B && hCell3 == B) return bString;

            // check columns (vertical)
            char vCell1 = matrix[0][i];
            char vCell2 = matrix[1][i];
            char vCell3 = matrix[2][i];

            if (vCell1 == A && vCell2 == A && vCell3 == A) return aString;
            if (vCell1 == B && vCell2 == B && vCell3 == B) return bString;
        }

        // check diagonal \
        char dCell1 = matrix[0][0];
        char dCell2 = matrix[1][1];
        char dCell3 = matrix[2][2];

        if (dCell1 == A && dCell2 == A && dCell3 == A) return aString;
        if (dCell1 == B && dCell2 == B && dCell3 == B) return bString;

        // check diagonal /
        char dCell4 = matrix[0][2];
        char dCell5 = matrix[1][1];
        char dCell6 = matrix[2][0];

        if (dCell4 == A && dCell5 == A && dCell6 == A) return aString;
        if (dCell4 == B && dCell5 == B && dCell6 == B) return bString;

        // check for empty
        char nul = '\u0000';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char cell = matrix[i][j];
                if (cell == nul) return pending;
            }
        }

        return draw;
    }
}
