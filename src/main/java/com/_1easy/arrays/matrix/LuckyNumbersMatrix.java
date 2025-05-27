package com._1easy.arrays.matrix;

import java.util.*;

public class LuckyNumbersMatrix {

//    [
//    [3, 7, 8],
//    [9, 13,11],
//    [15,16,17]  min in row, max in column
//    ]

//[
// [1,10,4,2],
// [9,3,8,7],
// [15,16,17,12]
// ]

    public static void main(String[] args) {
        var result = luckyNumbers3(new int[][]{
                        {3, 7, 8},
                        {9, 13, 11},
                        {15, 16, 17}

//                {1, 10, 4, 2},
//                {9, 3, 8, 7},
//                {15, 16, 17, 12}
                }
        );
        System.out.println(result);

        System.out.println("========== Min Val and Index ==========");
        findMinValAndIndex(new int[]{1, 10, 4, 2}); // 1:0
        findMinValAndIndex(new int[]{9, 3, 8, 7});  // 3:1
        findMinValAndIndex(new int[]{15, 16, 17, 12});  // 12:3

    }

    static void findMinValAndIndex(int[] row) {
        int minVal = row[0];
        int minIndex = 0;

        for (int i = 1; i < row.length; i++) {
            if (row[i] < minVal) { // find new min value
                minVal = row[i];
                minIndex = i;
            }
        }
        // update array at END
        System.out.println(minVal + " : " + minIndex);
    }

    // NOT MY solution (made minor improvements)
    // Similar but better: once we find minVal and its index
    // determine lucky number WITHOUT leaving the main loop
    // 1ms, Runtime beats 95%, Memory beats 41%
    public static List<Integer> luckyNumbers3(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int rowLength = matrix[0].length;

        for (int[] row : matrix) {
            // Find the min in each row
            // Assume 1st el is min, override later
            int rowMin = row[0];
            int rowMinIndex = 0;
            // start from 2nd el
            for (int j = 1; j < rowLength; j++) {
                if (row[j] < rowMin) {
                    rowMin = row[j];
                    rowMinIndex = j;
                }
            }

            // Check if the min element in row is max in its column
            boolean isLucky = true;
            for (int[] matrixRow : matrix) {
                if (matrixRow[rowMinIndex] > rowMin) {
                    isLucky = false;
                    break;  // without break, runtime down to 2ms
                }
            }

            if (isLucky) {
                ans.add(rowMin);
            }
        }

        return ans;
    }

    // same high-level logic - first collect mins and their indexes, then loop again and exclude
    // 6ms, Runtime beats 10%, Memory beats 76%
    public static List<Integer> luckyNumbers2(int[][] matrix) {
        int[] mins = new int[matrix.length];
        int[] minIndexes = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];

            // assume 1st value in row is min, override below
            int minVal = row[0];
            int minIndex = 0;

            // loop over row, start with 2nd val
            for (int j = 1; j < row.length; j++) {
                if (row[j] < minVal) { // find new min value
                    minVal = row[j];
                    minIndex = j;
                }
            }
            // now we're done with row, update mins and minIndx
            mins[i] = minVal;
            minIndexes[i] = minIndex;
        }

        // loop over both mins and minIndexes
        // same length, and val->index may be assumed
        for (int m = 0; m < mins.length; m++) {
            int luckyNumCandidate = mins[m];
            int contenderIndex = minIndexes[m];

            for (int[] row : matrix) {
                int other = row[contenderIndex];
                if (luckyNumCandidate < other) {
                    mins[m] = 0; // 0 means NOT a lucky number due to constraint 1<= x <= 10^5
                }
            }
        }

        // now we have a mins array with 0's that we must filter out
        // no way to avoid at least ONE conversion to a List<Integer>
        return Arrays.stream(mins).boxed().filter(i -> i != 0).toList();
    }


    // 9ms, Runtime beats 7.36%, Memory beats 41%
    public static List<Integer> luckyNumbers(int[][] matrix) {
        // collect MIN values from every row together with their position (index)
        // e.g. 3->0 is value 3 at index 0 in some row
        Map<Integer, Integer> minValuesWithIndices = new HashMap<>();
        for (int[] row : matrix) {
            int minValue = 100_000;
            for (int i = 0; i < row.length; i++) {
                if (row[i] < minValue) {
                    minValuesWithIndices.remove(minValue);
                    minValue = row[i];
                    minValuesWithIndices.put(row[i], i);
                }
            }
        }

        // extract only the MIN values - these are candidates to become Lucky Numbers
        Set<Integer> luckyNumCandidates = new HashSet<>(minValuesWithIndices.keySet());
        for (Map.Entry<Integer, Integer> entry : minValuesWithIndices.entrySet()) {
            Integer luckyNumCandidate = entry.getKey();
            Integer contenderIndex = entry.getValue();

            for (int[] row : matrix) {
                int other = row[contenderIndex];
                // if, at any point, the candidate is LESS than another value in the same column
                // then it's not MAX in column, therefore candidate is not a lucky num
                if (luckyNumCandidate < other) {
                    luckyNumCandidates.remove(luckyNumCandidate);
                }
            }
        }

        return luckyNumCandidates.stream().toList();
    }
}
